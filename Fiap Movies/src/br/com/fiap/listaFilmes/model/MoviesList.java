package br.com.fiap.listaFilmes.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoviesList {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String synopsis;
	private String genre;
	private String whereToWatch;
	private boolean watched;
	private int starRate;
	
	
	
	public String getGenre() {
		return genre;
	}
	
	@Override
	public String toString() {
		return "ListaFilmes [title=" + title + ", synopsis=" + synopsis + ", genre=" + genre + ", whereToWatch="
				+ whereToWatch + ", watched=" + watched + ", starRate=" + starRate + "]";
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getWhereToWatch() {
		return whereToWatch;
	}
	
	public void setWhereToWatch(String whereToWatch) {
		this.whereToWatch = whereToWatch;
	}
	public String isWatched(boolean watched) {
		String foo = "Not watched";
		if(watched) {
			foo = "Watched";
		}	
		return foo;
	}
	
	public void setWatched(boolean watched) {
		this.watched = watched;
	}
	
	public Long getStarRate() {
		return (long) starRate;
	}
	
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public Vector<String> getData() {
		Vector<String> data = new Vector<String>(); 
		data.add(id.toString());
		data.add(title);
		data.add(synopsis);
		data.add(genre);
		data.add(whereToWatch);
		data.add(isWatched(watched));
		data.add(getStarRate().toString());
		return data;
	}
	
	
	
}
