package com.green.biz.member;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface MemberService {
	MemberVO getMember(MemberVO vo);
	
	MemberVO loginMember(MemberVO vo);
	
	void insertMember(MemberVO vo);
	
	List<AddressVO> selectAddressByDong(AddressVO vo);
	
	MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	MemberVO findPassword(MemberVO vo);
	
	List<MemberVO> listMember(String name);
	
	public int passCheck(MemberVO vo);
	
	public void secession(MemberVO vo, HttpSession session);
}
