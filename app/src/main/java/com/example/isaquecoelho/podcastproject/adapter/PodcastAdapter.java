package com.example.isaquecoelho.podcastproject.adapter;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isaquecoelho.podcastproject.R;
import com.example.isaquecoelho.podcastproject.model.Podcast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {

    private List<Podcast> mPodcastList;
    private PodcastItemOnClickListener mPodcastItemOnClickListener;

    public PodcastAdapter(List<Podcast> mPodcastList, PodcastItemOnClickListener mPodcastItemOnClickListener) {
        this.mPodcastList = mPodcastList;
        this.mPodcastItemOnClickListener = mPodcastItemOnClickListener;
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View podcastView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_podcast, viewGroup, false);
        return new PodcastViewHolder(podcastView);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastViewHolder podcastViewHolder, final int position) {
        Podcast podcast = mPodcastList.get(position);

        podcastViewHolder.mTextViewTitle.setText(podcast.getPodcastTitle());
        podcastViewHolder.mTextViewDuration.setText(podcast.getPodcastDuration());
        podcastViewHolder.mTextViewTheme.setText(podcast.getPodcastTheme());
        podcastViewHolder.mFloatingActionButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPodcastItemOnClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPodcastList.size();
    }

    class PodcastViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textview_title)
        TextView mTextViewTitle;

        @BindView(R.id.textview_duration)
        TextView mTextViewDuration;

        @BindView(R.id.textview_theme)
        TextView mTextViewTheme;

        @BindView(R.id.fab_play)
        FloatingActionButton mFloatingActionButtonPlay;

        PodcastViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface PodcastItemOnClickListener{
        void onClick(int position);
    }
}
