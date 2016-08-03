package com.repository;

import com.model.BoardItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyojeongyoon on 2016. 8. 3..
 */
public class BoardRepositoryImplH2 implements BoardRepository {
    private static BoardRepositoryImplH2 sInstance;
    private ResultSet mResultSet;
    private PreparedStatement mPreparedStatement;

    private BoardRepositoryImplH2() {}

    public static BoardRepository getInstance() {
        if (sInstance == null) {
            sInstance = new BoardRepositoryImplH2();
        }

        return sInstance;
    }

    @Override
    public List<BoardItem> findAll() {
        Connection conn = ConnectionHelper.getConnection();
        List<BoardItem> boardItems = new ArrayList<BoardItem>();

        try {

            String query = "SELECT * FROM BOARD ORDER BY seq DESC";
            mPreparedStatement = conn.prepareStatement(query);
            mResultSet = mPreparedStatement.executeQuery();

            while (mResultSet.next()) {
                int seq = mResultSet.getInt("seq");
                String title = mResultSet.getString("title");
                String content = mResultSet.getString("content");
                String writer = mResultSet.getString("writer");
                String date = mResultSet.getString("date");

                BoardItem item = new BoardItem();
                item.setSeq(seq);
                item.setTitle(title);
                item.setContent(content);
                item.setWriter(writer);
                item.setDate(date);
                boardItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (mPreparedStatement != null) {

                try {
                    mPreparedStatement.close();
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        return boardItems;
    }

    @Override
    public void save(BoardItem boardItem) {
        Connection conn = ConnectionHelper.getConnection();

        try {
            String query = "INSERT INTO BOARD (Title, Content, Writer, Date) VALUES(?,?,?,?)";

            mPreparedStatement = conn.prepareStatement(query);
            mPreparedStatement.setString(1, boardItem.getTitle());
            mPreparedStatement.setString(2, boardItem.getContent());
            mPreparedStatement.setString(3, boardItem.getWriter());
            mPreparedStatement.setString(4, boardItem.getDate());

            mPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (mPreparedStatement != null) {

                try {
                    mPreparedStatement.close();
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
