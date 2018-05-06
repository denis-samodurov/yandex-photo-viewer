package com.denissamodurov.yandexphotoviewer.main_page;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.denissamodurov.yandexphotoviewer.R;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.PictureModel;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.PictureService;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.YandexDiscPictureService;
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
                Toast.makeText(view.getContext(), view.getContext().getString(R.string.add_image),
                        Toast.LENGTH_SHORT).show();
            }
        });

        setupServices();
        setupViewPager();
        setupData();
    }

    private void setupServices() {
        mPictureService = new YandexDiscPictureService(this);
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
        PictureTask pictureTask = new PictureTask();
        pictureTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    class PictureTask extends AsyncTask<Void, Void, List<PictureModel>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<PictureModel> doInBackground(Void... params) {
            return mPictureService.getAllPicture();
        }

        @Override
        protected void onPostExecute(List<PictureModel> result) {
            mStripFragment.setPictureModels(result);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
