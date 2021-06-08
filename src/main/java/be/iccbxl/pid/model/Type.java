package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "type")
	private String typeName;

	public Type() {
	}

	@ManyToMany
	@JoinTable(name = "artist_type", joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private List<Artist> artists = new ArrayList<>();

	public Type(String type) {
		this.typeName = type;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public Type addArtist(Artist artist) {
		if (!this.artists.contains(artist)) {
			this.artists.add(artist);
			artist.addType(this);
		}

		return this;
	}

	public Type removeType(Artist artist) {
		if (this.artists.contains(artist)) {
			this.artists.remove(artist);
			artist.getTypes().remove(this);
		}

		return this;
	}

	public Long getId() {
		return id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String type) {
		this.typeName = type;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + typeName + "]";
	}
}
