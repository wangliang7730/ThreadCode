package com.servlet.User;

import com.ServiceImp.UserServiceImp;
import com.Util.MyHandler;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/servlet/PageQueryUserWL"})
public class PageQueryUserWL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页码
        Integer pageno=Integer.parseInt(request.getParameter("pageno") == null ? "1" : request.getParameter("pageno"));
        //获取代理对象
        UserService userService=(UserService) new MyHandler(new UserServiceImp()).getProxy();
        userService.selectAllUser2(request,3,pageno);
        //转发
        request.getRequestDispatcher("/system/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        doGet(req,resp);
    }
}
