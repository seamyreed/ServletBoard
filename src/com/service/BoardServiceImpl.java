package com.service;

import com.model.BoardItem;
import com.repository.BoardRepository;

import java.util.List;

/**
 * Created by hyojeongyoon on 2016. 8. 2..
 */
public class BoardServiceImpl implements BoardService {
    private BoardRepository mBoardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        mBoardRepository = boardRepository;
    }

    @Override
    public List<BoardItem> getBoardItems() {
        return mBoardRepository.findAll();
    }

    @Override
    public void save(BoardItem boardItem) {
        mBoardRepository.save(boardItem);
    }
}
