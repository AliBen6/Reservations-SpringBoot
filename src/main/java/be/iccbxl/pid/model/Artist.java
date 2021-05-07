package be.iccbxl.pid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="artists")
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "first name must not be empty")
    @JsonProperty("firstName")
	@Column(name = "firstname")
	private String firstname;
	
	
	@NotEmpty(message = "last name must not be empty")
    @JsonProperty("lastName")
	@Column(name = "lastname")
	private String lastname;
	
}
