package com.controller;

import com.constant.AlertMessage;
import com.model.Member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hyojeongyoon on 2016. 7. 31..
 */
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            req.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.LOGOUT);
            String url = URLEncoder.encode(AlertMessage.LOGOUT, "UTF-8");
            resp.sendRedirect("/index.jsp?messageType=" + url);
        }
    }
}
