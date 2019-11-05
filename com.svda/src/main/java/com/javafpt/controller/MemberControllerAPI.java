package com.javafpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafpt.dto.ActionDto;
import com.javafpt.entities.Member;
import com.javafpt.entities.MemberAction;
import com.javafpt.service.MemberActionImp;
import com.javafpt.service.MemberImp;
import com.javafpt.service.MemberJoinImp;

@RestController
@Controller
@RequestMapping("/api")
public class MemberControllerAPI {
	@Autowired
	MemberImp memberService;
	@Autowired
	MemberActionImp memberAction;
	@Autowired
	MemberJoinImp memberJoin;
	
	
	@RequestMapping(value = "/members",method = RequestMethod.GET)
	public List<Member> members(ModelMap modelMap){
		modelMap.addAttribute("listMembers", memberService.getMembers());
		return memberService.getMembers();
	}
	
	@RequestMapping(value = "/members/{id}",method = RequestMethod.GET)
	public Member getMember(@PathVariable ("id") int id ) {
		try {
			return memberService.findOneMember(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
}
