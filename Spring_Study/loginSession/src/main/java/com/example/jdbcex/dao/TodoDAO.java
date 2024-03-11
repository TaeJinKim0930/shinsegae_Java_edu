package com.example.jdbcex.dao;


import com.example.jdbcex.domain.TodoVO;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Cleanup;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TodoDAO {


    // 연결한 DB 커넥션 풀로부터 연결후 시간 select now() 쿼리 결과를 담아서 리턴하는 getTime() 메소드 작성

    public String getTime() {
        String sql = "select now()";
        String result = "";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            if (rs.next()) {
                System.out.println("Get Time here");
                result = rs.getString(1);
            }
            return result;
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * version 2 using @Cleanup that cleans up all the connection automatically
     *
     * @return
     * @throws Exception
     */
    public String getTime2() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            return rs.getString(1);
        } else {
            return "WRONG";
        }
    }

    // insert() method 는 param 으로 TodoVO 객체의 정보를 이용해서 INSERT 명령을 실행하여 주세요
    // values : title, finished
    public void insert(TodoVO todoVO) {
        String sql = "INSERT INTO tbl_todo (title, dueDate, finished) values (?,?,?)";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, todoVO.getTitle());
            pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
            pstmt.setBoolean(3, todoVO.isFinished());
            pstmt.executeUpdate();
            System.out.println("Insertion made");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TodoVO> selectAll() throws Exception {
        String sql = "SELECT * FROM tbl_todo";
        List<TodoVO> todoVOList = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            int i = 0;
            while (rs.next()) {
                TodoVO todoVO = TodoVO.builder().tno(rs.getLong("tno"))
                        .title(rs.getString("title"))
                        .dueDate(rs.getDate("dueDate").toLocalDate())
                        .finished(rs.getBoolean("finished"))
                        .build();

                todoVOList.add(todoVO);
            }
//            todoVOList.forEach(System.out::println);
            return todoVOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todoVOList;
    }

    // SelectOne()
    public TodoVO selectOne(Long tno) {
        String sql = "SELECT * from tbl_todo where tno = ?";

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {
            pstmt.setLong(1, tno);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException();
            }
            TodoVO todoVO = TodoVO.builder().tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            return todoVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOne(Long tno) throws Exception {
        String sql = "DELETE FROM tbl_todo WHERE tno = ?";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setLong(1, tno);
            pstmt.executeUpdate();
            System.out.println("deleted");
        } catch (Exception e) {
            System.out.println("Deletion failed");
            e.printStackTrace();

        }
    }

    public void updateOne(TodoVO todoVO) throws Exception {
        String sql = "UPDATE tbl_todo SET " +
                "tno = ?," +
                "title = ?," +
                "dueDate = ?," +
                "finished = ?" +
                " where tno = ?";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setLong(1, todoVO.getTno());
            pstmt.setString(2, todoVO.getTitle());
            pstmt.setDate(3, Date.valueOf(todoVO.getDueDate()));
            pstmt.setBoolean(4, todoVO.isFinished());
            pstmt.setLong(5, todoVO.getTno());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}