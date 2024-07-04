package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HolidayRepo;
import com.example.demo.model.response.Holiday;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepo holidayRepo;
	
	public Holiday addHolidays(Holiday holiday) {
		return holidayRepo.save(holiday);
	}
	
	public List<Holiday> getAllHoliday(){
		return holidayRepo.findAll();
	}
	
	public Optional<Holiday> findHolidayById(int id) {
		return holidayRepo.findById(id);
	}
}
