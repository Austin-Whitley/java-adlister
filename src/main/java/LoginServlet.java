import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            //if the user object has some value re-direct them to the profile servlet
            response.sendRedirect("/profile");
            return;
        }
        //if not send them back to the login page
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");
        boolean isLoggedIn = username.equals("user") && password.equals("upass");

        HttpSession session = request.getSession();

        if(isLoggedIn){
            session.setAttribute("user", username);
            response.sendRedirect("/profile");
        }else{
            response.sendRedirect("/login");
        }
    }
}
