package com.repository;

import com.model.BoardItem;

import java.util.List;

/**
 * Created by hyojeongyoon on 2016. 8. 2..
 */
public interface BoardRepository {
    List<BoardItem> findAll();

    void save(BoardItem boardItem);
}
