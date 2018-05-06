package com.denissamodurov.yandexphotoviewer.main_page;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.denissamodurov.yandexphotoviewer.R;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.MockPictureService;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.PictureModel;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.PictureService;
import com.denissamodurov.yandexphotoviewer.main_page.adapter.ViewPagerAdapter;
import com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments.AllFileFragment;
import com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments.FileFragment;
import com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments.OfflineFragment;
import com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments.StripFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StripFragment mStripFragment = new StripFragment();
    private FileFragment mFileFragment = new FileFragment();
    private AllFileFragment mAllFileFragment = new AllFileFragment();
    private OfflineFragment mOfflineFragment = new OfflineFragment();

    private ProgressBar mProgressBar;
    private PictureService mPictureService;
    private PictureTask mPictureTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        mProgressBar = findViewById(R.id.content_main_progress_bar);
        FloatingActionButton fab = findViewById(R.id.main_activity_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupServices();
        setupViewPager();
        setupData();
    }

    private void setupServices() {
        mPictureService = new MockPictureService(this);
    }

    private void setupViewPager() {
        ViewPager viewPager = findViewById(R.id.content_main_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(mStripFragment, getString(R.string.strip));
        adapter.addFragment(mFileFragment, getString(R.string.files));
        adapter.addFragment(mAllFileFragment, getString(R.string.all_files));
        adapter.addFragment(mOfflineFragment, getString(R.string.offline));
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.content_main_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupData() {
        mPictureTask = new PictureTask();
        mPictureTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class PictureTask extends AsyncTask<Void, Void, List<PictureModel>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<PictureModel> doInBackground(Void... params) {
            List<PictureModel> allPicture = mPictureService.getAllPicture();
            return allPicture;
        }

        @Override
        protected void onPostExecute(List<PictureModel> result) {
            mStripFragment.setPictureModels(result);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
