package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLPlayerEntity;
import com.nt.repository.IiPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IPLPlayerServiceImpl implements IiPLPlayerService {
 @Autowired	
  private IiPLPlayerRepository playerRepo;
	@Override
	public String registerPlayer(IPLPlayerEntity entity) {
		    log.info("IPlayerServiceImpl class..registerPlayer()...begin");
		    Integer playerId=playerRepo.save(entity).getPlayerId()  ; 
		    log.info("IPlayerService class...registger executed and id returned");
	     	return "player registered with id value:"+playerId;
	}

	@Override
	public List<IPLPlayerEntity> getAllPlayers() {
	    log.info("IPlayerServiceImpl class..getAllPlayers()...begin");
		return playerRepo.findAll();
	}

	@Override
	public IPLPlayerEntity showPlayerById(Integer playerId) {
	    log.info("IPlayerServiceImpl class..showPlayerById()...begin");
		 Optional<IPLPlayerEntity> opt=playerRepo.findById(playerId);
		 if(opt.isPresent()) {
			 log.info("IPlayerServiceImpl class..showPlayerById()..executed and return playerinfo");
			  return  opt.get();
		 }
		 log.info("IPlayerServiceImpl class..showPlayerById()..executed and player id not found");
				throw new IllegalArgumentException("player id not found");
	}

}
