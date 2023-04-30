

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UserUtil;

@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean errorPrinted = false;
    public EditAccount() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("field").trim();
		String oldValue = request.getParameter("currentval").trim();
		String newValue = request.getParameter("newval").trim();
		PrintWriter out = response.getWriter();
		
		if(oldValue.isBlank()) {
			printError(out, "Oops, you left the 'Current Value' field blank");
		}else if(newValue.isBlank()) {
			printError(out, "Oops, you left the 'New Value' field blank");
		}else {
			evaluateChange(field, oldValue, newValue, out, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void printError(PrintWriter out, String errorMessage) {
		String output;
		String title = "Error Editing Account";
		
		String content = "<h3 align=\"center\">" + errorMessage + "</h3><br>";
		
		output = Info.PrettyPrint(title, title, content);
		out.print(output);
		errorPrinted = true;
	}
	
	void evaluateChange(String field, String oldValue, String newValue, PrintWriter out, HttpServletResponse response) throws IOException {
		boolean success = false;
		
		if(field.equals("username")) {
			if(oldValue.equals(UserUtil.currentUser.getUsername())) {
				success = UserUtil.updateUsername(newValue);
			}else {
				printError(out, "Oops, the username you put as the current value doesn't match your current username");
			}
			
		}else if(field.equals("email")) {
			if(oldValue.equals(UserUtil.currentUser.getEmail())) {
				success = UserUtil.updateEmail(newValue);
			}else {
				printError(out, "Oops, the email you put as the current value doesn't match your current email");
			}
			
		}else if(field.equals("phone")) {
			if(oldValue.equals(UserUtil.currentUser.getPhone())) {
				success = UserUtil.updatePhone(newValue);
			}else {
				printError(out, "Oops, the phone number you put as the current value doesn't match your current phone number");
			}
			
		}else {
			if(oldValue.equals(UserUtil.currentUser.getPassword())) {
				success = UserUtil.updatePassword(newValue);
			}else {
				printError(out, "Oops, the password you put as the current value doesn't match your current password");
			}
		}
		
		if(success) {
			response.sendRedirect(Info.accountsName);
		}else {
			if(!errorPrinted) {
				printError(out, "Oops, that value is already being used by another account.  Please try again with a new value");
			}
		}
	}

}
