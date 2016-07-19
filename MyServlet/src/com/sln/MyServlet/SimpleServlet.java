package com.sln.MyServlet;

// http://www.codejava.net/ides/eclipse/how-to-create-deploy-and-run-java-servlet-in-eclipse
// http://www.javatpoint.com/creating-servlet-in-eclipse-ide

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// initParams as annotation can be used to provide default values, which can be overriden in web.xml: <init-param> </init-param>
@WebServlet(urlPatterns = {"/SimpleServlet", "*.aaa"}, initParams = {@WebInitParam(name="ProductName", value="Welcome Application")})
public class SimpleServlet extends HttpServlet {
    private String message;
    private String appName="MyApplication";

    public void init() throws ServletException {
        message = "Hello Worldy";
        appName = getInitParameter("ProductName");
    }

    //http://localhost:8080/MyServlet/SimpleServlet?name=aaaaa
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        //resp.setContentType("text/html");
    	resp.setContentType("text/xml");

        // Actual logic goes here.
        String name = req.getParameter("name");
        if (name!=null)
        	resp.getWriter().printf("<application><name>Hello %s</name>" + 
        							"<product>%s</product></application>", name, appName);
        else
        	resp.getWriter().println("Enter name");
    }

    //http://localhost:8080/MyServlet/NewFile.jsp
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        // Actual logic goes here.
        String name = req.getParameter("name");
        if (name.isEmpty() || name==null)
        	resp.sendRedirect("NewFile.jsp");
        else
        	resp.getWriter().println("<h1>" + message + ", " + name + "</h1>");
        	
    }

    public void destroy() {
        // do nothing.
    }
}
