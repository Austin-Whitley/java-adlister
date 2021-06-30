import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "View Counter Page", urlPatterns = "/count")
public class ViewCounter extends HttpServlet{
    public int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        String reset = req.getParameter("reset");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        count++;

        if(req.getParameter("reset") != null){
            count = 1;
        }
        out.println("<h1>" + count + "</h1>");
    }
}
