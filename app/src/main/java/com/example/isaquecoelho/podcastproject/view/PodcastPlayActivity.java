package com.example.isaquecoelho.podcastproject.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.isaquecoelho.podcastproject.R;
import com.example.isaquecoelho.podcastproject.adapter.PodcastAdapter;
import com.example.isaquecoelho.podcastproject.model.Podcast;
import com.example.isaquecoelho.podcastproject.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PodcastPlayActivity extends AppCompatActivity {

    @BindView(R.id.scrollview_podcastplay_scroll)
    ScrollView mScrollView;

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
    private Repository mRepository = new Repository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_play);
        ButterKnife.bind(this);

        final String EXTRA_POSITION = "POSITION_PODCAST";
        final int POSITION_PODCAST = getIntent().getIntExtra(EXTRA_POSITION, 0);

        settingPodcast(POSITION_PODCAST);
        populateAdapter();
        listeningView();
    }

    private void settingPodcast(int positionPodcast) {
        mRepository.settingParticipantList(positionPodcast);
        mRepository.settingPlaylist(positionPodcast);
        mPodcast = Repository.getmPodcastList().get(positionPodcast);

        settingView();
    }

    private void settingView() {
        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                mScrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
        mImageViewBanner.setImageResource(mPodcast.getPodcastBanner());
        mTextViewDate.setText(mPodcast.getPodcastDate());
        mTextViewTitle.setText(mPodcast.getPodcastTitle());
        mTextViewTheme.setText(mPodcast.getPodcastTheme());
        mTextViewDuration.setText(mPodcast.getPodcastDuration());
        mTextViewAuthor.setText(mPodcast.getPodcastAutor());
        mTextViewParticipants.setText(getParticipants());
        populateAdapter();
    }

    private void listeningView() {
        mFloatingActionButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getParticipants() {

        StringBuilder podcastParticipants = new StringBuilder();

        for (int countParticipant = 0; countParticipant < mPodcast.getPodcastParticipantList().size(); countParticipant++) {

            String participantName = " - " + mPodcast.getPodcastParticipantList().get(countParticipant).getName();
            String participantSocialMedia =
                    " (" + mPodcast.getPodcastParticipantList().get(countParticipant).getSocialMedia() + ");";

            participantSocialMedia =
                    ( participantSocialMedia.contains("null") ) ? ";" : participantSocialMedia;

            podcastParticipants.append(participantName).append(participantSocialMedia).append("\n");
        }

        return podcastParticipants.toString();
    }

    private void populateAdapter() {

        PodcastAdapter podcastAdapter =
                new PodcastAdapter(mPodcast.getPodcastPlaylist(), new PodcastAdapter.PodcastItemOnClickListener() {
            @Override
            public void onClick(int position) {
                settingNewPodcast(position);
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerViewPlayList.setLayoutManager(linearLayoutManager);
        mRecyclerViewPlayList.setAdapter(podcastAdapter);
    }

    private void settingNewPodcast(int position) {

        for (int countPodcast = 0; countPodcast < Repository.getmPodcastList().size(); countPodcast++) {

            String titlePodcast = mPodcast.getPodcastPlaylist().get(position).getPodcastTitle();

            if( Repository.getmPodcastList().get(countPodcast).getPodcastTitle().equalsIgnoreCase( titlePodcast ) ){
                settingPodcast(countPodcast);
                break;
            }

        }
    }
}
