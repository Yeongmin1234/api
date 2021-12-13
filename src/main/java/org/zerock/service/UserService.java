package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.UserVO;

import lombok.Data;

public interface UserService {
	public List<UserVO> list();
}
