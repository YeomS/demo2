package com.example.demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo2.dto.MemberDTO;
import com.example.demo2.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	//회원목록
	public List<MemberDTO> findMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberList();
	}

	@Override
	//회원상세정보
	public MemberDTO findMemberDetail(String id) {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberDetail(id);
	}

	@Override
	//회원가입
	public void registerMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		 memberMapper.insertMember(memberDTO);
	}

	@Override
	//회원삭제
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		 memberMapper.deleteMember(id);
	}
}