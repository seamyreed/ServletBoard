package com;

import com.repository.BoardRepositoryImplH2;
import com.repository.MemberRepositoryImplH2;
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
            sBoardService = new BoardServiceImpl(BoardRepositoryImplH2.getInstance());
        }
        return sBoardService;
    }

    public static MemberService provideMemberService() {
        if (sMemberService == null) {
            sMemberService = new MemberServiceImpl(MemberRepositoryImplH2.getInstance());
        }
        return sMemberService;
    }
}
