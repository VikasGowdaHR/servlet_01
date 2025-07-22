package servlet_01.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_01.dao.PatientDao;

@WebServlet("/did")
public class DeleteById extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a=req.getParameter("pk");
		int cid=Integer.parseInt(a);
		
		PatientDao patientdao=new PatientDao();
		String msg=patientdao.deleteById(cid);
		resp.getWriter().print(msg);
	}
}
