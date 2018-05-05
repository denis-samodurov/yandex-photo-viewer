package com.denissamodurov.yandexphotoviewer.main_page.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewPagerAdapterTest {
    private ViewPagerAdapter adapter;

    @Before
    public void initialize() {
        AppCompatActivity activity = Robolectric.buildActivity(AppCompatActivity.class).create().start().resume().get();
        adapter = new ViewPagerAdapter(activity.getSupportFragmentManager());
    }

    @Test
    public void addFragment() throws Exception {
        Fragment fragment = new Fragment();
        String fragmentTitle = "First";
        adapter.addFragment(fragment, fragmentTitle);

        Assert.assertEquals("Error in the fragment list, during adding new fragment",
                adapter.getItem(0), fragment);
        Assert.assertEquals("Error in the title list, during adding new fragment",
                adapter.getPageTitle(0), fragmentTitle);
    }

    @Test
    public void getItem() throws Exception {
        Assert.assertNotNull("Incorrect at negative index",
                adapter.getItem(-1));
        Assert.assertNotNull("Incorrect at index out of list",
                adapter.getItem(1));

        Fragment fragment = new Fragment();
        adapter.addFragment(fragment, "First");

        Assert.assertEquals("Get incorrect fragment",
                adapter.getItem(0), fragment);
    }

    @Test
    public void getCount() throws Exception {
        Fragment fragment1 = new Fragment();
        Fragment fragment2 = new Fragment();

        adapter.addFragment(fragment1, "First");
        adapter.addFragment(fragment2, "First");

        Assert.assertEquals("Incorrect fragment list size", adapter.getCount(), 2);
    }

    @Test
    public void getPageTitle() throws Exception {
        Assert.assertEquals("Incorrect at negative index",
                adapter.getItem(-1), null);
        Assert.assertEquals("Incorrect at index out of list",
                adapter.getItem(1), null);

        Fragment fragment = new Fragment();
        adapter.addFragment(fragment, "First");

        Assert.assertEquals("Get incorrect fragment",
                adapter.getPageTitle(0), "First");
    }

}