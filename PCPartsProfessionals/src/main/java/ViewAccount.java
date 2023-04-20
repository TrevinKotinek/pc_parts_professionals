

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.usersTable;
import util.UserUtil;
import util.Info;

@WebServlet("/ViewAccount")
public class ViewAccount extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;

    public ViewAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usersTable user = UserUtil.currentUser;
		PrintWriter out = response.getWriter();
		
		String title = "Login Failed";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<style> table, th, td { border:1px black solid; border-collapse:collapse; margin-left:auto; margin-right:auto;} </style>"
				+ "<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<br><h1 align=\"center\">" + 
				user.getUsername() + "<br>" + user.getPassword() + "<br>" + user.getEmail()	+ "</h1>\n");
		out.println("<br><br><a href=/" + projectName + "/" + accountsName + "><h3 align=\"center\">Back to accounts page</h3></a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
