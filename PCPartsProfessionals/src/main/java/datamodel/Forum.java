package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forumnsTable")
public class Forum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "MYUSER")
	private String username;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "DATE")
	private String date;
	
	public Forum() {
		
	}
	
	public Forum(Integer id, String username, String title, String text, String date) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	public Forum(String username, String title, String text, String date) {
		this.username = username;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", username=" + username + ", title=" + title + ", text=" + text + ", date=" + date
				+ "]";
	}
}
