import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.forumsTable;
import util.ForumUtil;
import util.Info;

@WebServlet("/viewThread")
public class viewThread extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public viewThread(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parentId = request.getParameter("parentId");
        displayData(response.getWriter(), parentId);
    }
    
    void displayData(PrintWriter out, Integer parentId){
        String title = "Forum";
        String header = "Post";
        String content = "<ul>";

        List<forumsTable> listForums = util.ForumUtil.listForums();
            for (forumsTable post : listForums){
                if (post.getId() == parentId || post.getParent() == parentId){
                    content += ("<li>" + post.getTitle() + ", " + post.getUser()
                    + "<br>" + post.getBody() + "<br><br></li>");
                }
            }
            content += "</ul>";
            out.println(util.Info.PrettyPrint(title, header, content));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
