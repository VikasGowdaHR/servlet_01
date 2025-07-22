package servlet_01.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_01.dao.PatientDao;

@WebServlet("/da")
public class DeleteAll extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PatientDao patientdao=new PatientDao();
		String msg=patientdao.deleteAll();
		resp.getWriter().print(msg);
	}
}
