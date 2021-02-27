package com.spring.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public class userInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 25)
	private int id;

	@Column(name = "userName", length = 50)
	private String userName;

	@Column(name = "password", length = 800)
	private String password;

	@Column(name = "firstName", length = 50)
	private String firstName;

	@Column(name = "lastName", length = 50)
	private String lastName;

	@Column(name = "email", length = 50)
	@Email(message = "Email should be valid")
	private String email;

	@Column(name = "dateOfBirth")
	private String dateOfBirth;

	@Column(name = "gender", length = 20)
	private String gender;

	@Column(name = "bloodGroup", length = 20)
	private String bloodGroup;

	@Column(name = "mobileNumber", length = 20)
	private String mobileNumber;

	@Column(name = "street", length = 800)
	private String street;

	@Column(name = "city", length = 6)
	private String city;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "zip", length = 50)
	private String zip;

	@Column(name = "addressType", length = 50)
	private String addressType;

	@Column(name = "longVal", length = 50)
	private String longVal;

	@Column(name = "latVal", length = 50)
	private String latVal;

	@Column(name = "imgId", length = 50)
	private String imgId;

	@Column(name = "imgName", length = 50)
	private String imgName;

	@Column(name = "role", length = 20)
	private String role = "USER";

	@Column(name = "enabled")
	private short enabled = 1;

	public userInfo() {
		super();

	}

	public userInfo(int id, String firstName, String lastName, String dateOfBirth, String gender, String bloodGroup,
			String mobileNumber, String street, String city, String state, String zip, String addressType,
			String longVal, String latVal, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.mobileNumber = mobileNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.addressType = addressType;
		this.longVal = longVal;
		this.latVal = latVal;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getLongVal() {
		return longVal;
	}

	public void setLongVal(String longVal) {
		this.longVal = longVal;
	}

	public String getLatVal() {
		return latVal;
	}

	public void setLatVal(String latVal) {
		this.latVal = latVal;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "userInfo [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", bloodGroup=" + bloodGroup + ", mobileNumber=" + mobileNumber + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", addressType=" + addressType + ", longVal=" + longVal
				+ ", latVal=" + latVal + ", imgId=" + imgId + ", imgName=" + imgName + ", role=" + role + ", enabled="
				+ enabled + "]";
	}

}
