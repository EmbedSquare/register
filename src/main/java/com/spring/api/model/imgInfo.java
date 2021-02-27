package com.spring.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imgInfo")
public class imgInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fileId;
	private String fileName;
	private String fileType;

	public imgInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public imgInfo(String fileId, String fileName, String fileType) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "imgInfo [id=" + id + ", fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + "]";
	}

}