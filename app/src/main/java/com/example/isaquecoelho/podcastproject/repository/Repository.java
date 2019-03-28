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
    }

    public void startPodcastList(){
        mPodcastList.clear();
        buildPodcastList();
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

    public void settingParticipantList(int position){

        List<Participant> podcastParticipantList = new ArrayList<>();
        List<Participant> allParticipantList = getAllParticipant();

        for (int countPartcipant = 0; countPartcipant < allParticipantList.size(); countPartcipant++) {
            switch (position){
                case 0:
                    if(countPartcipant < 5 || countPartcipant == 9){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 1:
                    if(countPartcipant < 6 || countPartcipant == 7){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 2:
                    if(countPartcipant < 6 || countPartcipant == 9){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 3:
                    if(countPartcipant < 7){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 4:
                    if(countPartcipant < 8){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 5:
                    if(countPartcipant < 7 || countPartcipant == 10){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 6:
                    if(countPartcipant < 3 || countPartcipant == 4 || countPartcipant == 5){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
                case 7:
                    if(countPartcipant < 3 || countPartcipant == 4 || countPartcipant == 5){
                        podcastParticipantList.add(allParticipantList.get(countPartcipant));
                    }
                    break;
            }
        }
        mPodcastList.get(position).setPodcastParticipantList(podcastParticipantList);
    }

    private List<Participant> getAllParticipant(){
        List<Participant> podcastParticipantList = new ArrayList<>();

        podcastParticipantList.add(new Participant("Allotoni","@jovemnerd"));
        podcastParticipantList.add(new Participant("Azaghal","@azaghal"));
        podcastParticipantList.add(new Participant("Carlos Voltor","@carlosvoltor"));
        podcastParticipantList.add(new Participant("JP","@jp_miguel"));
        podcastParticipantList.add(new Participant("Tucano","@cancerjack"));
        podcastParticipantList.add(new Participant("Rex","@rex2099"));
        podcastParticipantList.add(new Participant("Android",null));
        podcastParticipantList.add(new Participant("Tresde","@afonso3d"));
        podcastParticipantList.add(new Participant("Leonel Caldela","@leonelcaldela"));
        podcastParticipantList.add(new Participant("Eduardo Spohr","@eduardospohr"));
        podcastParticipantList.add(new Participant("Sr. K","@sr_k_"));

        return podcastParticipantList;
    }

    public static List<Podcast> getmPodcastList() {
        return mPodcastList;
    }

    public void getRandomPodcastList(){
        Collections.shuffle(mPodcastList);
    }

    public void settingPlaylist(int position_podcast) {

        List<Podcast> podcastPlaylist = new ArrayList<>();

        String podacastTheme = mPodcastList.get(position_podcast).getPodcastTheme();
        String podcastTitle = mPodcastList.get(position_podcast).getPodcastTitle();

        for (Podcast podcastItem: mPodcastList) {

            if( podcastItem.getPodcastTheme().equalsIgnoreCase( podacastTheme )
                    && !podcastItem.getPodcastTitle().equalsIgnoreCase( podcastTitle )){
                podcastPlaylist.add(podcastItem);
            }
        }

        mPodcastList.get(position_podcast).setPodcastPlaylist(podcastPlaylist);

    }
}
