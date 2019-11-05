package com.javafpt.service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import javax.persistence.Column;

import org.omg.CORBA.NO_IMPLEMENT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafpt.dto.ActionDto;
import com.javafpt.entities.Member;
import com.javafpt.entities.MemberAction;
import com.javafpt.repository.MemberActionDAO;

@Service
public class MemberActionImp implements MemberActionService{
	@Autowired
	MemberActionDAO memberActionDAO;
	@Autowired
	MemberImp memberSerive;
	
	
	@Override
	public List<MemberAction> findAllAction(){
		return memberActionDAO.findAll();
	}
	@Override
	public void addAction(ActionDto actionDto) throws Exception {
		if (actionDto!= null) {
			MemberAction memberAction = new MemberAction();
			 Random r = new Random();
		    int ramdomId = r.nextInt(10000);
			memberAction.setIdAction(ramdomId);
			memberAction.setNameAction(actionDto.getNameAction());
			memberAction.setDescribes(actionDto.getDescribes());
			memberAction.setNumberMin(actionDto.getNumberMin());
			memberAction.setNumberMax(actionDto.getNumberMax());
			memberAction.setDatefinish(actionDto.getDatefinish());
			memberAction.setTimeDeadline(actionDto.getTimeDeadline());
			memberAction.setDateStart(actionDto.getDateStart());
			memberAction.setStatus(actionDto.getStatus());
			Member member = memberSerive.findOneMember(actionDto.getIdMember());
			if (member == null) {
				throw new Exception() ; 
			}else {
				memberAction.setMember(member);
				memberActionDAO.save(memberAction);
			}
			
		}

	}
	@Override
	public void delete(Integer  id) {
		memberActionDAO.deleteById(id);
	}
	@Override
	public MemberAction findOneAction(Integer id) {
		return memberActionDAO.findByIdAction(id);
	}

	@Override
	public void updateAction(ActionDto memberDTO) {
		// TODO Auto-generated method stub
		MemberAction member = memberActionDAO.findByIdAction(memberDTO.getIdAction());
		member.setReasonCancel(memberDTO.getReasonCancel());
		member.setDescribes(memberDTO.getDescribes());
		member.setDatefinish(memberDTO.getDatefinish());
		member.setDateStart(memberDTO.getDateStart());
		member.setNumberMin(memberDTO.getNumberMin());
		member.setNumberMax(memberDTO.getNumberMax());
		member.setNameAction(memberDTO.getNameAction());
		member.setTimeDeadline(memberDTO.getTimeDeadline());
		member.setStatus(memberDTO.getTimeDeadline());
		member.setReasonCancel(memberDTO.getReasonCancel());
		memberActionDAO.save(member);
	}
	
	@Override
	public List<MemberAction> findByIdActionMember(int idMember) {
		// TODO Auto-generated method stub
		return memberActionDAO.findByIdNameCreat(idMember);
	}
	
	
}
