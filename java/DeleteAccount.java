

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UserUtil;

@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verification = request.getParameter("deleteVerification");
		
		if (verification.equals("DELETE")) {
			deleteUser(response);
		}else {
			failedDelete(response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	void deleteUser(HttpServletResponse response) throws IOException {
		if(UserUtil.deleteUsersTable(UserUtil.currentUser.getId())) {
			response.sendRedirect(Info.loginName);
		}else {
			failedDelete(response);
		}
	}
	
	void failedDelete(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String title = "Delete Failed";
		String content = "<h3 align=\"center\">Oops! Something went wrong while deleting your account</h3><br>";
		
		String output = Info.PrettyPrint(title, title, content);
		
		out.print(output);
	}
}
