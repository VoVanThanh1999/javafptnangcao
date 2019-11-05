package com.javafpt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafpt.dto.ActionDto;
import com.javafpt.entities.MemberAction;
import com.javafpt.service.MemberActionImp;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@Controller
@RequestMapping("/api")
public class ActionControllerAPI {
	@Autowired
	MemberActionImp action;
	
	@RequestMapping(value = "/actions",method = RequestMethod.GET)
	public List<MemberAction> showActions(){

		return action.findAllAction();
	}
	
	@RequestMapping(value="/actions",method = RequestMethod.POST)
	public String addAction(@RequestBody String dataJson)  {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ActionDto actionDto = objectMapper.readValue(dataJson, ActionDto.class);
			action.addAction(actionDto);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
			
		}
		return null;
	}
	
	@RequestMapping(value = "/actions",method = RequestMethod.PATCH)
	public String updateAction(@RequestBody String  dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ActionDto actionDto = objectMapper.readValue(dataJson, ActionDto.class);
			action.updateAction(actionDto);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
		}
		return null;
	}
	
	@RequestMapping(value = "/actions",method = RequestMethod.DELETE)
	public void deleteAction(@RequestParam("id") int id) {
		  try {
			  action.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/actions/{id}")
	public MemberAction findOneActions(@PathVariable ("id") int id) {
		try {
			return action.findOneAction(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/actions/members/{idMember}")
	public List<MemberAction> getActionByIdMember(@PathVariable("idMember") int idMember){
		try {
			return action.findByIdActionMember(idMember);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
