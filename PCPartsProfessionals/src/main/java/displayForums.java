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
 * Servlet implementation class displayForums
 */
@WebServlet("/displayForums")
public class displayForums extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public displayForums() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayData(response.getWriter());
	}
	
	void displayData(PrintWriter out) {
		String title = "Listings";
		String header = "Results";
		String content = "<ul>";
		
		List<forumsTable> listForums = util.ForumUtil.listForums();
			for (forumsTable post : listForums){
				//This is where the condition to check if the post is a reply should go.
				content += ("<li>" + post.getId() + ", "
						+ post.getUsername() + ", "
						+ post.getTitle() + ", "
						+ post.getDate()
					/* this code block appends a View Thread button, currently the viewThread servlet is not implemented.
        					+ "<form action=\"viewThread\" method=\"POST\">"
        					+ "<input type=\"hidden\" id=\"parentId\" value=\"" + post.getId() + "\">"
        					+ "<input type=\"submit\" value=\"View Thread\"></form>"
					*/
						+ "</li>");
}
content += "</ul>";
		out.println(util.Info.PrettyPrint(title, header, content));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
