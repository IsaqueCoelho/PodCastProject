package com.example.isaquecoelho.podcastproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaquecoelho.podcastproject.R;
import com.example.isaquecoelho.podcastproject.adapter.PodcastAdapter;
import com.example.isaquecoelho.podcastproject.model.Podcast;
import com.example.isaquecoelho.podcastproject.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PodcastPlayActivity extends AppCompatActivity {

    @BindView(R.id.imageview_podcastplay_banner)
    ImageView mImageViewBanner;

    @BindView(R.id.textview_podcastplay_date)
    TextView mTextViewDate;

    @BindView(R.id.textview_podcastplay_title)
    TextView mTextViewTitle;

    @BindView(R.id.textview_podcastplay_theme)
    TextView mTextViewTheme;

    @BindView(R.id.textview_podcastplay_duration)
    TextView mTextViewDuration;

    @BindView(R.id.textview_podcastplay_author)
    TextView mTextViewAuthor;

    @BindView(R.id.textview_podcastplay_participants)
    TextView mTextViewParticipants;

    @BindView(R.id.recyclerView_podcastplay_playlist)
    RecyclerView mRecyclerViewPlayList;

    @BindView(R.id.fab_podcastplay_back)
    FloatingActionButton mFloatingActionButtonBack;

    private Podcast mPodcast;
    private PodcastAdapter mPodcastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_play);
        ButterKnife.bind(this);

        settingPodcast();
        settingView();
    }

    private void settingPodcast() {
        final String EXTRA_POSITION = "POSITION_PODCAST";
        final int POSITION_PODCAST = getIntent().getIntExtra(EXTRA_POSITION, 0);
        //Repository repository = new Repository();

        mPodcast = Repository.getmPodcastList().get(POSITION_PODCAST);
    }

    private void settingView() {
        mImageViewBanner.setImageResource(mPodcast.getPodcastBanner());
        mTextViewDate.setText(mPodcast.getPodcastDate());
        mTextViewTitle.setText(mPodcast.getPodcastTitle());
        mTextViewTheme.setText(mPodcast.getPodcastTheme());
        mTextViewDuration.setText(mPodcast.getPodcastDuration());
        mTextViewAuthor.setText(mPodcast.getPodcastAutor());
        //mTextViewParticipants.setText(getParticipants());

        populateAdapter();
    }

    private String getParticipants() {

        String podcastParticipants = "";

        for (int countParticipant = 0; countParticipant < mPodcast.getPodcastParticipantList().size(); countParticipant++) {

            String participant =
                    mPodcast.getPodcastParticipantList().get(countParticipant).getName()
                            + "(" + mPodcast.getPodcastParticipantList().get(countParticipant).getSocialMedia()
                            + ");";

            podcastParticipants += participant + "\n";
        }

        return podcastParticipants;
    }



    private void populateAdapter() {

        Repository.setmPodcastList(mPodcast.getPodcastPlaylist());

        mPodcastAdapter = new PodcastAdapter(mPodcast.getPodcastPlaylist(), new PodcastAdapter.PodcastItemOnClickListener() {
            @Override
            public void onClick(int position) {
                mPodcast = Repository.getmPodcastList().get(position);
                settingView();
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewPlayList.setLayoutManager(linearLayoutManager);
        mRecyclerViewPlayList.setAdapter(mPodcastAdapter);
    }

    private void updatePodcast(int position) {




    }
}
