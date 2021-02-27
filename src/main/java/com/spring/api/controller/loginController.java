package com.spring.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.api.model.emailTemplate;
import com.spring.api.model.imgFile;
import com.spring.api.model.userInfo;
import com.spring.api.repository.imgRepository;
import com.spring.api.repository.userDetailsRepository;
import com.spring.api.service.EmailService;
import com.spring.api.service.imgService;
import com.spring.api.service.userInfoService;

@RestController
public class loginController {

	@Autowired
	private userInfoService userService;
	@Autowired
	private imgService imgService;
	@Autowired
	userDetailsRepository userDao;
	@Autowired
	imgRepository imgDao;
	@Autowired
	private EmailService emailService;

	@GetMapping("/home") /* Login with OAuth */
	public String Home() {

		return "Welcome to HomePage, You are successfully login using OAUTH !!";

	}

	@GetMapping("/getUser") /* Get all Users */
	public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {

		List<userInfo> userInfos = userService.getAllActiveUserInfo();

		if (userInfos == null || userInfos.isEmpty()) {

			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		}
		return userInfos;

	}

	@PostMapping("/registerUser") /* Add Users */
	public ResponseEntity<?> registerUser(@RequestPart("data") String data, @RequestParam("file") MultipartFile file,
			emailTemplate emailTemplates) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		if (file.getOriginalFilename().isEmpty()) {
			String msg = "File should not be empty.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		userInfo userInfos = mapper.readValue(data, userInfo.class);

		if (userInfos.getUserName() == null) {
			String msg = "User Name should not be empty.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		if (userInfos.getEmail() == null) {
			String msg = "Email should not be empty.";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

		if (userService.getAllUserInfo(userInfos.getUserName()) != null) {
			return new ResponseEntity<>("User Name already exist.", HttpStatus.CONFLICT);
		}

		if (userInfos.getPassword() == null || userInfos.getPassword().isEmpty()) {
			String Pass = "test123";
			userInfos.setPassword(Pass);
		}

		imgFile fileName = imgService.uploadFile(file);
		userInfos.setImgId(fileName.getId());
		userInfos.setImgName(fileName.getFileName());
		userService.registerUser(userInfos);

		emailTemplates.setSendTo(userInfos.getEmail());
		emailTemplates.setSubject("Registered Successfully.");
		emailTemplates.setBody("You have registered succesfully..");

		emailService.sendTextEmail(emailTemplates);

		String msg = "User Registerd Successfully";
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateUser") /* Update User */
	public userInfo updateUser(@RequestBody userInfo userRecord) {

		String userName = userRecord.getUserName();

		try {

			userInfo getAllUserInfo = userService.getAllUserInfo(userName);

			userRecord.setId(getAllUserInfo.getId());
			userRecord.setPassword(getAllUserInfo.getPassword());
			userRecord.setEmail(getAllUserInfo.getEmail());

			if (userRecord.getFirstName() == null) {
				userRecord.setFirstName(getAllUserInfo.getFirstName());
			}
			if (userRecord.getLastName() == null) {
				userRecord.setLastName(getAllUserInfo.getLastName());
			}
			if (userRecord.getDateOfBirth() == null) {
				userRecord.setDateOfBirth(getAllUserInfo.getDateOfBirth());
			}
			if (userRecord.getGender() == null) {
				userRecord.setGender(getAllUserInfo.getGender());
			}
			if (userRecord.getBloodGroup() == null) {
				userRecord.setBloodGroup(getAllUserInfo.getBloodGroup());
			}
			if (userRecord.getMobileNumber() == null) {
				userRecord.setMobileNumber(getAllUserInfo.getMobileNumber());
			}
			if (userRecord.getStreet() == null) {
				userRecord.setStreet(getAllUserInfo.getStreet());
			}
			if (userRecord.getCity() == null) {
				userRecord.setCity(getAllUserInfo.getCity());
			}
			if (userRecord.getState() == null) {
				userRecord.setState(getAllUserInfo.getState());
			}
			if (userRecord.getZip() == null) {
				userRecord.setZip(getAllUserInfo.getZip());
			}
			if (userRecord.getAddressType() == null) {
				userRecord.setAddressType(getAllUserInfo.getAddressType());
			}
			if (userRecord.getLongVal() == null) {
				userRecord.setLongVal(getAllUserInfo.getLongVal());
			}
			if (userRecord.getLatVal() == null) {
				userRecord.setLatVal(getAllUserInfo.getLatVal());
			}
			if (userRecord.getRole() == null) {
				userRecord.setRole(getAllUserInfo.getRole());
			}
			if (userRecord.getImgId() == null) {
				userRecord.setImgId(getAllUserInfo.getImgId());
			}
			if (userRecord.getImgName() == null) {
				userRecord.setImgName(getAllUserInfo.getImgName());
			}

			return this.userService.updateUser(userRecord);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	@DeleteMapping("/deleteUser/{Id}") /* Delete User */
	public userInfo deleteUser(@PathVariable int Id) {

		return this.userService.deleteUser(Id);

	}

}
