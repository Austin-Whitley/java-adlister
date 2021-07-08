import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //remove the attribute of user (to be extra safe)
        req.getSession().removeAttribute("user");
        //destroy the session
        req.getSession().invalidate();
        //send the user back to the login screen
        resp.sendRedirect("/login");





    }
}
