package com.example.isaquecoelho.podcastproject.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.isaquecoelho.podcastproject.R;
import com.example.isaquecoelho.podcastproject.adapter.PodcastAdapter;
import com.example.isaquecoelho.podcastproject.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static char orderList = 'P';
    private Repository mRepository = new Repository();
    private PodcastAdapter mPodcastAdapter;

    @BindView(R.id.recyclerView_podcastlist)
    RecyclerView mRecyclerViewPodcastList;

    @BindView(R.id.bottomAppBar)
    BottomAppBar mBottomAppBar;

    @BindView(R.id.fab_feedback)
    FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRepository.startPodcastList();
        settingView();
        listeningView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_bottomappbar, menu);

        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.bottomappbar_info:
                showAlertDialogInfo();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void settingView() {
        setSupportActionBar(mBottomAppBar);
        populateAdapter();
    }

    private void listeningView() {

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingFabIcon();
                settingList();
            }
        });
    }

    private void populateAdapter() {

        final String EXTRA_POSITION = "POSITION_PODCAST";

        mPodcastAdapter = new PodcastAdapter(Repository.getmPodcastList(), new PodcastAdapter.PodcastItemOnClickListener() {
            @Override
            public void onClick(int position) {
                Intent podcastPlayIntent = new Intent(MainActivity.this, PodcastPlayActivity.class);
                podcastPlayIntent.putExtra(EXTRA_POSITION, position);
                startActivity(podcastPlayIntent);
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewPodcastList.setLayoutManager(linearLayoutManager);
        mRecyclerViewPodcastList.setAdapter(mPodcastAdapter);
    }

    private void settingFabIcon() {
        switch (orderList){
            case 'P':
                orderList = 'R';
                mFloatingActionButton.setImageDrawable(
                        getResources().getDrawable(R.drawable.ic_round_playlist_play_white_48, getTheme()));
                break;
            case 'R':
                orderList = 'P';
                mFloatingActionButton.setImageDrawable(
                        getResources().getDrawable(R.drawable.ic_round_shuffle_white_48, getTheme()));
        }
    }

    private void settingList() {
        switch (orderList){
            case 'P':
                mRepository.startPodcastList();
                mPodcastAdapter.notifyDataSetChanged();
                break;
            case 'R':
                mRepository.getRandomPodcastList();
                mPodcastAdapter.notifyDataSetChanged();
        }
    }

    private void showAlertDialogInfo(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(getString(R.string.msg_alertdialog_podcastplay))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
