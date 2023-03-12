package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listingsTable")
public class listingsTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "COND")
	private String condition;

	@Column(name = "PRICE")
	private String price;

	@Column(name = "DATE")
	private String date;

	@Column(name = "USER")
	private String user;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	public listingsTable() {

	}

	public listingsTable(Integer id, String type, String brand, String model, String condition, String price, String date,
			String user, String email, String phone, String city, String state) {
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.condition = condition;
		this.price = price;
		this.date = date;
		this.user = user;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	public listingsTable(String type, String brand, String model, String condition, String price, String date, String user,
			String email, String phone, String city, String state) {
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.condition = condition;
		this.price = price;
		this.date = date;
		this.user = user;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Listing [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", condition="
				+ condition + ", price=" + price + ", date=" + date + ", user=" + user + ", email=" + email + ", phone="
				+ phone + ", city=" + city + ", state=" + state + "]";
	}
}
