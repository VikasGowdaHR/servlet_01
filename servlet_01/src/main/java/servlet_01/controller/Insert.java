package servlet_01.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import servlet_01.dao.PatientDao;
import servlet_01.dto.PatientDto;

@WebServlet("/a")
public class Insert implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=req.getParameter("id");
		int ca=Integer.parseInt(a);
		String b=req.getParameter("name");
		String c=req.getParameter("email");
		String d=req.getParameter("pwd");
//		System.out.println(a+" "+b+" "+c+" "+d);
//		res.getWriter().print("data inserted");
		
		PatientDto patientDto=new PatientDto();
		patientDto.setId(ca);
		patientDto.setName(b);
		patientDto.setEmail(c);
		patientDto.setPassword(d);
		System.out.println(patientDto);
		
		PatientDao patientDao=new PatientDao();
		String msg=patientDao.insert(patientDto);
		res.getWriter().print(msg);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
