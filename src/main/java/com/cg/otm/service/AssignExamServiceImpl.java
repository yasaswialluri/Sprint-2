package com.cg.otm.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.otm.dao.AssignExamDao;
import com.cg.otm.entity.AssignExam;
import com.cg.otm.exception.AssignExamException;


@Service
public class AssignExamServiceImpl implements AssignExamService{

	@Autowired
	AssignExamDao assignExamDao;
	//Assign a exam to user
	@Override
	public AssignExam assignExamToUser( AssignExam assignExam,int userId,int examId)  throws AssignExamException{
		AssignExam a;
		a=assignExamDao.checkAssignedExamDetails(userId, examId);
		if(a==null)
		{
			assignExamDao.saveAndFlush(assignExam);		
		}
		else
		{
			throw new AssignExamException("The test "+examId+" is already assigned to user"+userId);
		}
		return assignExam;
	}

	//List all the exams assigned
	@Override
	public List<AssignExam> find() {

		return assignExamDao.findAll();
	}
	//update the exam assigned
	@Override
	public AssignExam updateAssignedExam(AssignExam assignExam, int userId,int examId,int mark) {

		if(assignExamDao.existsById(assignExam.getExamUserId()))
		{
			assignExamDao.saveAndFlush(assignExam);	
		}

		return assignExam;
	}
	//delete the assigned exam
	@Override
	public AssignExam deleteAssignExam(int examUserId) throws AssignExamException {
		AssignExam assignExam =null;

		if(  assignExamDao.existsById(examUserId))
		{
			assignExam =  assignExamDao.findById(examUserId).get();
			assignExamDao.deleteById(examUserId);
		}
		else
		{
			throw new AssignExamException("ID "+examUserId+" NOT FOUND ");
		}
		return assignExam ;
	}


	//Get all the exams assigned to user
	@Override
	public List<AssignExam> checkExamAssignedToUSer(int userId) throws AssignExamException {



		return assignExamDao.checkExamsAssignedToUSer(userId);
	}

	//check the exam details of particular user with particular test Id
	@Override
	public AssignExam checkExamDetails(int examId, int userId) {
		// TODO Auto-generated method stub
		return assignExamDao.checkAssignedExamDetails(userId, examId);
	}


}
