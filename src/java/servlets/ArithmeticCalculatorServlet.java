/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toesl
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "Request: ---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    //Capture the parameters from the POST request (the form)
        request.setAttribute("message", "Request: ---");
        String firstValue = request.getParameter("first_value");
        String secondValue = request.getParameter("second_value");
        //Sets the input to the previous answer
        request.setAttribute("first_value", firstValue);
        request.setAttribute("second_value", secondValue);
        
        // validation: if the parameters don't exist or are empty, show the form again
        if(firstValue == null || firstValue == ""){
            // Create a helpful message to send to the user
            request.setAttribute("message", "Request: Invalid entry. You must enter the first number");
            // forward the reuqest and response objects to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;// Very important! Stop the code call.
        }
        else if (secondValue  == null || secondValue == "") {
                        // Create a helpful message to send to the user
            request.setAttribute("message", "Request: Invalid entry. You must enter the second number");
            // forward the reuqest and response objects to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;// Very important! Stop the code call.
        }
        else {
        
            // set the attributes for the JSP depending on which button the user pressed            
            if (request.getParameter("add") != null) { //Checks if Add button is not pressed
                request.setAttribute("message", "Result: " + (Integer.parseInt(firstValue) + Integer.parseInt(secondValue))); 
            }
            else if (request.getParameter("minus") != null) { //Checks if Subtract button is not pressed
                request.setAttribute("message", "Result: " + (Integer.parseInt(firstValue) - Integer.parseInt(secondValue)));
            }
            else if (request.getParameter("multiply") != null) { //Checks if Multiply button is not pressed
                request.setAttribute("message", "Result: " + (Integer.parseInt(firstValue) * Integer.parseInt(secondValue)));
            }
            else if (request.getParameter("modulus") != null) { //Checks if Modulo button is not pressed
                request.setAttribute("message", "Result: " + (Integer.parseInt(firstValue) % Integer.parseInt(secondValue)));
            }            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);            

        }
    }

}
