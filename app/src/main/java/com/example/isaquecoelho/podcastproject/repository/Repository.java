package com.example.isaquecoelho.podcastproject.repository;

import com.example.isaquecoelho.podcastproject.model.Participant;
import com.example.isaquecoelho.podcastproject.model.Podcast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository {

    private static List<Podcast> mPodcastList = new ArrayList<>();
    private List<Participant> mParticipantList = new ArrayList<>();

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
        mParticipantList.clear();
        startPodcastList();
    }

    private void buildPodcastList(){

        mPodcastList.add(new Podcast(
                "Especial RPG - O Bruxo, a Princesa e o Dragão",
                "18/03/2011",
                "01 hour e 39 minutes",
                "JovemNerd",
                "Medieval",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Duque, a Rosa e o Beholder",
                "23/12/2011",
                "02 hours and 15 minutes",
                "JovemNerd",
                "Medieval",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Corvo, a Piriguete e o Bucentauro",
                "14/12/2012",
                "02 hours and 41 minutes",
                "JovemNerd",
                "Medieval",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O grande assalto",
                "28/12/2013",
                "02 hours and 36 minutes",
                "JovemNerd",
                "Cyberpunk",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O Passageiro do Futuro",
                "26/12/2014",
                "02 hours and 09 minutes",
                "JovemNerd",
                "Cyberpunk",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - Estrada para o inferno",
                "08/01/2016",
                "01 hour and 39 minutes",
                "JovemNerd",
                "Cyberpunk",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O mistério de Willian Faraday",
                "07/01/2017",
                "02 hours and 41 minutes",
                "JovemNerd",
                "Call of Cthulhu",
                0,
                null,
                null));

        mPodcastList.add(new Podcast(
                "Especial RPG - O horror do Necronomicon",
                "12/01/2018",
                "02 hours and 58 minutes",
                "JovemNerd",
                "Call of Cthulhu",
                0,
                null,
                null));
    }

    private List<Participant> getRpgParticipant(int rpgVersion) {

        final int FIRST_PODACAST = 1;
        final int SECOND_PODACAST = 2;
        final int THIRD_PODACAST = 3;
        final int FOURTH_PODACAST = 4;
        final int FIFITH_PODACAST = 5;
        final int SIXTH_PODACAST = 6;
        final int SEVENTH_PODACAST = 7;
        final int EIGHT_PODACAST = 8;

        List<Participant> participantList = mParticipantList;

        for (int countParticipant = 0; countParticipant < mParticipantList.size(); countParticipant++) {

            switch (rpgVersion){
                case FIRST_PODACAST:
                    if(countParticipant > 5) { participantList.remove(countParticipant); }
                    break;
                case SECOND_PODACAST:
                    if(countParticipant == 4 || countParticipant >= 8){ participantList.remove(countParticipant); }
                    break;
                case THIRD_PODACAST:
                    if(countParticipant == 4 || countParticipant > 7){ participantList.remove(countParticipant); }
                    break;
                case FOURTH_PODACAST:
                    if(countParticipant == 4 || countParticipant == 7 || countParticipant == 9){ participantList.remove(countParticipant); }
                    break;
                case FIFITH_PODACAST:
                    if(countParticipant == 4){ participantList.remove(countParticipant); }
                    break;
                case SIXTH_PODACAST:
                    if(countParticipant == 4 || countParticipant == 7 || countParticipant == 9){ participantList.remove(countParticipant); }
                    break;
                case SEVENTH_PODACAST:
                    if(countParticipant == 3 || countParticipant == 4 || countParticipant == 7 || countParticipant == 8){
                        participantList.remove(countParticipant);
                    }
                    break;
                case EIGHT_PODACAST:
                    if(countParticipant == 3 || countParticipant == 4 || countParticipant == 7 || countParticipant == 8){
                        participantList.remove(countParticipant);
                    }
                    break;
            }
        }

        return participantList;
    }

    private void buildParticipantList(){
        mParticipantList.add(new Participant("Allotoni","https://twitter.com/jovemnerd"));
        mParticipantList.add(new Participant("Azaghal","https://twitter.com/azaghal"));
        mParticipantList.add(new Participant("Carlos Voltor","https://twitter.com/carlosvoltor"));
        mParticipantList.add(new Participant("JP","https://twitter.com/jp_miguel"));
        mParticipantList.add(new Participant("Eduardo Spohr","https://twitter.com/eduardospohr"));
        mParticipantList.add(new Participant("Tucano","https://twitter.com/cancerjack"));
        mParticipantList.add(new Participant("Rex","https://twitter.com/rex2099"));
        mParticipantList.add(new Participant("Tresde","https://twitter.com/afonso3d"));
        mParticipantList.add(new Participant("Android",null));
        mParticipantList.add(new Participant("Leonel Caldela","https://twitter.com/leonelcaldela"));
    }

    private void settingPlaylistAndParticipant(){

        List<Podcast> podcastList = new ArrayList<>();
        for (int countPodcast = 0; countPodcast < mPodcastList.size(); countPodcast++) {

            podcastList.clear();
            mPodcastList.get(countPodcast).setPodcastParticipantList(getRpgParticipant(countPodcast + 1));

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

    public List<Podcast> getRandomPodcastList(){
        Collections.shuffle(mPodcastList);
        return mPodcastList;
    }
}
