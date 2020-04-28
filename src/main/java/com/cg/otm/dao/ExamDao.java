package com.cg.otm.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.otm.entity.Exam;
@Repository
public interface ExamDao extends JpaRepository<Exam,Integer>{

}
