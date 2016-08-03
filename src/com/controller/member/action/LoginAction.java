package com.controller.member.action;

import com.constant.AlertMessage;
import com.controller.Action;
import com.model.Member;
import com.repository.MemberRepositoryImpl;
import com.service.MemberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class LoginAction implements Action {
    @Override
    public String fromUri() {
        return "/member/login";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String memberName = request.getParameter("memberName");
        String phoneNumber = request.getParameter("phoneNumber");

        MemberServiceImpl memberService = new MemberServiceImpl(MemberRepositoryImpl.getInstance());
        Member member = memberService.findByMemberName(memberName);

        if (member == null) {
            request.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.HAS_NOT_MEMBER);

            return "/jsp/login.jsp";
        } else if (member.getPhoneNumber().equals(phoneNumber)) {

            HttpSession session = request.getSession();
            session.setAttribute("memberName", member.getName());

            return "/index.jsp";
        } else {

            return "/index.jsp";
        }
    }
}
