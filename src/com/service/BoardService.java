package com.service;

import com.model.BoardItem;

import java.util.List;

/**
 * Created by hyojeongyoon on 2016. 8. 2..
 */
public interface BoardService {
    List<BoardItem> getBoardItems();

    void save(BoardItem boardItem);
}
