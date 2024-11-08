package com.pretzero.fitsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pretzero.fitsure.model.dto.User;
import com.pretzero.fitsure.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
		User login = userService.login(user.getUserLoginId(), user.getPassword());
		if (login != null) {
			session.setAttribute("user", login);
			return new ResponseEntity<>("Login successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestBody User user, HttpSession session) {

		if (session.getAttribute("user") != null) {
			session.invalidate();
			return new ResponseEntity<>("Logout successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {

		int result = userService.signup(user);
		if (result == 1) {
			return new ResponseEntity<>("signup successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/withdraw")
	public ResponseEntity<String> withdraw(@RequestParam String userLoginId, HttpSession session) {
		boolean result = userService.deleteUser(userLoginId);
		
		boolean isVerified = (boolean) session.getAttribute("verifiedPerson");
		
		if (!isVerified) {
	        return new ResponseEntity<>("비밀번호 확인이 필요합니다.", HttpStatus.FORBIDDEN);
	    }
		
		if (result) {
			return new ResponseEntity<>("회원 탈퇴가 완료되었습니다.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("회원 탈퇴에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/passwordChecktime")
	public ResponseEntity<String> passwordCheck(@RequestParam("password") String password, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		boolean result = userService.checkPassword(user.getUserId(), password);
		
		if (result) {
			session.setAttribute("verifiedPerson", true);
			return new ResponseEntity<>("본인 확인이 완료되었습니다.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("본인 확인에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
