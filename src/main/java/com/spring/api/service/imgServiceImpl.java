package com.spring.api.service;

import org.springframework.web.multipart.MultipartFile;
import com.spring.api.model.imgFile;
import com.spring.api.repository.imgRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class imgServiceImpl implements imgService {

	@Autowired
	private imgRepository dao;

	@Override
	public imgFile uploadFile(MultipartFile file) throws IOException {

		imgFile dbFile = new imgFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());

		return dao.save(dbFile);

	}

}
