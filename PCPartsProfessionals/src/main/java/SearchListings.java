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


@WebServlet("/SearchListings")
public class SearchListings extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SearchListings() {
      super();
   }

   
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String param = request.getParameter("searchParam");
      String search = request.getParameter("search");
      List<listingsTable> listings = ListingUtil.listListings();
      Iterator<listingsTable> iterator = listings.iterator();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Listings";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<table>");
      out.println("<tr>");
      out.println("<th>ID</th>");
      out.println("<th>Model</th>");
      out.println("<th>Price</th>");
      out.println("<th>City</th>");
      out.println("<th>State</th>");
      out.println("<th>Type</th>");
      out.println("<th>Brand</th>");
      out.println("<th>Condition</th>");
      out.println("<th>Date</th>");
      out.println("<th>User</th>");
      out.println("<th>Email</th>");
      out.println("<th>Phone</th>");
      out.println("</tr>");
      
      while(iterator.hasNext()) {
    	  listingsTable listing = iterator.next();
    	  boolean printCurrentListing = false;
    	  switch (param) {

    	  	case "model":
    	  		if (search.equals(listing.getModel())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  	case "price":
    	  		if (search.equals(listing.getPrice())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  	case "city":
    	  		if (search.equals(listing.getCity())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  	case "partType":
    	  		if (search.equals(listing.getType())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  	case "brand":
    	  		if (search.equals(listing.getBrand())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  	case "condition":
    	  		if (search.equals(listing.getCondition())) {
    	  			printCurrentListing = true;
    	  		}
    	  		break;
    	  }
    	  
    	  if (printCurrentListing) {
    		  out.println("<tr>");
    		  out.println("<td>"+ listing.getType() +"</td>");
    		  out.println("<td>"+ listing.getBrand() +"</td>");
    		  out.println("<td>"+ listing.getModel() +"</td>");
    		  out.println("<td>"+ listing.getCondition() +"</td>");
    		  out.println("<td>"+ listing.getPrice() +"</td>");
    		  out.println("<td>"+ listing.getDate() +"</td>");
    		  out.println("<td>"+ listing.getUser() +"</td>");
    		  out.println("<td>"+ listing.getEmail() +"</td>");
    		  out.println("<td>"+ listing.getPhone() +"</td>");
    		  out.println("<td>"+ listing.getCity() +"</td>");
    		  out.println("<td>"+ listing.getState() +"</td>");
    		  out.println("</tr>");
    		  printCurrentListing = false;
    	  }
      }
      
      out.println("</table>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
