package com.spring.api.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.spring.api.model.imgDB;
import com.spring.api.repository.imgFileRepository;

@Service
public class imgFileServiceImpl implements imgFileService {

	@Autowired
	private imgFileRepository imgFileDao;

	@Override
	public imgDB uploadFile(MultipartFile file) throws IOException {

		imgDB dbFile = new imgDB(file.getOriginalFilename(), file.getContentType(), file.getBytes());

		return imgFileDao.save(dbFile);
	}

	@Override
	public imgDB getFile(String imgId) {

		return imgFileDao.findById(imgId);

	}

}