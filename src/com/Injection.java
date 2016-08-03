package com;

import com.repository.BoardRepositoryImpl;
import com.repository.MemberRepositoryImpl;
import com.service.BoardService;
import com.service.BoardServiceImpl;
import com.service.MemberService;
import com.service.MemberServiceImpl;

/**
 * Created by hyojeongyoon on 2016. 8. 2..
 */
public class Injection {
    private static BoardService sBoardService;
    private static MemberService sMemberService;

    public static BoardService provideBoardService() {
        if (sBoardService == null) {
            sBoardService = new BoardServiceImpl(BoardRepositoryImpl.getInstance());
        }
        return sBoardService;
    }

    public static MemberService proviceMemberService() {
        if (sMemberService == null) {
            sMemberService = new MemberServiceImpl(MemberRepositoryImpl.getInstance());
        }
        return sMemberService;
    }
}
