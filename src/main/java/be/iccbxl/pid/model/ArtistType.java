package be.iccbxl.pid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist_type")
public class ArtistType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;

	protected ArtistType() {
	}

	public ArtistType(Artist artist, Type type) {
		this.artist = artist;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ArtistType [id=" + id + ", artist=" + artist + ", type=" + type;
	}

}