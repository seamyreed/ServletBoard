package com.controller.board.action;

import com.controller.Action;
import com.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class ListAction implements Action {
    private BoardService boardService;

    public ListAction(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public String fromUri() {
        return "/board/list";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("boardItems", boardService.getBoardItems());

        return "/index.jsp";
    }
}
