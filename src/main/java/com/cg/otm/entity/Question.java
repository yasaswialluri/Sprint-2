package com.cg.otm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class Question {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="question_sequence",allocationSize=1)
	@Column(name="questionid")
	private int questionId;

	@Column(name="questionname",length=40)
	private String questionTitle;




	@Column(name="quesop1",length=30)
	private String questionOption1;

	@Column(name="quesop2",length=30)
	private String questionOption2;

	@Column(name="quesop3",length=30)
	private String questionOption3;

	@Column(name="quesop4",length=30)
	private String questionOption4;

	@Column(name="quesans")
	private int questionAnswer;

	@Column(name="questionmarks")
	private double questionMark;

	@ManyToOne
	@JoinColumn(name="testid")
	private Exam  exam;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionOption1() {
		return questionOption1;
	}

	public void setQuestionOption1(String questionOption1) {
		this.questionOption1 = questionOption1;
	}

	public String getQuestionOption2() {
		return questionOption2;
	}

	public void setQuestionOption2(String questionOption2) {
		this.questionOption2 = questionOption2;
	}

	public String getQuestionOption3() {
		return questionOption3;
	}

	public void setQuestionOption3(String questionOption3) {
		this.questionOption3 = questionOption3;
	}

	public String getQuestionOption4() {
		return questionOption4;
	}

	public void setQuestionOption4(String questionOption4) {
		this.questionOption4 = questionOption4;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public double getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(double questionMark) {
		this.questionMark = questionMark;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}




}
