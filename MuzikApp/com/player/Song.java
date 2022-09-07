package com.player;

public class Song {
	// declaring name of the song of type String
	String title;

	// declaring duration of the song of type double
	double duration;

	// creating constructor for both name and duration
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	// Empty constructor
	public Song() {

	}

	public String getTitle() {
		return title;
	}

	public double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		System.out.println("--------------------------------------------------");
		return "Song{" + " title = '  " + title +  '\'' + ",  duration =  " + duration + '}';
	}
}
