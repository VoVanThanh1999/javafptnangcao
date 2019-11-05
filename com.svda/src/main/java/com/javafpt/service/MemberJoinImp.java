package com.javafpt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafpt.dto.MemberJoinDto;
import com.javafpt.entities.MemberAction;
import com.javafpt.entities.MemberJoin;
import com.javafpt.repository.MemberJoinDAO;

@Service
public class MemberJoinImp implements MemberJoinService{
	@Autowired
	MemberJoinDAO memberJoin;
	
	@Autowired
	MemberActionImp memberAction;

	@Override
	public List<MemberJoin> findAllMemberJoin(){
		return memberJoin.findAll();
	}
	
	@Override
	public void saveMemberJoin(MemberJoinDto memberJoinDto) {
		if (checkMemberJoinMaster(memberJoinDto.getMember().getIdMember(),memberJoinDto.getMemberAction().getIdAction())
				&& checkMemberJoin(memberJoinDto.getMember().getIdMember(),memberJoinDto.getMemberAction().getIdAction())
				&&checkMaxMemberJoin(memberJoinDto.getMemberAction().getIdAction())) {
			
			MemberJoin member = new MemberJoin();
			member.setMember(memberJoinDto.getMember());
			member.setMemberAction(memberJoinDto.getMemberAction());
			memberJoin.save(member);
		}else {
			System.out.println("them that bai");
			new Exception();
		}
	}
 
	@Override
	public boolean checkMemberJoinMaster(int idMember, int idAction) {
		// TODO Auto-generated method stub
		if (memberAction.findOneAction(idAction).getMember().getIdMember() != idMember
				&& memberAction.findOneAction(idAction)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkMemberJoin(int idMember, int idAction) {
		// TODO Auto-generated method stub
		List<MemberJoin> memberJoins = findAllMemberJoin();
		for (MemberJoin memberJoin : memberJoins) {
			if (memberJoin.getMember().getIdMember() == idMember &&
					memberJoin.getMemberAction().getIdAction() == idAction) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean checkMaxMemberJoin(int idAction) {
		// TODO Auto-generated method stub
		MemberAction member =  memberAction.findOneAction(idAction);
		if (memberJoin.countByIdActionInMemberJoin(idAction) < Integer.parseInt(member.getNumberMax())) {
			return true;
		}
		return false;
	}
	
	@Override
	public void reviewMemberJoin(MemberJoinDto memberJoinDto) {
		MemberJoin member = memberJoin.findById(memberJoinDto.getId());
		if (member!=null) {
			if (member.getMember().getIdMember() == memberJoinDto.getMember().getIdMember()
					&&	member.getMemberAction().getIdAction()
							== memberJoinDto.getMemberAction().getIdAction()) {
				member.setPoint1(memberJoinDto.getPoint1());
				member.setPoint2(memberJoinDto.getPoint2());
				member.setPoint3(memberJoinDto.getPoint3());
				float point4 = Float.parseFloat((memberJoinDto.getPoint1()+memberJoinDto.getPoint2()+memberJoinDto.getPoint3()))/3;
				member.setPoint4(String.valueOf(point4));
				member.setRegistrationDate(memberJoinDto.getRegistrationDate());
				member.setComment(memberJoinDto.getComment());
				memberJoin.save(member);
			}else {
				new Exception();
			}
		}else {
			new Exception();
		}
	}


}
