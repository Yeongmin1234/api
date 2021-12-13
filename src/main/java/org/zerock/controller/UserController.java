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
//							//경로안에있는 섬네일 이미지파일이름
//		File file = new File("C:\\upload\\" + fileName);
//							//C:\\upload\\+경로안에있는 섬네일 이미지파일이름
//		log.info("file: " + file);
//
//		ResponseEntity<byte[]> result = null;//???
//
//		try {
//			HttpHeaders header = new HttpHeaders();
//			//HttpHeaders는 클라이언트와 서버가 요청 또는 응답으로 부가적인 정보를 전송을 할 수 있게 한다.
//			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			//헤더에. 추가		받은타입                     	파일형식을 보는 메소드                   = file의 형식을 가져온다.
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//											//지정한 파일의 정보를새로운 byte[]로 저장함
//			//									 body부분 값을 전송                                  헤더값을 전송 , 상태		           
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}

}
