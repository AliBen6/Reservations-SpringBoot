package be.iccbxl.pid.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, unique = true, nullable = false)
	private String login;
	@Column(length = 255, nullable = false)
	private String password;
	@Column(length = 60, nullable = false)
	private String firstname;
	@Column(length = 60, nullable = false)
	private String lastname;
	@Column(length = 100, nullable = false)
	private String email;
	@Column(length = 2, nullable = false)
	private String langue;

	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	@OneToMany(mappedBy = "artist")
	private List<ArtistType> types;

	@Transient
	private String fullUrlImg;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roleList;

	@Transient
	private String newPassword;

	public User(String login, String password, String firstname, String lastname, String email, String langue) {
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.langue = langue;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new LinkedList<>();
		for (Role role : roleList) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
