import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Info;
import util.ForumUtil;
import datamodel.forumsTable;

/**
 * Servlet implementation class searchForums
 */
@WebServlet("/searchForums")
public class searchForums extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public searchForums() {
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchParam = request.getParameter("searchParam");
		String searchText = request.getParameter("search");
		displayData(response.getWriter(), searchParam, searchText);
	}
	
	void displayData(PrintWriter out, String param, String text) {
		String title = "Forums";
		String header = "Results";
		String content = "<ul>";
		
		List<forumsTable> listForums = util.ForumUtil.listForums();
		for (forumsTable post : listForums) {
			if (param.equals("MYUSER") && post.getUsername().equals(text)) {
				content += ("<li>" + post.getId() + ", "
						+ post.getUsername() + ", "
						+ post.getTitle() + ", "
						+ post.getDate()) + "</li>";
			}
			if (param.equals("TITLE") && post.getTitle().equals(text)) {
				content += ("<li>" + post.getId() + ", "
						+ post.getUsername() + ", "
						+ post.getTitle() + ", "
						+ post.getDate()) + "</li>";
			}
			
		}
		content += "</ul>";
		
		out.println(util.Info.PrettyPrint(title, header, content));
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
