import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        printWriter.println("<html>");
        printWriter.println("<h1> Hello, " + name+" "+surname+ "</h1>");
        printWriter.println("</html>");

        //response.sendRedirect("/hello-world-jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testJsp.jsp");
        //dispatcher.forward(request,response);
        response.sendRedirect("https://google.com/search?q=weather+novocherkassk");
    }
}
