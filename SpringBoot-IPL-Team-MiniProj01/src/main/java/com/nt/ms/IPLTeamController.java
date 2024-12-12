package com.nt.ms;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.IPLTeamEntity;
import com.nt.service.IIPLTeamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("team-api")
@Slf4j
public class IPLTeamController {
	@Autowired
    private IIPLTeamService teamService;
	
	@PostMapping("/saveteam")
	public ResponseEntity<String> saveIPLTeam(@RequestBody IPLTeamEntity entity){
		  log.info("IPLTeamController..saveIPLTeam()..begin");
		  String msg=teamService.registerIPLTeam(entity);
		  log.info("registerIPLTeam() of service class invoked");
		  return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	 @GetMapping("/findAll")
   public ResponseEntity<List<IPLTeamEntity>>	findALLIPLTeams(){
		  log.info("IPLTeamController..findAllIPLTeams()..begin");
	      List<IPLTeamEntity> listTeams=teamService.getAlliPLTeams();
		  log.info("getAllIPLTeam() of service class invoked");
	      return new ResponseEntity<List<IPLTeamEntity>>(listTeams,HttpStatus.OK);
   }	  
	 @GetMapping("/find/{teamId}")
	public ResponseEntity<IPLTeamEntity> getIPLTeamById(@PathVariable Integer teamId){
		 log.info("IPLTeamController..getIPLTeams()..begin");
	   IPLTeamEntity iPLTeam=teamService.showTeamById(teamId);
	   log.info("showTeamById() of service class invoked");
	   return new ResponseEntity<IPLTeamEntity>(iPLTeam,HttpStatus.OK);
}
}