package com.service;

import com.model.Member;
import com.repository.MemberRepository;

/**
 * Created by hyojeongyoon on 2016. 7. 31..
 */
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findByMemberName(String memberName) {
        return memberRepository.findByMemberName(memberName);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }
}