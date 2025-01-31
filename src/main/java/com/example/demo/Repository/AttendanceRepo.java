package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {

	public Attendance findAttendanceByName(String name);
}
