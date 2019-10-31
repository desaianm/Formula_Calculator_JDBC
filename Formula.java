package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Formula extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Formula() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<form method=post action=process>");
		
		out.println("Value: <input type=text name=val value =98.6 > ");
		out.println("<input type=radio name=opt value=F checked=checked >F");
		out.println("<input type=radio name=opt value=C >C");
		
		
		out.println("<input type=submit value=Send>");
		
		out.println("</form>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
