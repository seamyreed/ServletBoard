package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public interface Action {
    String fromUri();

    String execute(HttpServletRequest request, HttpServletResponse response);
}
