package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AttendanceRepo;
import com.example.demo.model.response.Attendance;
import com.example.demo.model.response.Employee;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepo attendancerepo;
	
	@Autowired
	private EmloyeeService emploEmloyeeService;
	
	
	public Attendance addAttendance(Attendance attendance) {
		Employee employee=emploEmloyeeService.getEmployeeByName(attendance.getName());
		Attendance att=new Attendance();
		att.setEmployee(employee);
		att.setName(employee.getName());
		att.setIn(attendance.getIn());
		att.setOut(attendance.getOut());
		att.setShift(attendance.getShift());
		att.setStatus(attendance.getStatus());
		att.setLunch_break(attendance.getLunch_break());
		att.setTotal(attendance.getTotal());
		att.setDate(new Date());
		employee.setAttedance(att);
		return attendancerepo.save(att);
	}
	public List<Attendance> getAllattendance(){
		return attendancerepo.findAll();
	}
	public Optional<Attendance> getById(int id) {
		return attendancerepo.findById(id);
	}
}
