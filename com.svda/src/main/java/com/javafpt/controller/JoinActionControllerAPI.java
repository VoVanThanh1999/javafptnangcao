package com.javafpt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafpt.dto.MemberJoinDto;
import com.javafpt.service.MemberJoinImp;


@Controller
@RestController
@RequestMapping("/api")
public class JoinActionControllerAPI {
	@Autowired
	MemberJoinImp memberJoinService;
	
	@RequestMapping(value = "/actions/join",method = RequestMethod.POST)
	public String addMemberJoinAction(@RequestBody String dataJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			MemberJoinDto  memberJoin = mapper.readValue(dataJson, MemberJoinDto.class);
			memberJoinService.saveMemberJoin(memberJoin);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
	@RequestMapping(value = "/actions/reviews",method = RequestMethod.POST)
	public String reviewActionJoin(@RequestBody String dataJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			MemberJoinDto  memberJoin = mapper.readValue(dataJson, MemberJoinDto.class);
			memberJoinService.reviewMemberJoin(memberJoin);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	
	
}	
