import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/pizza-order")
public class HelloWorldServlet extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String crust = req.getParameter("crust"); //use a request to get a parameter from the user and set it to a String variable
        String sauce = req.getParameter("sauce");
        String size = req.getParameter("size");
        String address = req.getParameter("userAddress");
        String[] toppings = req.getParameterValues("toppingChoice");


//        req.setAttribute("crustChoice", crust);

        System.out.println("Crust selection: " + crust);
        System.out.println("Sauce selection: " + sauce);
        System.out.println("Size selection: " + size);
        System.out.println("Toppings: ");
        for(String t: toppings){
            System.out.println("   " + t);
        }
        System.out.println("Address: " + address);

        resp.sendRedirect("/pizza-order.jsp");
    }
}
