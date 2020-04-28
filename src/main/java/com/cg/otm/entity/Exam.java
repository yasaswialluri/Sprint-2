package com.cg.otm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="test_table")
public class Exam {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="test_sequence",allocationSize=1)
	@Column(name="testid")
	private int examId;

	@Column(name="testname",length=15)
	private String examTitle;

	@Column(name="testmarks")
	private double examMarks;



	@Column(name = "starttime", columnDefinition = "TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "hh:mm:ss")
	private Date startTime;

	@Column(name = "endtime", columnDefinition = "TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "hh:mm:ss")
	private Date endTime;

	@Column(name="duration")
	private int examDuration;

	@OneToMany(mappedBy="exam")
	@JsonIgnore
	List<Question>  question = new ArrayList<>();



	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public double getExamMarks() {
		return examMarks;
	}

	public void setExamMarks(double examMarks) {
		this.examMarks = examMarks;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}







}
