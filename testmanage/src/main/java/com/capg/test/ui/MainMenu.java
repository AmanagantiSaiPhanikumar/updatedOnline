package com.capg.test.ui;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.test.bean.Questions;

import com.capg.test.repository.MyRepository;
import com.capg.test.service.IQuestions;
import com.capg.test.service.QuestionsImp;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IQuestions service = new QuestionsImp();
		QuestionsImp services = new QuestionsImp();
		Scanner scan = new Scanner(System.in);

		Map map1 = MyRepository.goMap();

		int questionAdded = 0;
		while (true) {
			System.out.println("What you want to operate ");
			System.out.println("1. add Question");
			System.out.println("2.update Question ");
			System.out.println("3.delete Question ");
			System.out.println(map1);

			Questions question = new Questions();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:

				System.out.println(" enter the question  id to be added");
				int questionId = scan.nextInt();
				scan.nextLine();
				System.out.println(" enter the question  title to be added");
				String questionTitle = scan.nextLine();

				int n = 4;
				System.out.println(" enter the question  option to be added");
				String[] questionOption = new String[n];
				for (int i = 0; i < n; i++) {
					questionOption[i] = scan.next();
				}
				System.out.println(" enter the question  answer to be added");
				int questionAnswer = scan.nextInt();
				System.out.println(" enter the question  marks to be added");
				int questionMarks = scan.nextInt();

				question.setQuestionId(questionId);
				question.setQuestionTitle(questionTitle);
				question.setQuestionOption(questionOption);
				question.setQuestionAnswer(questionAnswer);
				question.setQuestionMarks(questionMarks);

				boolean isValid = QuestionsImp.userValidations(question);
				if (isValid) {

					System.out.println("valid");
					questionAdded = service.addQuestion(question);
				} else {
					System.out.println("invalid");
				}

				if (questionAdded == 1) {
					System.out.println("Questions are added");
				}

				break;

			case 2:
				System.out.println("enter the questionId");
				questionId = scan.nextInt();
				Map<Integer, Questions> map = services.getMap();
				Questions ques = map.get(questionId);
				System.out.println("enter the marks you want to update");
				questionMarks = scan.nextInt();
				int updateQuestion = services.updateQuestion(ques, questionMarks);
				break;
			case 3:

				System.out.println("enter the question to be deleted");

				int id = scan.nextInt();
				int deletedQuestion = service.deleteQuestion(id);
				System.out.println(deletedQuestion);
				if (deletedQuestion == 1) {
					System.out.println("question is deleted");
				}
				break;
			case 4:
				System.out.println("enter the marks");
				int mark = scan.nextInt();
				int result = service.getResult(mark);
				System.out.println(result);

				break;
			case 5:
				System.out.println("enter");
				int id1 = scan.nextInt();

				Set<Integer> all = service.getAllQuestions(id1);
				for (Integer i : all) {
					System.out.println(i);
				}

				break;

			default:
				break;
			}

		}

	}

}
