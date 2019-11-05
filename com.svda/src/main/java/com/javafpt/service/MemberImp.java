package com.javafpt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafpt.entities.Member;
import com.javafpt.repository.MemberDAO;

@Service
public class MemberImp implements MemberService{
	@Autowired
	MemberDAO member;
	
	// add new member
	@Override
	public void addMember(Member memberEntities) {
		member.save(memberEntities);
	}
	
	// xoa thanh vien
	@Override
	public void deleteById(Integer id) {
		member.deleteById(id);
	}
	
	// liet ke cac thanh vien
	@Override
	public List<Member> getMembers(){
		return member.findAll();
	}
	
	// tim 1 thanh vien
	@Override
	public Member findOneMember(Integer id) {
		return member.findByIdMember(id);
	}
}
