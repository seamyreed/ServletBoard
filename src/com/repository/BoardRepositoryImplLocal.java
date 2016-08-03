package com.repository;

import com.model.BoardItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hyojeongyoon on 2016. 7. 28..
 */
public class BoardRepositoryImplLocal implements BoardRepository {

    private static BoardRepositoryImplLocal sInstance;
    private Map<Integer, BoardItem> boards;

    private BoardRepositoryImplLocal() {
        boards = new HashMap<Integer, BoardItem>();
    }

    public static BoardRepositoryImplLocal getInstance() {
        if (sInstance == null) {
            sInstance = new BoardRepositoryImplLocal();
        }

        return sInstance;
    }

    @Override
    public List<BoardItem> findAll() {
        List<BoardItem> list = Collections.list(Collections.enumeration(boards.values()));
        Collections.sort(list, new SequenceCompare());
        return list;
    }

    @Override
    public void save(BoardItem boardItem) {
        boardItem.setSeq(boards.size() + 1);
        boards.put(boardItem.getSeq(), boardItem);
    }

    /**
     * 내림차순 정렬
     */
    private static class SequenceCompare implements Comparator<BoardItem> {

        @Override
        public int compare(BoardItem o1, BoardItem o2) {
            return o1.getSeq() > o2.getSeq() ? -1 : (o1.getSeq() < o2.getSeq() ? 1 : 0);
        }
    }
}
