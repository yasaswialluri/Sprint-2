package com.cg.otm.service;
import java.util.List;
import com.cg.otm.entity.AssignExam;
import com.cg.otm.exception.AssignExamException;

public interface AssignExamService {
	//list all the assigned exams
	public List<AssignExam> find();
	//Assign a test to user
	public AssignExam assignExamToUser(AssignExam assignExam , int userID,int examID) throws AssignExamException;
	// update the assigned test
	public AssignExam updateAssignedExam(AssignExam assignExam, int userID,int examID,int mark);
	//delete the assigned test
	public AssignExam deleteAssignExam(int examUserId) throws AssignExamException;

	//List all the tests assigned to a particular user
	public List<AssignExam> checkExamAssignedToUSer(int userId) throws AssignExamException;
	//find the details of assigned test of particular user and testId
	public AssignExam checkExamDetails(int testId,int userId);
}
