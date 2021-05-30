package be.iccbxl.pid.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "role")
	private String role;

	
	public Role(String role) {
		super();
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "role")
	private List<RoleUser> roleUser;

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
}

