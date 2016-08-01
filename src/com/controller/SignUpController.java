package com.controller;

import com.constant.AlertMessage;
import com.constant.URL;
import com.model.Member;
import com.repository.MemberRepository;
import com.repository.MemberRepositoryImpl;
import com.service.MemberServiceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 7. 26..
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String memberName = req.getParameter("memberName");
        String phoneNumber = req.getParameter("phoneNumber");

        MemberServiceImpl memberService = new MemberServiceImpl(MemberRepositoryImpl.getInstance());
        Member member = memberService.findByMemberName(memberName);

        if (member != null) {

            redirectSignUpView(req, resp);
        } else {

            member = createMember(req);
            memberService.save(member);
            redirectLoginView(req, resp);
        }
    }

    private Member createMember(HttpServletRequest req) {
        Member member = new Member();
        member.setName(req.getParameter("memberName"));
        member.setPhoneNumber(req.getParameter("phoneNumber"));
        return member;
    }

    private void redirectSignUpView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.SIGN_UP_DUPLICATED);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(URL.SIGN_UP);
        requestDispatcher.forward(req, resp);
    }

    private void redirectLoginView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.SIGN_UP_SUCCESS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(URL.LOGIN);
        requestDispatcher.forward(req, resp);
    }
}