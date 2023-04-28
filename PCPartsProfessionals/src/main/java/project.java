
import datamodel.forumsTable;
import datamodel.listingsTable;
import datamodel.usersTable;
import util.ForumUtil;
import util.ListingUtil;
import util.UserUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class project extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public project() {
		super();
	}

	/*
	 * Run this file to check database connection and see database values
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		retrieveDisplayData(response.getWriter());
	}

	void retrieveDisplayData(PrintWriter out) {
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");
		List<forumsTable> listForums = ForumUtil.listForums();
		List<listingsTable> listTable = ListingUtil.listListings();
		UserUtil.createUsersTable("Trevin", "Kotinek", "trevin@kotinek", "111-222-3333");
		List<usersTable> listUsers = UserUtil.listUsers();
		for (forumsTable forum : listForums) {
			out.println("<li>" + forum.getId() + ", " //
					+ forum.getUsername() + ", " //
					+ forum.getTitle() + ", " + forum.getBody() + ", " + forum.getDate());
		}
		out.println("<br><br>");
		for (listingsTable list : listTable) {
			out.println("<li>" + list.getId() + ", " + list.getType() + ", " + list.getBrand() + ", " + list.getModel()
					+ ", " + list.getCondition() + ", " + list.getPrice() + ", " + list.getDate() + ", "
					+ list.getUser() + ", " + list.getEmail() + ", " + list.getPhone() + ", " + list.getCity() + ", "
					+ list.getState());
		}
		out.println("<br><br>");
		for (usersTable user : listUsers) {
			out.println("<li>" + user.getId() + ", " + user.getUsername() + ", " + user.getPassword() + ", "
					+ user.getEmail() + ", " + user.getPhone());
		}
		out.println("</ul>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
