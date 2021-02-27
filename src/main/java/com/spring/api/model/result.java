package com.spring.api.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "result")
public class result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int voltage;
	private int current;
	private int speed;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public result(int voltage, int current, int speed) {
		super();
		this.voltage = voltage;
		this.current = current;
		this.speed = speed;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the voltage
	 */
	public int getVoltage() {
		return voltage;
	}

	/**
	 * @param voltage the voltage to set
	 */
	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	/**
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(int current) {
		this.current = current;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the time_stamp
	 */
	public Date getTime_stamp() {
		return timeStamp;
	}

	/**
	 * @param time_stamp the time_stamp to set
	 */
	public void setTime_stamp(Date time_stamp) {
		this.timeStamp = time_stamp;
	}

	@Override
	public String toString() {
		return "result [id=" + id + ", voltage=" + voltage + ", current=" + current + ", speed=" + speed
				+ ", timeStamp=" + timeStamp + "]";
	}

}
