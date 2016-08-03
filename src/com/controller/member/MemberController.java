package com.controller.member;

import com.Injection;
import com.controller.ActionCommand;
import com.controller.member.action.LoginAction;
import com.controller.member.action.LogoutAction;
import com.controller.member.action.SignUpAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 7. 26..
 */
public class MemberController extends HttpServlet {
    private ActionCommand mActionCommand;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        mActionCommand = new ActionCommand();
        mActionCommand
                .addAction(new LoginAction())
                .addAction(new LogoutAction())
                .addAction(new SignUpAction(Injection.proviceMemberService()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = mActionCommand.execute(req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(uri);
        requestDispatcher.forward(req, resp);
    }
}