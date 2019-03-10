package qa.com.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Song {


	public Song(String songName, Integer bPM, String description, String tubeLink) {
		super();
		this.songName = songName;
		this.bPM = bPM;
		this.description = description;
		this.tubeLink = tubeLink;
	}

	public Song() {

	}


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 15)
	private Long songId;
	
	@Column(length = 50)
	private String songName;
	
	@Column(length = 3)
	private int bPM;
	
	@Column(length = 255)
	private String description;
	
	@Column(length = 255)
	private String tubeLink;
	
	private String userName;




	// public SongBirdLibrary(Long songID, String songName, int bPM, String
	// description, List<SongBirdLibrary> account) {
	//
	// this.songId = songId;
	// this.songName = songName;
	// this.bPM = bPM;
	// this.description = description;
	//
	// }

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Integer getbPM() {
		return bPM;
	}

	public void setbPM(Integer bPM) {
		this.bPM = bPM;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTubeLink() {
		return tubeLink;
	}

	public void setTubeLink(String tubeLink) {
		this.tubeLink = tubeLink;
	}



}
