package com.player;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	// declaring name of the song of type String
	private String name;
	// declaring name of the artist of type String
	private String artist;
	// declaring list of the song of type ArrayList
	private ArrayList<Song> songs;

	// creating constructor for both name ,artist and list of songs
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public Album() {

	}

	public Song findSong(String title) {
		for (Song checkedSong : songs) {
			if (checkedSong.getTitle().equals(title))
				return checkedSong;
		}
		return null;
	}

	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
//			System.out.println("--------------------------------------------------");
//			System.out.println(title + "successfully added in the list  ");
//			System.out.println("--------------------------------------------------");
			return true;
		} else {
//			System.out.println("--------------------------------------------------");
//			System.out.println("Song with name   " + title + " already exist in the list  ");
//			System.out.println("--------------------------------------------------");
			return false;
		}
	}

	public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist) {
		int index = trackNumber - 1;
		if (index > 0 && index <= this.songs.size()) {
			Playlist.add(this.songs.get(index));
			return true;
		} else
//			System.out.println("--------------------------------------------------");
//			System.out.println(" this album does not have song with this trackNumber   " + trackNumber);
//			System.out.println("--------------------------------------------------");
		return false;
	}

	public boolean addToPlaylist(String title, LinkedList<Song> Playlist) {
		for (Song checkedSong : this.songs) {
			if (checkedSong.getTitle().equals(title)) {
				Playlist.add(checkedSong);
				return true;
			}
		}
//		System.out.println("--------------------------------------------------");
//		System.out.println(title + "there is no such song in album   ");
//		System.out.println("--------------------------------------------------");
//		System.out.println("--------------------------------------------------");
		return false;
	}
}
