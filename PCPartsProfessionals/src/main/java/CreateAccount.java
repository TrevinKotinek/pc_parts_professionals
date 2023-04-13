import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

import util.Info;
import util.ListingUtil;

@WebServlet("/CreateAccount")
public class CreateListing extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CreateAccount() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username = request.getParameter("username").trim();
      String password = request.getParameter("pass").trim();
      String email = request.getParameter("email").trim();
      String phonenumber = request.getParameter("phonenumber").trim();
        
      ListingUtil.createUserTable(username, password, email, phonenumber);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> User: " + username);
      out.println("<li> Email: " + email);
      out.println("<li> Phone: " + phonenumber);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + createAccountName + ">Create Account</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}