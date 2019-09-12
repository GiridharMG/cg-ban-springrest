package com.testyantra.cgbanspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.cgbanspringrest.beans.StudentInfo;
import com.testyantra.cgbanspringrest.beans.StudentResponse;
import com.testyantra.cgbanspringrest.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;

	@PostMapping(path = "/add", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse addStudent(@RequestBody StudentInfo info) {
		StudentResponse response = new StudentResponse();
		if(service.addStudent(info)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student data added to DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student data not added to DB");
		}
		return response;
	}

	@GetMapping(path = "/get",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse getStudent(@RequestParam("id") int id) {
		StudentResponse response = new StudentResponse();
		StudentInfo info = service.getStudent(id);
		if(info!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student data found in DB");
			response.setInfo(info);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student data not found in DB");
		}
		return response;
	}

	@PutMapping(path = "/edit",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse editStudent(@RequestBody StudentInfo info) {
		StudentResponse response = new StudentResponse();
		if(service.editStudent(info)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student data modified in DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student data not modified in DB");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse deleteStudent(@PathVariable("id") int id) {
		StudentResponse response = new StudentResponse();
		if(service.deleteStudent(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student data deleted from DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student data not deleted from DB");
		}
		return response;
	}
}








