package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class ActionCommand {
    private List<Action> actions;

    public ActionCommand() {
        this.actions = new ArrayList<Action>();
    }

    public ActionCommand addAction(Action action) {
        actions.add(action);
        return this;
    }

    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        for (Action action : actions) {
            if (action.fromUri().equals(req.getRequestURI())) {
                return action.execute(req, resp);
            }
        }

        // TODO : 올바르지 않은 Uri인 경우 예외 처리 필요.
        return "";
    }
}
