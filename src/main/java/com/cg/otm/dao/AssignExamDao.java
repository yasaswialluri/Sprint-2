package com.cg.otm.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.otm.entity.AssignExam;


@Repository
public interface AssignExamDao extends JpaRepository<AssignExam,Integer> {

	//query to get all the details of exam assigned to particular user 
	@Query("select e from AssignExam e where user.userId=:userid")
	public List<AssignExam> checkExamsAssignedToUSer(@Param("userid") int userId);

	//query to get info about assign exam with particular userId and particular testId
	@Query("select e from AssignExam e where user.userId=:userid and test.examId=:examid")
	public AssignExam checkAssignedExamDetails(@Param("userid") int userId,@Param("examid") int examId);
}
