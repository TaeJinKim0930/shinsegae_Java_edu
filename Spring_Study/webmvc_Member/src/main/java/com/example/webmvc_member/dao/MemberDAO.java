package com.example.webmvc_member.dao;

import com.example.webmvc_member.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class MemberDAO {

    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select mid, mpw, mname, memail, reg_date from member where mid = ? and mpw = ?";

        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstsmt = connection.prepareStatement(sql);
        pstsmt.setString(1, mid);
        pstsmt.setString(2, mpw);

        @Cleanup ResultSet rs = pstsmt.executeQuery();

        rs.next();

        memberVO = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .memail(rs.getString("memail"))
                .reg_date(LocalDate.parse(rs.getString("reg_date")))
                .build();

        return memberVO;
    }

    public List<MemberVO> listMembers() {
        String sql = "SELECT * FROM member";
        List<MemberVO> memberVOList = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                MemberVO memberVO = MemberVO.builder()
                        .mid(rs.getString("mid"))
                        .mpw(rs.getString("mpw"))
                        .mname(rs.getString("mname"))
                        .memail(rs.getString("memail"))
                        .reg_date(rs.getDate("reg_date").toLocalDate())
                        .build();
                memberVOList.add(memberVO);
            }
            return memberVOList;
        } catch (SQLException e) {
            log.info("MemberDAO : list sql fail");
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.info("MemberDAO : receiving list fail");
            throw new RuntimeException(e);
        }
    }

    public void addMember(MemberVO memberVO) {
        String sql = "INSERT INTO member (mid, mpw, mname, memail) VALUES (?,?,?,?)";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, memberVO.getMid());
            pstmt.setString(2, memberVO.getMpw());
            pstmt.setString(3, memberVO.getMname());
            pstmt.setString(4, memberVO.getMemail());
            pstmt.executeUpdate();
            log.info("MemberDAO : Insertion done");
        } catch (Exception e) {
            log.info("MemberDAO : Insertion Fail");
            e.printStackTrace();
        }
    }

    public void updateMember(MemberVO memberVo) {
        String sql = "UPDATE member SET " +
                "mpw = ?," +
                "mname = ?," +
                "memail = ?," +
                "reg_date = ?" +
                " WHERE mid = ?";
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, memberVo.getMpw());
            pstmt.setString(2, memberVo.getMname());
            pstmt.setString(3, memberVo.getMemail());
            pstmt.setDate(4, Date.valueOf(LocalDate.now())); // Convert LocalDate to SQL Date
            pstmt.setString(5, memberVo.getMid()); // Set mid for WHERE clause
            pstmt.executeUpdate();
            log.info("MemberDAO: Update done");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public MemberVO selectOne(String mid) {
        String sql = "SELECT * from member where mid = ?";

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {
            pstmt.setString(1, mid);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException();
            }
            MemberVO todoVO = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .memail(rs.getString("memail"))
                    .build();

            return todoVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOne(String mid, String mpw) {
        try {
            MemberVO vo = selectOne(mid);

            if (vo == null) {
                log.info("Member not found with id: " + mid);
                return; // Return without further processing
            }

            String storedPassword = vo.getMpw();

            // Check if the stored password is null or does not match the provided password
            if (storedPassword == null || !storedPassword.equals(mpw)) {
                log.info("Invalid Password");
                return; // Return without deleting
            }

            // If the stored password matches the provided password, proceed with deletion
            String sql = "DELETE FROM member WHERE mid = ?";
            try (
                    Connection conn = ConnectionUtil.INSTANCE.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
            ) {
                pstmt.setString(1, mid);
                int deletedRows = pstmt.executeUpdate();
                if (deletedRows > 0) {
                    log.info("User Deleted: " + mid);
                } else {
                    log.info("Failed to delete user: " + mid);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error deleting user: " + mid, e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user information: " + mid, e);
        }
    }


}
