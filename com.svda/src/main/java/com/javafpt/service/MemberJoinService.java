package com.javafpt.service;

import java.util.List;

import com.javafpt.dto.MemberJoinDto;
import com.javafpt.entities.MemberJoin;

public interface MemberJoinService {
	public List<MemberJoin> findAllMemberJoin();
	
	public boolean checkMemberJoinMaster(int idMember,int idAction);
	
	
	public void saveMemberJoin(MemberJoinDto memberJoinDto);
	
	public boolean checkMemberJoin(int idMember,int idAction);
	
	public boolean checkMaxMemberJoin(int idAction) ;
	
	public void reviewMemberJoin(MemberJoinDto memberJoinDto);

}
