package com.spring.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.joda.time.DateTime;


@Entity
@Table(name = "passwordTokens")
public class passwordToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	private String token;
	private DateTime datetime;
	public passwordToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public passwordToken(int userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the datetime
	 */
	public DateTime getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(DateTime datetime) {
		this.datetime = datetime;
	}
	
	
	
}
