package com.cg.otm.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.otm.dao.QuestionDao;
import com.cg.otm.entity.Question;
import com.cg.otm.exception.QuestionException;
import com.cg.otm.exception.ExamException;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao  questionDao;

	//find a question by Id
	@Override
	public Question findQuestionById(int questionId) throws QuestionException  {

		if( !  questionDao.existsById(questionId))
		{
			throw new QuestionException("Question ID "+questionId+" NOT FOUND ");
		}
		return  questionDao.findById(questionId).get();
	}


	@Override
	public List<Question> findAllQuestions() throws QuestionException {

		List<Question> list =  questionDao.findAll();
		return list;
	}

	//delete question by id
	@Override
	public Question deleteQuestionById(int questionId) throws QuestionException {
		Question  question =null;

		if(  questionDao.existsById(questionId))
		{
			question =  questionDao.findById(questionId).get();
			questionDao.deleteById(questionId);
		}
		else
		{
			throw new QuestionException("Question ID "+questionId+" NOT FOUND ");
		}
		return question ;
	}

	//update question
	@Override
	public Question updateQuestion(int examId,int questionId,Question  question) throws QuestionException{
		Question questions=null;
		if( questionDao.existsById(questionId))
		{
			questions=questionDao.save(question);
		}
		else
		{
			throw new  QuestionException(" Question ID "+questionId+" NOT FOUND ");
		}
		return questions;
	}

	//find all questions in particular test
	@Override
	public List<Question> findQuestionInTest(int id) {

		return questionDao.findQuestionInTest(id);
	}

	//add a question to a particular test
	@Override
	public Question addQuestion(int examId, Question question) throws ExamException {
		Question questions;
		if(question.getExam().getExamId()==examId)
		{
			questions=questionDao.saveAndFlush(question);
		}
		else
		{
			throw new ExamException("Test Id doesnot exist");
		}
		return questions;
	}

}