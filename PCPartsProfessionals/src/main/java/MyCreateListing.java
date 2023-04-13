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

@WebServlet("/MyCreateListing")
public class MyCreateListing extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public MyCreateListing() {
      super();
   }

   
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String model = request.getParameter("model").trim();
      String price = request.getParameter("price").trim();
      String city = request.getParameter("city").trim();
      String type = request.getParameter("partType").trim();
      String brand = request.getParameter("brand").trim();
      String condition = request.getParameter("condition").trim();
      
      String dateString = java.time.LocalDateTime.now().toString();
      
      String user = "Work In Progress";		//Work In Progress
      String email = "wip@test.com";		//Work In Progress
      String phone = "402-555-5555";		//Work In Progress
      String state = "Work In Progress";	//Work In Progress
        
      
      ListingUtil.createlistingsTable(type, brand, model, condition, price, dateString, user,
  			email, phone, city, state);

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
      out.println("<li> Model: " + model);
      out.println("<li> Price: " + price);
      out.println("<li> City: " + city);
      out.println("<li> State: " + state);
      out.println("<li> Type: " + type);
      out.println("<li> Brand: " + brand);
      out.println("<li> Condition: " + condition);
      out.println("<li> Date: " + dateString);
      out.println("<li> User: " + user);
      out.println("<li> Email: " + email);
      out.println("<li> Phone: " + phone);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + createListingsName + ">Create Listings</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
