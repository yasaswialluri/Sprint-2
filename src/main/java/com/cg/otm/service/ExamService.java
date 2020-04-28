package com.cg.otm.service;
import java.util.List;
import com.cg.otm.entity.Exam;
import com.cg.otm.exception.ExamException;

public interface ExamService {

	//Method to find test by id
	public Exam findExamById(int examId) throws ExamException ;
	//method to add a new test
	public  Exam createExam(Exam exam);
	//method to find all tests
	public List<Exam>  findAllExam() throws  ExamException;
	//method to delete test based on id
	public Exam deleteExamById(int examId) throws  ExamException;
	//method to update test
	public Exam updateExam(int examId,Exam  exam) throws  ExamException;


}
