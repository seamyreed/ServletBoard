package com.repository;

import com.model.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyojeongyoon on 2016. 7. 27..
 */
public class MemberRepositoryImplLocal implements MemberRepository {
    private static MemberRepositoryImplLocal sInstance;
    private Map<String, Member> members;

    private MemberRepositoryImplLocal() {
        members = new HashMap<String, Member>();
    }

    public static MemberRepositoryImplLocal getInstance() {
        if (sInstance == null) {
            sInstance = new MemberRepositoryImplLocal();

        }

        return sInstance;
    }

    @Override
    public Member findByMemberName(String memberName) {
        if (members.containsKey(memberName)) {
            return members.get(memberName);
        }

        return null;
    }

    @Override
    public void save(Member member) {
        members.put(member.getName(), member);
    }
}
