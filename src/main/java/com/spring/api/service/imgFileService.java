package com.spring.api.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import com.spring.api.model.imgDB;

public interface imgFileService {

	public imgDB uploadFile(MultipartFile file) throws IOException;

	public imgDB getFile(String imgId);

}