package be.iccbxl.pid.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name= "artist_type_show")
public class ShowsArtistTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "artist_type_id", nullable = false)
	private ArtistType artisteType;

	@ManyToOne
	@JoinColumn(name = "show_id", nullable = false)
	private Show show;
}
