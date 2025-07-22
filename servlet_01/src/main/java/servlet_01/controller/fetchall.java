package servlet_01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_01.dao.PatientDao;
import servlet_01.dto.PatientDto;

@WebServlet("/fall")
public class fetchall extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PatientDao patientDao=new PatientDao();
		List<PatientDto> list=patientDao.fetchAll();
		resp.getWriter().print(list);
	}
}
