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


@Entity
public class Account {

	public Account() {

	}



	public Account(String userName, String firstName, String lastName, Long songId) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.songId = songId;
	}



	@Id
	@Column(unique = true, columnDefinition = "VARCHAR(15)")
	private String userName;

	@Column(length = 50)
	private String firstName;

	@Column(length = 50)
	private String lastName;
	
	private Long songId;
	

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

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}



}
