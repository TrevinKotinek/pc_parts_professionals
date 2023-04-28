package util;

public interface Info {
   public String projectName = "PCPartsProfessionals";
   public String loginName = "pc_parts_Login.html";
   public String listingsName = "pc_parts_Listings.html";
   public String accountsName = "pc_parts_Accounts.html";
   public String createListingsName = "pc_parts_CreateListing.html";
   
   public static String PrettyPrint(String title, String header, String content) {
	   String HTMLResult = "<!DOCTYPE html>"
	   		+ "<html><head><meta charset=\"UTF-8\"><title>"
			   + title + "</title>"
			   + "<!-- Link CSS -->"
			   + "<link rel=\"stylesheet\" type=\"text/css\" href=\"pc_parts_Style.css\"/>"
			   + "</head>"
			   + "<body>"
			   + "<header>\r\n"
			   + "	<h1>" + header + "</h1>"
			   + "\r\n"
			   + "</header>"
			   + "<!-- Display Welcome Message -->"
			   + "<!-- Navigation Links -->\r\n"
			   + "<div class=\"topnav\">\r\n"
			   + "<a href=\"pc_parts_Login.html\">Log Out</a>\r\n"
			   + "<a href=\"pc_parts_Accounts.html\">Accounts</a>\r\n"
			   + "<a href=\"pc_parts_Listings.html\">Listings</a>\r\n"
			   + "<a href=\"pc_parts_Forum.html\">Forum</a>\r\n"
			   + "</div>"
			   + content
			   + "</body>\r\n"
			   + "</html>";
	   return HTMLResult;
   }
}
