package com.cg.otm.service;
import java.util.List;
import com.cg.otm.entity.Question;
import com.cg.otm.exception.QuestionException;
import com.cg.otm.exception.ExamException;

public interface QuestionService {

	//find question by question Id
	public Question findQuestionById(int questionId) throws QuestionException ;

	//Find all questions
	public List<Question>  findAllQuestions() throws QuestionException;

	// delete the question by id
	public Question deleteQuestionById(int questionId) throws QuestionException;

	// update question by id
	public Question updateQuestion(int examId,int questionId,Question  question) throws QuestionException;

	//Find all the questions in a particular test
	public List<Question>  findQuestionInTest( int id);

	//Add a question to a particular test
	public Question addQuestion(int examId,Question  question)  throws ExamException;
}
