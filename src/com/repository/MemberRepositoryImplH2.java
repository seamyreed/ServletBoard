package com.repository;

import com.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hyojeongyoon on 2016. 8. 4..
 */
public class MemberRepositoryImplH2 implements MemberRepository {
    private static MemberRepositoryImplH2 sInstance;

    private MemberRepositoryImplH2() {
    }

    public static MemberRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MemberRepositoryImplH2();
        }

        return sInstance;
    }

    @Override
    public Member findByMemberName(String memberName) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = null;

        Member member = null;

        try {

            String query = "SELECT * FROM MEMBER WHERE Member_Name = '" + memberName + "'";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Member_Name");
                String phoneNumber = resultSet.getString("Phone_Number");

                member = new Member();
                member.setName(name);
                member.setPhoneNumber(phoneNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                try {
                    preparedStatement.close();
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        return member;
    }

    @Override
    public void save(Member member) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO MEMBER (Member_Name, Phone_Number) VALUES(?,?)";

            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getPhoneNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                try {
                    preparedStatement.close();
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
