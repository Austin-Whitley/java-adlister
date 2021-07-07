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
        //Checking if the person has ever logged in if not they take them to the login page
        if(request.getSession().getAttribute("isAdmin") != null) {
            response.sendRedirect("/secret-admin-page.jsp");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");

        HttpSession session = request.getSession();

        if (isAdmin) {
            session.setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
        } else {
            response.sendRedirect("/login");
        }



//       //////////////////////////////////////
//        // set the session object to a variable based on the HttpSession class
//        HttpSession session = request.getSession();
//
//        // set the dark theme attribute to session so it is stored and displayed everytime the user logs in
//        String darkMode = request.getParameter("color");
//        session.setAttribute("darkMode", darkMode);
//
//        // on a different servlet (profile)
//        //with the get attribute method the return is always a generic object type
//        // explicitly cast tot he correct type
//        session.getAttribute("darkMode");
//        String darkSelected = (String) session.getAttribute("darkMode");
//
//
//        // remove attribute only takes one argument to get rid of the attribute
//        session.removeAttribute("darkMode");
//
//        /// to destroy the session
//        session.invalidate();
//
//        // session resides in the session only ends in the server
//
//        // cookie is being tracked in the browser and are sent and saved in each session
//
//
    }

}