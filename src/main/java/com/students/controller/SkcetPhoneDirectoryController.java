package com.students.controller;


import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.model.Students;
import com.students.service.StudentsDao;

@RestController
@SpringBootApplication
public class SkcetPhoneDirectoryController {
	
    /**
     * List all the student and send the response back to client in the JSON format
     * @return Students List
     */
	
	@RequestMapping(value = "/api/students", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Students> getAllStudents() {	
		System.out.println("Start to  get All Students.");
		StudentsDao sd = new StudentsDao();		
		List<Students> emps = sd.getStudents();
		return  emps;
		
	}
	@RequestMapping(value = "/api/students/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Students getStudent(@PathVariable("id") int studentId) {	
		System.out.println("Start to  get one student");
		StudentsDao sd = new StudentsDao();	
		Students student=new Students();
		 student = sd.getStudent(studentId);
		return  student;
		
	}
	
	@RequestMapping(value = "/api/students/create", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Students createEmployee(@RequestBody Students st) {
		StudentsDao sd=new StudentsDao();
		st.setRollno(st.getRollno());
		st.setFirst_name(st.getFirst_name());
		st.setLast_name(st.getLast_name());
		st.setPhone_no(st.getPhone_no());
		sd.saveStudents(st);		
		return st;
	}
	
	@RequestMapping(value = "/api/students/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody void deleteStudent(@PathVariable("id") int studentId) {	
		System.out.println("Start delete one student");
		StudentsDao sd = new StudentsDao();	
		sd.deleteStudent(studentId);
		
		
	}
	
	@RequestMapping(value = "/api/students/update/{id}", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody void updateStudent(@PathVariable("id") int studentId, @RequestBody Students st) {	
		System.out.println("Start update student");
		StudentsDao sd = new StudentsDao();	
		Students s=new Students();
		s.setId(studentId);
		s.setRollno(st.getRollno());
		s.setFirst_name(st.getFirst_name());
		s.setLast_name(st.getLast_name());
		s.setPhone_no(st.getPhone_no());	
		sd.updateStudent(s);
		
		
	}
	
	@RequestMapping(value = "/api/students/batchupdate/{id}", method = RequestMethod.PATCH, produces="application/json")
	public @ResponseBody void batchUpdateStudent(@PathVariable("id") int studentId, Map<String, Students> student) {	
		System.out.println("Batch method used for updating the data");
//		for (Map.Entry<String,String> entry : student.entrySet()) {
//            System.out.println("Key = " + entry.getKey() +
//                             ", Value = " + entry.getValue());
//    }
		
		
			System.out.print(student.containsKey(student));
		
	}
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(SkcetPhoneDirectoryController.class, args);
	}

}
