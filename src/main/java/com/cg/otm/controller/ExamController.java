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
import com.cg.otm.entity.Exam;
import com.cg.otm.exception.ExamException;

import com.cg.otm.service.ExamService;

@RestController
@CrossOrigin("*")
public class ExamController {

	@Autowired
	ExamService  examService;
	//Find a Exam By ID
	@GetMapping("exam/{examId}")
	public  ResponseEntity<Exam>  findExamById(@PathVariable("examId")  int examId) throws ExamException
	{
		Exam  exam = examService.findExamById(examId);
		ResponseEntity<Exam>  re = new ResponseEntity<Exam>(exam,HttpStatus.OK);
		return re;
	}
	//Add a new Exam
	@PostMapping("exam")
	public ResponseEntity<Exam>  createExam(@RequestBody Exam exam)
	{
		Exam  exams = examService.createExam(exam);
		ResponseEntity<Exam>  re = new ResponseEntity<Exam>(exams,HttpStatus.OK);
		return re;
	}


	// Display all the exams
	@GetMapping("exam")
	public ResponseEntity<List<Exam>>  findAllExams() throws  ExamException
	{
		List<Exam> listExams = examService.findAllExam();
		ResponseEntity<List<Exam>>  rt = new ResponseEntity<List<Exam>>(listExams,HttpStatus.OK);
		return rt;	
	}
	//delete the exam
	@DeleteMapping("exam/{examId}")
	public  ResponseEntity<Exam>  deleteExamById(@PathVariable("examId") int examId) throws  ExamException
	{
		ResponseEntity<Exam>  rt = null;
		Exam exam =examService.deleteExamById(examId);
		rt= new ResponseEntity<Exam>(exam,HttpStatus.OK);	
		return rt;
	}
	//Update the exam
	@PutMapping("exam/{examId}")
	public ResponseEntity<Exam> updateTest(@PathVariable("examId") int examId,@RequestBody Exam exam) throws  ExamException
	{
		Exam exams = examService.updateExam(examId,exam);
		ResponseEntity<Exam> re = new ResponseEntity<Exam>(exams, HttpStatus.OK);
		return re;
	}



}
