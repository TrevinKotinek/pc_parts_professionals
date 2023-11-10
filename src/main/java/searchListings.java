import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.listingsTable;
import util.Info;
import util.ListingUtil;


@WebServlet("/searchListings")
public class searchListings extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public searchListings() {
      super();
   }

   
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String param = request.getParameter("searchParam");
      String search = request.getParameter("search");
      displayData(response.getWriter(), param, search);
      
   }
   
   void displayData(PrintWriter out, String param, String search) {
      String title = "Listings";
      String header = "Results";
      String content = "<ul>";
      
      List<listingsTable> listListings = util.ListingUtil.listListings();
      for (listingsTable listing : listListings) {
    	  if (param.equals("model") && listing.getModel().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
    	  if (param.equals("price") && listing.getPrice().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
    	  if (param.equals("city") && listing.getCity().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
    	  if (param.equals("partType") && listing.getType().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
    	  if (param.equals("brand") && listing.getBrand().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
    	  if (param.equals("condition") && listing.getCondition().equals(search)) {
    		  content += ("<li>" + listing.getId() + ", "
    				  + listing.getType() + ", "
    				  + listing.getBrand() + ", "
    				  + listing.getModel() + ", "
    				  + listing.getCondition() + ", "
    				  + listing.getPrice() + ", "
    				  + listing.getDate() + ", "
    				  + listing.getUser() + ", "
    				  + listing.getEmail() + ", "
    				  + listing.getPhone() + ", "
    				  + listing.getCity() + ", "
    				  + listing.getState());
    	  }
      }
         content += "</ul>";
    	  
    	  out.println(util.Info.PrettyPrint(title, header, content));
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
