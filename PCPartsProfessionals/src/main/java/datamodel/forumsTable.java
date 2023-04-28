package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forumsTable")
public class forumsTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "MYUSER")
	private String username;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "BODY")
	private String body;

	@Column(name = "DATE")
	private String date;
	
	@Column(name = "PARENT")
	private String parent;

	public forumsTable() {

	}

	public forumsTable(Integer id, String username, String title, String body, String date, String parent) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.body = body;
		this.date = date;
		this.parent = parent;
	}

	public forumsTable(String username, String title, String body, String date, String parent) {
		this.username = username;
		this.title = title;
		this.body = body;
		this.date = date;
		this.parent = parent;
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

	public String getBody() {
		return body;
	}

	public void setText(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "forumsTable [id=" + id + ", username=" + username + ", title=" + title + ", body=" + body + ", date=" + date + ", parent=" + parent
				+ "]";
	}
}
