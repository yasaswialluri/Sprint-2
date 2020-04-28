package com.cg.otm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.otm.entity.AssignExam;
import com.cg.otm.entity.Exam;
import com.cg.otm.entity.User;
import com.cg.otm.exception.AssignExamException;
import com.cg.otm.service.AssignExamService;

@RestController
@CrossOrigin("*")
public class AssignExamController {

	@Autowired
	AssignExamService assignExamService;
	//To assign a test to user
	@PostMapping("assign/exam/{examId}/user/{userID}")
	public ResponseEntity<AssignExam> assignExamToUser(@PathVariable("examId") int examId,@PathVariable("userId") int userId,@RequestBody AssignExam assignExam) throws AssignExamException
	{
		Exam exam = new Exam();
		exam.setExamId(examId);
		User user = new User();
		user.setUserId(userId);
		assignExam.setTest(exam);;
		assignExam.setUser(user);
		AssignExam a=assignExamService.assignExamToUser(assignExam,userId,examId);
		ResponseEntity<AssignExam>  re = new ResponseEntity<AssignExam>(a,HttpStatus.OK);
		return re;
	}

	// To update the assigned test
	@PutMapping("assign/exam/{examId}/user/{userId}/mark/{marks}")
	public AssignExam updateAssignedExam(@PathVariable("examId") int examId,@PathVariable("userId") int userId,@PathVariable("marks") int mark,@RequestBody AssignExam assignExam)
	{
		assignExam.setMarksScored(mark);
		AssignExam a=assignExamService.updateAssignedExam(assignExam,userId,examId,mark);
		return a;
	}

	//To display all the assigned test
	@GetMapping("assign")
	public ResponseEntity<List<AssignExam>>  assignExamToUSer()
	{
		List<AssignExam> list = assignExamService.find();
		ResponseEntity<List<AssignExam>>  rt = new ResponseEntity<List<AssignExam>>(list,HttpStatus.OK);
		return rt;	
	}

	//To delete the assigned test
	@DeleteMapping("assign/{id}")
	public  ResponseEntity<AssignExam>  deleteAssignedExam(@PathVariable("id") int examUserId) throws AssignExamException
	{
		ResponseEntity<AssignExam>  rt = null;
		AssignExam assignExam =assignExamService.deleteAssignExam(examUserId);
		rt= new ResponseEntity<AssignExam>(assignExam,HttpStatus.OK);
		return rt;
	}

	//To display all the the test of the user	
	@GetMapping("assign/{userId}")
	public ResponseEntity<List<AssignExam>> CheckAssignedExamsToUser(@PathVariable("userId") int userId) throws AssignExamException
	{
		ResponseEntity<List<AssignExam>>  rt = null;
		List<AssignExam> assignExam =assignExamService.checkExamAssignedToUSer(userId);
		rt= new ResponseEntity<List<AssignExam>>(assignExam,HttpStatus.OK);
		return rt;
	}

	//To display the details of exam of that user
	@GetMapping("assign/user/{userId}/exam/{examId}")
	public ResponseEntity<AssignExam> CheckAssignExamDetails(@PathVariable("id") int userId,@PathVariable("id1") int examId) throws AssignExamException
	{
		ResponseEntity<AssignExam>  rt = null;
		AssignExam assignExam =assignExamService.checkExamDetails(examId, userId);
		rt= new ResponseEntity<AssignExam>(assignExam,HttpStatus.OK);
		return rt;
	}

}
