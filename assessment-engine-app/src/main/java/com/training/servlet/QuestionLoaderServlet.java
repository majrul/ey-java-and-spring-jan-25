package com.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.datamodel.Question;
import com.training.datamodel.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	//int qNo = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		Integer qNo = (Integer) session.getAttribute("qNo");
		if(qNo == null)
			qNo = 0;
		
		
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		List<Question> questions = qbLoader.loadQuestionsOnJava();
		
		if(qNo < questions.size()) {
			Question q = questions.get(qNo++);
		
			session.setAttribute("qNo", qNo);
			session.setAttribute("question", q);
		
			response.sendRedirect("displayQuestion.jsp");
		}
		else
			response.sendRedirect("displayScore.jsp");
	}

}
