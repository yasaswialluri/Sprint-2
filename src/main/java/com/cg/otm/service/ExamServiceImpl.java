package com.cg.otm.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.otm.dao.ExamDao;
import com.cg.otm.entity.Exam;
import com.cg.otm.exception.ExamException;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamDao  examDao;
	// Find a test based on id
	@Override
	public Exam findExamById(int examId) throws  ExamException {
		if( ! examDao.existsById(examId))
		{
			throw new  ExamException("Test ID "+examId+" NOT FOUND ");
		}
		return  examDao.findById(examId).get();
	}

	// Add a new test
	@Override
	public Exam createExam(Exam exam) {
		Exam exams =  examDao.saveAndFlush(exam);
		return exams;
	}

	//display all tests
	@Override
	public List<Exam> findAllExam() throws ExamException {
		List<Exam> listExams =  examDao.findAll();
		return listExams;
	}

	// delete a test based on id
	@Override
	public Exam deleteExamById(int examId) throws  ExamException {
		Exam exam =null;

		if( examDao.existsById(examId))
		{
			exam =  examDao.findById(examId).get();
			examDao.deleteById(examId);
		}
		else
		{
			throw new  ExamException("Test ID "+examId+" NOT FOUND ");
		}
		return exam ;
	}
	// update test
	@Override
	public Exam updateExam(int examId,Exam exam) throws  ExamException {

		Exam  exams=null;
		if( examDao.existsById(examId))
		{
			exams=examDao.save(exam);
		}
		else
		{
			throw new  ExamException(" Test ID "+examId+" NOT FOUND ");
		}
		return exams;
	}



}