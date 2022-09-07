package com.player;

import java.util.*;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		Album album = new Album("Album1", "AC/DC");
		album.addSong("TNT ", 4.5);
		album.addSong("Highway to hell ", 3.5);
		album.addSong("Thunder struck ", 5.0);
		albums.add(album);

		album = new Album("Album2", "Eminem");
		album.addSong("Rap god ", 4.5);
		album.addSong("Lose yourself ", 3.5);
		album.addSong("Not Afraid ", 5.0);
		albums.add(album);

		LinkedList<Song> playList_1 = new LinkedList<>();

		albums.get(0).addToPlaylist("TNT ", playList_1);
		albums.get(0).addToPlaylist("Highway to hell ", playList_1);
		albums.get(1).addToPlaylist("Rap god ", playList_1);
		albums.get(1).addToPlaylist("Lose yourself ", playList_1);

		play(playList_1);
	}

	private static void play(LinkedList<Song>playList) {
        Scanner sc =new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song>ListIterator=playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playList has no song");
        }else{
            System.out.println("Now Playing" +ListIterator.next().toString());
            printMenu();
        }
        while (!quit) {
        int action =sc.nextInt();
        sc.nextLine();

        switch (action){
            case 0:
                System.out.println("Playlist Complete");
                quit = true;
                break;

            case 1:
                if(!forward){
                    if(ListIterator.hasNext()){
                        ListIterator.next();
                    }
                    forward=true;
                }
                if (ListIterator.hasNext()) {
                    System.out.println("Now playing" + ListIterator.next().toString());
                }else{
                    System.out.println("No song available reached to the end of the list");
                    forward = false;
                }
                break;
            case 2:
                if(forward){
                    if (ListIterator.hasPrevious()){
                        ListIterator.previous();
                    }
                    forward=false;
                    if(ListIterator.hasPrevious()){
                        System.out.println("Now Playing" +ListIterator.previous().toString());
                    }else{
                        System.out.println("we are at the first song");
                        forward=false;
                    }
                }
                    break;
            case 3:
                if(forward){
                    if(ListIterator.hasPrevious()){
                        System.out.println("Now Playing" +ListIterator.previous().toString());
                        forward=false;
                    }else{
                        System.out.println("we are at the list");
                    }
                    }else{
                            if (ListIterator.hasNext()){
                                System.out.println("\nNow Playing\n" +ListIterator.previous().toString());
                                forward=true;
                            }else{
                                System.out.println("\nwe have reached the end of the list\n");
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
                    if (playList.size()>0){
                        ListIterator.remove();
                        if (ListIterator.hasNext()){
                            System.out.println("\nNow playing\n"+ListIterator.next().toString());
                        }
                    }
                    else{
                        if (ListIterator.hasPrevious())
                            System.out.println("\nnow playing\n"+ListIterator.previous().toString());
                    }
           }
        }
    }

	private static void printMenu() {
		System.out.println("\nAvailable options\n\npress\n");
		System.out.println("0 - to quit\n\n" + "1 - to play next song\n\n" + "2 - to play previous song\n\n"
				+ "3 - to replay Current song\n\n" + "4- list of all song\n\n" + "5- print all available options\n\n"
				+ "6- delete current song");

	}

	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> Iterator = playList.iterator();
		System.out.println("-----------------------");
		while (Iterator.hasNext()) {
			System.out.println(Iterator.next());
		}
		System.out.println("-----------------------");
	}
}
