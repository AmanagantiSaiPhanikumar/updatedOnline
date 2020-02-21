package com.capg.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.test.bean.Questions;
import com.capg.test.dao.QuestionsDAO;
import com.capg.test.service.QuestionsImp;

class OnlineTest {

	static QuestionsImp service;

	@BeforeAll
	public static void getQues() {
		service = new QuestionsImp();
	}

	Questions questionobj = new Questions();

	@Test
	void testDeleteQuestion() {

		questionobj.setQuestionId(5);
		Map<Integer, Questions> map = new HashMap<Integer, Questions>();
		map.put(questionobj.getQuestionId(), questionobj);
		int res = service.deleteQuestion(questionobj.getQuestionId());

		assertEquals(1, res);

	}

	@Test
	void testGetResult() {
		questionobj.setQuestionMarks(5);
		Map<Integer, Questions> map = new HashMap<Integer, Questions>();
		map.put(questionobj.getQuestionId(), questionobj);
		int res = service.deleteQuestion(questionobj.getQuestionMarks());
		assertEquals(1, res);

	}
@Test
	void testUserValidations() {
		questionobj.setQuestionId(1);
		questionobj.setQuestionTitle("what is 1+1");
		questionobj.setQuestionAnswer(0);
		String[] questionOption = { " 1", "2", "3", " 4", " 5" };

		questionobj.getQuestionOption();

		questionobj.setQuestionMarks(1);

		boolean res = QuestionsImp.userValidations(questionobj);
		assertEquals(true, res);

	}

}
