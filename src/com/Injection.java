package com;

import com.repository.BoardRepositoryImpl;
import com.service.BoardService;
import com.service.BoardServiceImpl;

/**
 * Created by hyojeongyoon on 2016. 8. 2..
 */
public class Injection {
    private static BoardService sBoardService;

    public static BoardService provideBoardService() {
        if (sBoardService == null) {
            sBoardService = new BoardServiceImpl(BoardRepositoryImpl.getInstance());
        }
        return sBoardService;
    }
}
