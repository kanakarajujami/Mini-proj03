package com.nt.ms;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {
	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage(){
		   return new ResponseEntity<String>("GoodMorning::kanakaraju",HttpStatus.OK);
	}

}
