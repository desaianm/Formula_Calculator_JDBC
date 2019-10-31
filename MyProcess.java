package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/process")
public class MyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyProcess() {
        super();
    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("opt");
		String value  = request.getParameter("val");
		
		
		
		double dval = Double.parseDouble(value);
		
		double result = (dval - 32) * 5.0 / 9.0;
		
		request.getSession().setAttribute("val", value);
		
		request.getSession().setAttribute("opt", option);
		
		request.getSession().setAttribute("result", result);
		
		response.sendRedirect("db");
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
