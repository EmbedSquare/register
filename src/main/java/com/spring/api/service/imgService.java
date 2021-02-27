package com.spring.api.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import com.spring.api.model.imgFile;

public interface imgService {

	public imgFile uploadFile(MultipartFile file) throws IOException;

}
