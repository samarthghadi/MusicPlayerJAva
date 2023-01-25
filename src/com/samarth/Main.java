package com.samarth;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1", "Imagine Dragons");

        album.addSong("Monster", 4.5);
        album.addSong("Sweat", 3.5);
        album.addSong("Work hard", 2.8);
        album.addSong("RadioActive", 5.5);
        albums.add(album);

        Album album2 = new Album("Album2", "Eminem");

        album.addSong("MockingBird", 4.5);
        album.addSong("Rap God", 6.5);
        album.addSong("Not Afraid", 3.8);
        album.addSong("Lose Yourself", 4.5);
        albums.add(album2);

        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addToPlaylist("RadioActive", playList1);
        albums.get(0).addToPlaylist("Monster", playList1);
        albums.get(0).addToPlaylist("Rap God", playList1);
        albums.get(0).addToPlaylist("Lose Yourself", playList1);

        play(playList1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0) {
            System.out.println("This playlist has no songs");
        } else {
            System.out.println("Now Playing" +listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    } else {
                        System.out.println("No Song Available end of List");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    } else {
                        System.out.println("No previous Song Available");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                            if(listIterator.hasNext()){
                                System.out.println("Now Playing" + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached the End of List");
                            }
                        }
                        break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing" + listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now Playing"+ listIterator.previous().toString());
                        }
                        break;
                    }
                    }
            }
    }


    private static void printMenu( ) {
        System.out.println("Available options\n Press");
        System.out.println("0 - Quit\n"+
                "1 - Play Next Song\n"+
                "2 - Play Previous Song\n"+
                "3 - Replay Current Song\n"+
                "4 - Show All Songs\n"+
                "5 - Print All Available Options\n"+
                "6 - Delete Current Song");
    }

    private static void printList(LinkedList<Song>playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------------");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--------------------");
    }
}