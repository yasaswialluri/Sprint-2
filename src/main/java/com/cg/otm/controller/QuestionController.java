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

import com.cg.otm.entity.Question;
import com.cg.otm.entity.Exam;
import com.cg.otm.exception.ExamException;
import com.cg.otm.exception.QuestionException;
import com.cg.otm.service.QuestionService;

@RestController
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	QuestionService  questionService;
	//find question by Id
	@GetMapping("question/{questionId}")
	public  ResponseEntity<Question>  findQuestionById(@PathVariable("questionId")  int questionId) throws QuestionException 
	{	
		Question  question = questionService.findQuestionById(questionId);
		ResponseEntity<Question>  re = new ResponseEntity<Question>(question,HttpStatus.OK);
		return re;
	}

	//Display list of questions
	@GetMapping("question")
	public ResponseEntity<List<Question>>  findAllQuestion() throws QuestionException
	{
		List<Question> listQuestions = questionService.findAllQuestions();
		ResponseEntity<List<Question>>  rt = new ResponseEntity<List<Question>>(listQuestions,HttpStatus.OK);
		return rt;	
	}

	//delete question by Id
	@DeleteMapping("question/{questionId}")
	public  ResponseEntity<Question>  deleteQuestionById(@PathVariable("questionId") int questionId) throws QuestionException
	{
		ResponseEntity<Question>  rt = null;
		Question question =questionService.deleteQuestionById(questionId);
		rt= new ResponseEntity<Question>(question,HttpStatus.OK);
		return rt;
	}

	//Display all the question in test
	@GetMapping("questions/exam/{examId}")
	public ResponseEntity<List<Question>>  findQuestionInTest(@PathVariable("examId") int examId) throws QuestionException
	{ 
		List<Question> listQuestions = questionService.findQuestionInTest(examId);
		ResponseEntity<List<Question>>  rt = new ResponseEntity<List<Question>>(listQuestions,HttpStatus.OK);
		return rt;	
	}

	//add a new question to test
	@PostMapping("questions/exam/{examId}")
	public ResponseEntity<Question> addQuestion(@PathVariable("examId")int examId,@RequestBody Question question) throws ExamException
	{
		Exam exam = new Exam()  ;
		exam.setExamId(examId);
		question.setExam(exam);
		Question ques = questionService.addQuestion(examId, question);
		ResponseEntity<Question> re = new ResponseEntity<Question>(ques, HttpStatus.OK);
		return re;
	}
	//update question
	@PutMapping("questions/exam/{examId}/question/{questionId}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("examId")int examId,@PathVariable("questionId")int questionId,@RequestBody Question question) throws QuestionException
	{
		Exam exam = new Exam()  ;
		exam.setExamId(examId);
		question.setExam(exam);
		Question ques = questionService.updateQuestion(examId,questionId,question);
		ResponseEntity<Question> re = new ResponseEntity<Question>(ques, HttpStatus.OK);
		return re;
	}

}
