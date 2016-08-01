package com.repository;

import com.model.Member;

/**
 * Created by hyojeongyoon on 2016. 8. 1..
 */
public interface MemberRepository {

    Member findByMemberName(String memberName);

    void save(Member member);
}
