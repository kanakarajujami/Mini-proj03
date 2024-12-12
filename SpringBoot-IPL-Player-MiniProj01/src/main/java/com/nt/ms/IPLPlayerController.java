package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IiplTeamClient;
import com.nt.entity.IPLPlayerEntity;
import com.nt.entity.IPLTeamEntity;
import com.nt.service.IiPLPlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("player-api")
@Slf4j
public class IPLPlayerController {
   @Autowired	
    private IiPLPlayerService playerService;
   @Autowired
   private IiplTeamClient teamClient;
   @PostMapping("/save")
   public ResponseEntity<String> savePlayer(@RequestBody IPLPlayerEntity playerEnity){
	   log.info("IPLPlayerController..savePlayer()...begin");
	    Integer teamId=playerEnity.getTeam().getTeamId();
	    //call provider ms to get team object
	    IPLTeamEntity team=teamClient.getIPLTeamById(teamId);
	    log.info("IPLTeam.. getIPLTeamById().. invoked");
	    //set team object to player
	    playerEnity.setTeam(team);
	    String resultMsg=playerService.registerPlayer(playerEnity);
	    log.info("player regsitered");
	    return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
   }
   @GetMapping("/findAll")
   public ResponseEntity<List<IPLPlayerEntity>> getAllPlayers(){
	    List<IPLPlayerEntity> listPlayer=playerService.getAllPlayers();
	    log.info(" return All players ");
	    return new ResponseEntity<List<IPLPlayerEntity>>(listPlayer,HttpStatus.OK);
   }
   @GetMapping("/find/{playerId}")
   public ResponseEntity<IPLPlayerEntity> showPlayerById(@PathVariable Integer playerId){
	   IPLPlayerEntity playerEntity=playerService.showPlayerById(playerId);
	   log.info(" return  player ");
	   return new ResponseEntity<IPLPlayerEntity>(playerEntity,HttpStatus.OK);
   }
   
   

}
