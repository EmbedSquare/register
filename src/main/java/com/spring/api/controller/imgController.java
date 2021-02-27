package com.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.spring.api.model.imgDB;
import com.spring.api.model.imgInfo;
import com.spring.api.repository.imgInfoRepository;
import com.spring.api.service.imgFileService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
public class imgController {

	@Autowired
	private imgFileService imgService;

	@Autowired
	private imgInfoRepository dao;

	@GetMapping("/test")
	public String Test() {

		return "Welcome Application is Running";
	}

	@GetMapping("/getImg/{imgId}")
	public ResponseEntity<Resource> getFile(@PathVariable String imgId, HttpServletRequest request) {

		imgDB databaseFile = imgService.getFile(imgId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))

				.body(new ByteArrayResource(databaseFile.getData()));
	}

	@PostMapping("/upImg")
	public ResponseEntity<?> imgUpload(@RequestParam("file") MultipartFile file) throws Exception {

		if (file == null || file.isEmpty()) {
			String msg = "File should not be empty";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		imgDB fileName = imgService.uploadFile(file);
		imgInfo imgInfos = dao.save(new imgInfo(fileName.getId(), fileName.getFileName(), fileName.getFileType()));
		String msg = "File saved: " + imgInfos;
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

}
