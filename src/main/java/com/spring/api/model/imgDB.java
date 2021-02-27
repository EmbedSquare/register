package com.spring.api.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "imgDB")
public class imgDB {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "fileName")
	private String fileName;

	private String fileType;

	@Lob
	private byte[] data;

	public imgDB() {

	}

	public imgDB(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}