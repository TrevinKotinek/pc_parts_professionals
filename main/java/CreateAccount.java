import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Info;
import util.UserUtil;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CreateAccount() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username = request.getParameter("username").trim();
      String password = request.getParameter("pass").trim();
      String email = request.getParameter("email").trim();
      String phonenumber = request.getParameter("phonenumber").trim();
        
      String message = UserUtil.createUsersTable(username, password, email, phonenumber);

      if (message.equals("success")) {
    	  response.sendRedirect(Info.accountsName);
      }else {
    	  String title = "Error Creating Account";
    	  String content = "<h3 align=\"center\">Sorry that " + message + " is already taken, please try another.</h3><br>";
    	  String output = Info.PrintNotLoggedIn(title, title, content);
    	  PrintWriter out = response.getWriter();
    	  out.print(output);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
