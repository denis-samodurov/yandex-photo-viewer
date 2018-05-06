package com.denissamodurov.yandexphotoviewer.main_page;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.denissamodurov.yandexphotoviewer.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void initialize() {
        activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
    }

    @Test
    public void shouldUseApplicationLabelFromManifestAsTitleForActivity() throws Exception {
        Assert.assertNotNull(activity.getTitle());
        Assert.assertEquals(activity.getTitle().toString(), activity.getString(R.string.app_name));
    }

    @Test
    public void setupViewPagerTest(){
        ViewPager viewPager = activity.findViewById(R.id.content_main_pager);
        PagerAdapter adapter = viewPager.getAdapter();
        Assert.assertNotNull("Adapter should be initialized", adapter);
        Assert.assertEquals("Wrong number of the tabs", adapter.getCount(), 4);
    }
}