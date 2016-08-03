package com.controller.board.action;

import com.controller.Action;
import com.model.BoardItem;
import com.service.BoardService;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class WriteAction implements Action {

    private BoardService boardService;

    public WriteAction(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public String fromUri() {
        return "/board/write";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        BoardItem boardItem = createBoardItem(request);
        boardService.save(boardItem);

        return "/board/list";
    }

    private BoardItem createBoardItem(HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");

        BoardItem boardItem = new BoardItem();
        boardItem.setTitle(title);
        boardItem.setContent(content);
        boardItem.setWriter(writer);

        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boardItem.setDate(simpleDateFormat.format(today));
        return boardItem;
    }
}
