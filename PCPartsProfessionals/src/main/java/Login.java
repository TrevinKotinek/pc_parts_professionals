

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserUtil;
import util.Info;

@WebServlet("/Login")
public class Login extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("pass").trim();
		
		PrintWriter out = response.getWriter();
		
		if(UserUtil.userExists(username, password)) {
			loginSucceeded(response);
		}else {
			loginFailed(out);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void loginSucceeded(HttpServletResponse response) throws IOException {
		response.sendRedirect("pc_parts_Accounts.html");
	}
	
	void loginFailed(PrintWriter out) {
		String title = "Login Failed";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<style> table, th, td { border:1px black solid; border-collapse:collapse; margin-left:auto; margin-right:auto;} </style>"
				+ "<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<br><h1 align=\"center\" style=\"color:red\">" + title + "</h1>\n");
		out.println("<br><br><a href=/" + projectName + "/" + loginName + "><h3 align=\"center\">Retry Login</h3></a>");		
	}
}
