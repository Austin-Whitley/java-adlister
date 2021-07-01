import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); //use a request to get a parameter from the user and set it to a String variable
        req.setAttribute("nameVar", name); // request that an attribute with the title: "nameVar" gets set as the name variable
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }

    //Make a new method to post information
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("nameVar", name);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}
