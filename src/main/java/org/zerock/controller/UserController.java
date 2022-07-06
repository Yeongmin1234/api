package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping(value="apis")
//@CrossOrigin(value="http://localhost:8090")
public class UserController {
	
	@Autowired
	public UserService service;
	
//	@GetMapping(value="users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public List<UserVO> userPost(){
//		return service.list();
//	}
	
}
