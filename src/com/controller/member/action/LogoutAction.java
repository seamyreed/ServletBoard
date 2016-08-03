package com.controller.member.action;

import com.constant.AlertMessage;
import com.controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class LogoutAction implements Action {

    @Override
    public String fromUri() {
        return "/member/login";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            request.setAttribute(AlertMessage.ATTRIBUTE_NAME, AlertMessage.LOGOUT);
        }

        return "/index.jsp";
    }
}
