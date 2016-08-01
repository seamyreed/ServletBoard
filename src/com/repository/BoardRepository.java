package com.repository;

import com.model.BoardItem;
import com.model.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyojeongyoon on 2016. 7. 28..
 */
public class BoardRepository {

    private static BoardRepository sInstance;
    private Map<Integer, BoardItem> boards;

    private BoardRepository() {
        boards = new HashMap<Integer, BoardItem>();
    }

    public static BoardRepository getInstance() {
        if (sInstance == null) {
            sInstance = new BoardRepository();
        }

        return sInstance;
    }

    public BoardItem put(BoardItem item) {
        if (boards.containsKey(item.getSeq())) {
            return null;
        }

        return boards.put(item.getSeq(), item);
    }

    public boolean has(BoardItem item) {
        return boards.containsKey(item.getSeq());
    }


}
