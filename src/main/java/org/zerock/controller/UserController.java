package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;

@Controller
@AllArgsConstructor
@RequestMapping(value="apis")
public class UserController {
	
	public UserService service;
	
	@GetMapping("users")
	public void userList(Model model) {
		System.out.println(service.list());
		
		model.addAttribute("userList", service.list());
		model.addAttribute("ulist", JSONArray.fromObject(service.list()));
	}
	
	@PostMapping(value="users", consumes = "application/json")
	@ResponseBody
	public List<UserVO> userPost(){
		return service.list();
	}
//	@GetMapping("/display")
	
//	public ResponseEntity<byte[]> getFile(String fileName) {
//
//		log.info("fileName: " + fileName);
//							//��ξȿ��ִ� ������ �̹��������̸�
//		File file = new File("C:\\upload\\" + fileName);
//							//C:\\upload\\+��ξȿ��ִ� ������ �̹��������̸�
//		log.info("file: " + file);
//
//		ResponseEntity<byte[]> result = null;//???
//
//		try {
//			HttpHeaders header = new HttpHeaders();
//			//HttpHeaders�� Ŭ���̾�Ʈ�� ������ ��û �Ǵ� �������� �ΰ����� ������ ������ �� �� �ְ� �Ѵ�.
//			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			//�����. �߰�		����Ÿ��                     	���������� ���� �޼ҵ�                   = file�� ������ �����´�.
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//											//������ ������ ���������ο� byte[]�� ������
//			//									 body�κ� ���� ����                                  ������� ���� , ����		           
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}

}
