package com.javafpt.service;

import java.util.List;

import com.javafpt.entities.Member;

public interface MemberService {
	public void addMember(Member memberEntities);

	public void deleteById(Integer id);

	public List<Member> getMembers();

	public Member findOneMember(Integer id) ;
	
}
