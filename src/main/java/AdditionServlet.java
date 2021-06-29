import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdditionServlet", urlPatterns = "/add")
public class AdditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int num1 = 0, num2 = 0;
        boolean goofDetected = false;

        try {
            num1 = Integer.parseInt(req.getParameter("num1"));
        }catch(NumberFormatException nfe){
            goofDetected = true;
            out.println("You done goofed, you didnt put your Num1 in the proper format!");
        }

        try{
            num2 = Integer.parseInt(req.getParameter("num2"));
        }catch(NumberFormatException nfe){
            goofDetected = true;
            out.println("You done goofed, you didnt put your Num2 in the proper format!");
        }

        if(!goofDetected) {
            out.println("<h1>" + num1 + " + " + num2 + " = " + (num1 + num2) + "</h1>");
        }
    }
}
