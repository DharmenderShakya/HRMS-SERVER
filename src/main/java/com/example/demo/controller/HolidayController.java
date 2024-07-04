package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.HolidayRepo;
import com.example.demo.Service.HolidayService;
import com.example.demo.model.response.Holiday;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/hrms")
@RestController
@CrossOrigin("*")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;
	
	@Autowired
	private HolidayRepo holidayRepo;
	
	@PostMapping("/postholiday")
	public Holiday postHoliday(@RequestBody Holiday holiday) {
		return holidayRepo.save(holiday);
	}
	@PutMapping("/putholiday")
	public Holiday putHoliday(@RequestBody Holiday holiday) {
		Holiday holiday2=holidayRepo.findById(holiday.getId()).get();
		holiday2.setDetails(holiday.getDetails());
		holiday2.setHolidayDate(holiday.getHolidayDate());
		holiday2.setLocation(holiday.getLocation());
		holiday2.setName(holiday.getName());
		holiday2.setShift(holiday.getShift());
		return holidayRepo.save(holiday2);
	}
	
	@GetMapping("/getAllHoliday")
	public List<Holiday> getHoliday() {
		return holidayService.getAllHoliday();
	}
	
	@GetMapping("/getHolidayById")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	
	
}
