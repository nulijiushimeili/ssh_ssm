package action;


import moduels.Emp;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/emp.do")
public class EmpAction extends HttpServlet {

    EmpService empService = new EmpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("id");
        int id = 0 ;
        if(str != null && str.equals(""))id = Integer.parseInt(str);
        Emp emp = empService.load(id);
        req.setAttribute("emp",emp);
    }
}
