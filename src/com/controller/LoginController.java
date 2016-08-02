package com.controller;

import com.constant.AlertMessage;
import com.constant.JspUri;
import com.model.Member;
import com.repository.MemberRepositoryImpl;
import com.service.MemberServiceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hyojeongyoon on 2016. 7. 26..
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String memberName = req.getParameter("memberName");
        String phoneNumber = req.getParameter("phoneNumber");

        MemberServiceImpl memberService = new MemberServiceImpl(MemberRepositoryImpl.getInstance());
        Member member = memberService.findByMemberName(memberName);

        if (member == null) {

            redirectLoginView(req, resp);
        } else if (member.getPhoneNumber().equals(phoneNumber)) {

            createSession(req, member);
            redirectMainView(req, resp);
        }
    }

    private void redirectLoginView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.HAS_NOT_MEMBER);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(JspUri.LOGIN);
        requestDispatcher.forward(req, resp);
    }

    private void createSession(HttpServletRequest req, Member member) {
        HttpSession session = req.getSession();
        session.setAttribute("memberName", member.getName());
    }

    private void redirectMainView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.sendRedirect(JspUri.MAIN);
    }
}