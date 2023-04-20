

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
		
		String title = "Account Info";
		String content = "<br><h1 align=\"center\">" + "<br><br>" + "Username: " + user.getUsername() 
		+ "<br>" + "Password: " + user.getPassword() + "<br>" + "Email: " + user.getEmail() + "<br>" + "Phone Number: " + user.getPhone()	+ "</h1>\n";
		
		String output = Info.PrettyPrint(title, title, content);
		out.print(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
