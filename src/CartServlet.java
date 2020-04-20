import logic.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String preQuantity = request.getParameter("quantity");
        Integer quantity; // = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = (Cart) session.getAttribute("cart");
        if (name==null){
            name = "John";
        }
        if (preQuantity== null){
            quantity=-1;
        }
        else {
            try {

                quantity = Integer.parseInt(request.getParameter("quantity"));
                if (quantity<0){
                    quantity = -1;
                }
            }
            catch (Exception e){
                quantity=-1;
            }

        }
        if (cart==null){
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
            session.setAttribute("cart",cart);
        }
        else{
            cart.setName(name);
            cart.setQuantity(quantity);
            session.setAttribute("cart",cart);
        }

        String jpsPath = "/showCart.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(jpsPath);
        dispatcher.forward(request,response);
    }
}
