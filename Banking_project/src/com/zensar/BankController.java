package com.zensar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankController extends HttpServlet{


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		String requestAction = request.getParameter("requestAction");
		
		if(requestAction.equals("loginFormjsp")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			String logoutmsg = "Welcome, "+username;
			
			
			BankRepository sr = new BankRepository();
			boolean loginResult = sr.loginCheck(username, password);
			if(loginResult) {
				try {
					HttpSession session = request.getSession();
					session.setAttribute("logoutmsg", logoutmsg);
					//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					//rd.include(request, response);
					response.sendRedirect("index.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}else {
				System.out.println("login Failed");
				request.setAttribute("errorMessage", "Invalid user or password");
				RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("loginfailed catch"+e);
				}
			}
		}//login if 
		else if(requestAction.equals("newregistrationjsp")) {
			BankRepository bankRepository = new BankRepository();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int amount = Integer.parseInt(request.getParameter("amount"));
			String address =  request.getParameter("address");
			String phone = request.getParameter("phone");

			boolean newregresut = bankRepository.addAccount(username,password,amount,address,phone);
			if(newregresut) {


				System.out.println("registration successful");
				request.setAttribute("newreg", "registration Successful");
				RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("registartion failed catch"+e);
				} 
			}else {
				System.out.println("registration Failed");
				request.setAttribute("errorMessage", "registration failed");
				RequestDispatcher rd = request.getRequestDispatcher("newRegistration.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("registartion failed catch"+e);
				}
			}
		}//new registration else if
		else if(requestAction.equalsIgnoreCase("check"))
		{
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			BankRepository br = new BankRepository();
			BankBean bb = br.checkBalance(accountNumber,username,password);
			System.out.println(bb);
			RequestDispatcher rd = request.getRequestDispatcher("checkBalanceResult.jsp");

			request.setAttribute("bb", bb);
			
			try {
				//response.sendRedirect("result.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				
			}
			
		}
		else if(requestAction.equalsIgnoreCase("transferFormjsp")) {

			BankRepository br = new BankRepository();

			int accNo = Integer.parseInt(request.getParameter("accNo"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int bAccNo = Integer.parseInt(request.getParameter("bAccNo"));
			int amount = Integer.parseInt(request.getParameter("amount"));

			boolean result = br.transfer(accNo, username, password, bAccNo, amount);
			if(result) {
				System.out.println("transfer successful");
				request.setAttribute("transferMessage", "Transfer Successful");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("transferSuccessful catch"+e);
				}
			}else if(!result) {
				System.out.println("transfer failed");
				request.setAttribute("TransferMessage", "Invalid Credentials or amount");
				RequestDispatcher rd = request.getRequestDispatcher("transferForm.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("transferFailed catch"+e);
				}
			}
		}//Transfer else if
		else if(requestAction.equals("credit")) {

			int accNo = Integer.parseInt(request.getParameter("accNo"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int amount = Integer.parseInt(request.getParameter("amount"));

			BankRepository br = new BankRepository();
			boolean result = br.credit(accNo, username, password, amount);
			System.out.println(result);
			if(result) {
				System.out.println("Credit successful");
				request.setAttribute("creditMessage", "Credit Successful");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("creditSuccessful catch"+e);
				}
			}else if(!result) {
				System.out.println("credit failed");
				request.setAttribute("creditMessage", "Invalid Credentials ");
				RequestDispatcher rd = request.getRequestDispatcher("depositeForm.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("creditFailed catch"+e);
				}
			}

		}
		else if(requestAction.equalsIgnoreCase("withdraw")) {
			int accNo = Integer.parseInt(request.getParameter("accNo"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			BankBean bank = new BankBean(amount, accNo);
			BankRepository br = new BankRepository();
			boolean result = br.withdraw(accNo, username, password, amount);
			if(result) {
				System.out.println("debit successful");
				request.setAttribute("debitMessage", "Debit Successful");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("DebitSuccessful catch"+e);
				}
			}else if(!result) {
				System.out.println("Debit failed");
				request.setAttribute("debitMessage", "Invalid Credentials or amount ");
				RequestDispatcher rd = request.getRequestDispatcher("withdrawForm.jsp");

				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {

					System.out.println("debitFailed catch"+e);
				}
			}
		}
	else if(requestAction.equalsIgnoreCase("close")) {
		System.out.println("In Delete ");
		boolean result= false;

		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("fetched data from Form\n now calling bankRepository");
		System.out.println("In doGet() \n"+accountNumber+""+username+""+password);

		BankRepository br = new BankRepository();
		result = br.closeAccount(accountNumber,username,password);

		//RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		if(result) {
			System.out.println("Close successful");
			request.setAttribute("closeMessage", "Credit Successful");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			try {
				rd.forward(request, response);
				//response.sendRedirect("loginForm.jsp");
			} catch (Exception e) {

				System.out.println("creditSuccessful catch"+e);
			}
		}else if(!result) {
			System.out.println("close failed");
			request.setAttribute("closeMessage", "Invalid Credentials ");
			RequestDispatcher rd = request.getRequestDispatcher("depositeForm.jsp");

			try {
				rd.forward(request, response);
				//response.sendRedirect("loginForm.jsp");
			} catch (Exception e) {
				System.out.println("closeFailed catch"+e);
			}
		}
	}

}

public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException {
	doGet(request, response);
}

}
