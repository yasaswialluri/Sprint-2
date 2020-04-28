package com.cg.otm.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.otm.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	//query to get all the questions in a particular test
	@Query(" FROM Question where exam.examId=:id")
	public List<Question>  findQuestionInTest(@Param("id") int examId);
}
