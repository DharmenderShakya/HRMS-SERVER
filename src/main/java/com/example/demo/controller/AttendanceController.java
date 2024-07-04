package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AttendanceService;
import com.example.demo.model.response.Attendance;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping("/postAttendance")
	public Attendance postMethodName(@RequestBody Attendance entity) {
		
		return attendanceService.addAttendance(entity);
	}
	
	@GetMapping("/getAllAttendence")
	public List<Attendance> getAllTodayAttendence(){
		return attendanceService.getAllattendance();
	}
	
}
