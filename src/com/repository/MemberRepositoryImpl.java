package com.repository;

import com.model.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyojeongyoon on 2016. 7. 27..
 */
public class MemberRepositoryImpl implements MemberRepository {
    private static MemberRepositoryImpl sInstance;
    private Map<String, Member> members;

    private MemberRepositoryImpl() {
        members = new HashMap<String, Member>();
    }

    public static MemberRepositoryImpl getInstance() {
        if (sInstance == null) {
            sInstance = new MemberRepositoryImpl();

        }

        return sInstance;
    }

    public Member put(Member member) {
        if (members.containsKey(member.getName())) {
            return null;
        }
        return members.put(member.getName(), member);
    }

    public boolean has(Member member) {
        if (members.containsKey(member.getName())) {
            Member hadMember = members.get(member.getName());
            return hadMember.getPhoneNumber().equals(member.getPhoneNumber());
        }

        return false;
    }

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
