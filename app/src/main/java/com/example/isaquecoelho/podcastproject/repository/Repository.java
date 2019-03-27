package com.example.isaquecoelho.podcastproject.repository;

import com.example.isaquecoelho.podcastproject.R;
import com.example.isaquecoelho.podcastproject.model.Participant;
import com.example.isaquecoelho.podcastproject.model.Podcast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository {

    private static List<Podcast> mPodcastList = new ArrayList<>();

    public Repository() {
        buildPodcastList();
        buildParticipantList();
    }

    public void startPodcastList(){
        buildPodcastList();
        buildParticipantList();
        settingPlaylistAndParticipant();
    }

    public void restartPodcastList(){
        mPodcastList.clear();
        startPodcastList();
    }

    private void buildPodcastList(){

        mPodcastList.add(new Podcast(
                "Especial RPG - O Bruxo, a Princesa e o Dragão",
                "18/03/2011",
                "01h and 39 min",
                "JovemNerd",
                "Medieval",
                R.drawable.ic_nc_first_medieval,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Duque, a Rosa e o Beholder",
                "23/12/2011",
                "02h and 15 min",
                "JovemNerd",
                "Medieval",
                R.drawable.ic_nc_second_medieval,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Corvo, a Piriguete e o Bucentauro",
                "14/12/2012",
                "02h and 41 min",
                "JovemNerd",
                "Medieval",
                R.drawable.ic_nc_third_medieval,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O grande assalto",
                "28/12/2013",
                "02h and 36 min",
                "JovemNerd",
                "Cyberpunk",
                R.drawable.ic_nc_first_cyberpunk,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Passageiro do Futuro",
                "26/12/2014",
                "02h and 09 min",
                "JovemNerd",
                "Cyberpunk",
                R.drawable.ic_nc_second_cyberpunk,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - Estrada para o inferno",
                "08/01/2016",
                "01h and 39 min",
                "JovemNerd",
                "Cyberpunk",
                R.drawable.ic_nc_third_cyberpunk,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O mistério de Willian Faraday",
                "07/01/2017",
                "02h and 41 min",
                "JovemNerd",
                "Call of Cthulhu",
                R.drawable.ic_nc_first_coc,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O horror do Necronomicon",
                "12/01/2018",
                "02h and 58 min",
                "JovemNerd",
                "Call of Cthulhu",
                R.drawable.ic_nc_second_coc,
                null,
                null));
    }

    private List<Participant> getRpgParticipant(int rpgVersion) {

        List<Participant> participantList = buildParticipantList();

        final int participantListSize = participantList.size();

        for (int countParticipant = 0; countParticipant < participantListSize; countParticipant++) {


        }

        return participantList;
    }

    private List<Participant> buildParticipantList(){
        List<Participant> participantList = new ArrayList<>();

        participantList.add(new Participant("Allotoni","@jovemnerd"));
        participantList.add(new Participant("Azaghal","@azaghal"));
        participantList.add(new Participant("Carlos Voltor","@carlosvoltor"));
        participantList.add(new Participant("JP","@jp_miguel"));
        participantList.add(new Participant("Eduardo Spohr","@eduardospohr"));
        participantList.add(new Participant("Tucano","@cancerjack"));
        participantList.add(new Participant("Rex","@rex2099"));
        participantList.add(new Participant("Tresde","@afonso3d"));
        participantList.add(new Participant("Android",null));
        participantList.add(new Participant("Leonel Caldela","@leonelcaldela"));

        return participantList;
    }

    public void settingPlaylistAndParticipant(){

        List<Podcast> podcastList = new ArrayList<>();
        for (int countPodcast = 0; countPodcast < mPodcastList.size(); countPodcast++) {

            podcastList.clear();
            //mPodcastList.get(countPodcast).setPodcastParticipantList(getRpgParticipant(countPodcast));

            for (int countPlaylist = 0; countPlaylist < mPodcastList.size(); countPlaylist++) {

                if(mPodcastList.get(countPodcast).getPodcastTheme().equals(mPodcastList.get(countPlaylist).getPodcastTheme())){

                    podcastList.add(mPodcastList.get(countPlaylist));

                    mPodcastList.get(countPodcast).setPodcastPlaylist(podcastList);
                }

            }

        }

    }

    public static List<Podcast> getmPodcastList() {
        return mPodcastList;
    }

    public static void setmPodcastList(List<Podcast> mPodcastList) {
        Repository.mPodcastList = mPodcastList;
    }

    public void getRandomPodcastList(){
        Collections.shuffle(mPodcastList);
    }
}
