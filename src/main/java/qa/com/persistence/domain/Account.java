package qa.com.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Account {

	public Account() {

	}



	public Account(String userName, String firstName, String lastName, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}


	@Id
	@Column(name ="userName" ,unique = true, columnDefinition = "VARCHAR(15)")
	private String userName;

	@Column(length = 50)
	private String firstName;

	@Column(length = 50)
	private String lastName;
	@Column(length = 50)
	private String password;

	
	@OneToMany(mappedBy = "userName", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Song> songs = new ArrayList<Song>();
	
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Song> getSongs() {
		return songs;
	}



	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}



}
