package com.javafpt.service;

import java.util.List;

import com.javafpt.dto.ActionDto;
import com.javafpt.entities.MemberAction;

public interface MemberActionService {
	public List<MemberAction> findAllAction();
	
	public void addAction(ActionDto actionDto) throws Exception;
	
	public void delete(Integer  id);
	
	public MemberAction findOneAction(Integer id);
	
	public void updateAction(ActionDto memberDTO) ;
	
	List<MemberAction> findByIdActionMember(int idMember);
}
