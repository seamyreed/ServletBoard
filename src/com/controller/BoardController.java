package com.controller;

import com.model.BoardItem;
import com.repository.BoardRepository;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 7. 26..
 */
public class BoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("contents");
        String writer = req.getParameter("writer");

        BoardItem boardItem = new BoardItem();
        boardItem.setTitle(title);
        boardItem.setContent(content);
        boardItem.setWriter(writer);

        BoardRepository boardRepository = BoardRepository.getInstance();
        boardRepository.put(boardItem);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }

}