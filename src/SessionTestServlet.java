import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionTestServlet")
public class SessionTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer count;
        count = (Integer)session.getAttribute("count");
        if (count == null){
            count = 1;
            session.setAttribute("count",count);
        }
        else{
            session.setAttribute("count",++count);
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h3>Your count is: "+count+"</h3>");
        writer.println("</html>");
    }
}
