package org.team.g2.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class LoginController {
	@GetMapping("/customLogin")
	public void  loginCustom() {
		log.warn("customlogin get.................");
	}
}
