package qa.com.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Account {

	public Account() {

	}

//	@OneToMany(mappedBy="userName", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<Song> songs = new ArrayList<Song>();

	public Account(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@Column(unique = true, columnDefinition = "VARCHAR(15)")
	private String userName;

	@Column(length = 50)
	private String firstName;

	@Column(length = 50)
	private String lastName;

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public List<Song> getSongs() {
//		return songs;
//	}
//
//	public void setSongs(List<Song> songs) {
//		this.songs = songs;
//	}

}
