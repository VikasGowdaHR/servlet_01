package servlet_01.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import servlet_01.dao.PatientDao;

@WebServlet("/fid")
public class FindById extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("pk");
		int cid=Integer.parseInt(id);
		
		PatientDao patientDao=new PatientDao();
		Object o=patientDao.findById(cid);
		res.getWriter().print(o);
	}

}
