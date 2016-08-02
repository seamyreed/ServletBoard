package com.controller;

import com.Injection;
import com.constant.JspUri;
import com.constant.ServletUri;
import com.model.BoardItem;
import com.service.BoardService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (req.getRequestURI().equals(ServletUri.BOARD_LIST)) {
            BoardService boardService = Injection.provideBoardService();
            req.setAttribute("boardItems", boardService.getBoardItems());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(JspUri.MAIN);
            requestDispatcher.forward(req, resp);

            // TODO : sendRedirect로 요청하면 왜 attribute를 받을 수 없나? 같은 요청 아닌가?
//            resp.sendRedirect(JspUri.MAIN);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (req.getRequestURI().equals(ServletUri.WRITE_BOARD_ITEM)) {
            updateItem(req);

            resp.sendRedirect(ServletUri.BOARD_LIST);
        }
    }

    private void updateItem(HttpServletRequest req) {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writer = req.getParameter("writer");

        BoardItem boardItem = new BoardItem();
        boardItem.setTitle(title);
        boardItem.setContent(content);
        boardItem.setWriter(writer);

        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boardItem.setDate(simpleDateFormat.format(today));

        BoardService boardService = Injection.provideBoardService();
        boardService.save(boardItem);
    }
}