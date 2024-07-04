
package com.example.demo.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.EstimatesRepo;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.EstimatesProject;
import com.example.demo.model.response.Project;

@Service

public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EstimatesRepo estimatesRepo;
	
	public Project saveProject(Project project) {
		EstimatesProject estimatesProject=new EstimatesProject();
		estimatesProject.setClientName(project.getClient());
		estimatesProject.setProjectName(project.getName());
		estimatesProject.setPriority(project.getPriority());
		estimatesProject.setLastModify(project.getEndDate());
		estimatesProject.setCreateDate(project.getStartDate());
		estimatesProject.setLeadName(project.getTeamLeader());
		estimatesProject.setStatus_By_Employee(project.getStatus());
		estimatesProject.setDetails(project.getProjectDescription());
		estimatesProject.setDepartment(project.getProject_Deparment());
		estimatesProject.setFile(project.getFile());
		estimatesProject.setPrice(String.valueOf(project.getPrice()));
		estimatesRepo.save(estimatesProject);
		Employee employee=employeeRepository.findEmployeeByName(project.getTeamLeader());
		Set<Project> projects=new HashSet<>();
		projects.add(project);
		employee.setProject(projects);
		project.setEmployee(employee);
		return projectRepository.save(project);
	}
	
	public List<Project> getProjectDetails() {
		
		return projectRepository.findAll();
	}
	
	public Optional<Project> projectGetById(int  projectId) {
		return projectRepository.findById(projectId);
	}
	
	public void projectDeleteById(int projectId) {
		projectRepository.deleteById(projectId);
	}
	public Project saveOrUpdate(int projectId,Project project) {
		
		Project pro=projectRepository.findById(projectId).get();
		pro.setName(project.getName());
		pro.setProjectDescription(project.getProjectDescription());
		return projectRepository.save(pro);
	}
}
