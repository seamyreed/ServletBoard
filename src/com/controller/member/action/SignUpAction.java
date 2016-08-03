package com.controller.member.action;

import com.constant.AlertMessage;
import com.controller.Action;
import com.model.Member;
import com.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class SignUpAction implements Action {
    private MemberService memberService;

    public SignUpAction(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public String fromUri() {
        return "/member/signUp";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String memberName = request.getParameter("memberName");

        Member member = memberService.findByMemberName(memberName);

        if (member != null) {
            request.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.SIGN_UP_DUPLICATED);

            return "/jsp/signUp.jsp";
        } else {

            member = createMember(request);
            memberService.save(member);
            request.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.SIGN_UP_SUCCESS);

            return "/jsp/login.jsp";
        }

    }

    private Member createMember(HttpServletRequest req) {
        Member member = new Member();
        member.setName(req.getParameter("memberName"));
        member.setPhoneNumber(req.getParameter("phoneNumber"));
        return member;
    }

}
