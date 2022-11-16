package com.java.ejb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployCrud
 */
@WebServlet("/EmployCrud")
public class EmployCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployCrudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
	
			   EmployCrudServlet service = null;

			    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

			    // service = (HelloService)new
			    // InitialContext().lookup("java:comp/env/ejb/HelloService");
			    try {
					service = (EmployCrudServlet)
							new InitialContext().lookup("EmployCrudBean/remote");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    List<Employ> employList = service.showEmployBean();
			    for (Employ employ : employList) {
					System.out.println(employ);
				}
		}

	private List<Employ> showEmployBean() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
