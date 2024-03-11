package com.example.webmvc_member.service;

import com.example.webmvc_member.dao.ConnectionUtil;
import com.example.webmvc_member.dao.MemberDAO;
import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private ModelMapper modelMapper;
    private MemberDAO memberDAO;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }


    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public MemberDTO get(String mid) throws Exception {
        return modelMapper.map(memberDAO.selectOne(mid), MemberDTO.class);
    }

    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> volist = memberDAO.listMembers();
        List<MemberDTO> memberDTOList = volist.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        if(memberDTOList.size() == 0) {
            log.info("MemberService: List not foiund");
        }
        return memberDTOList;
    }

    public void registerMember(MemberDTO memberDTO) throws Exception {
        MemberVO vo = modelMapper.map(memberDTO, MemberVO.class);
        log.info("Member Registration info: " + vo);
        memberDAO.addMember(vo);
    }

    public void updateOne(MemberDTO memberDTO) throws Exception {
        MemberVO vo = modelMapper.map(memberDTO, MemberVO.class);
        log.info("Member Modify info : " + vo);
        memberDAO.updateMember(vo);

    }

    public void deleteMember(String id, String pw) throws Exception {
        if (pw == null) {
            log.info("Password cannot be null");
            return;
        }
        log.info("Member Delete info: " + id);
        memberDAO.deleteOne(id, pw);
    }

}
