package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/theresult")
public class TheResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TheResult() {
        super();
    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			String value = (String) request.getSession().getAttribute("val");
			String option = (String) request.getSession().getAttribute("opt");
			double result = (Double) request.getSession().getAttribute("result");
			String cdate = (String) request.getSession().getAttribute("date");
			String ctime = (String) request.getSession().getAttribute("time");
			
			out.println("<h1> Results are : </h1>");
			
			out.println("Val: " + value + "<br>");
			out.println("Opt: " + option + "<br>");
			out.println("Result :" + result + "<br>");
			out.println("Date: " + cdate + "<br>");
			out.println("Time: " + ctime + "<br>");
			
			
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
