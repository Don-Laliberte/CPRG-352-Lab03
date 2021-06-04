package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toesl
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Capture the parameters from the POST request (the form)
        String ageValue = request.getParameter("age_value");
        //Sets the input to the previous answer
        request.setAttribute("age_value", ageValue);
        
        // validation: if the parameters don't exist or are empty, show the form again
        if(ageValue == null || ageValue == ""){
            // Create a helpful message to send to the user
            request.setAttribute("message", "Invalid entry. You must give your current age");
            request.setAttribute("outputmessage", true);
            // forward the reuqest and response objects to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;// Very important! Stop the code call.
        }
        else {
        
            // set the attributes for the JSP               
            request.setAttribute("message", "Your age next birthday will be " + (+Integer.parseInt(ageValue) + 1));
            // display the helloWorld JSP 
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);            

        }
        
        
    }


}
