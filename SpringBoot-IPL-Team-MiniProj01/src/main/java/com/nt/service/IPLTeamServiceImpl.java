package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLTeamEntity;
import com.nt.repository.IiPLTeamRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IPLTeamServiceImpl implements IIPLTeamService {
	@Autowired
    private IiPLTeamRepository teamRepo;
	@Override
	public String registerIPLTeam(IPLTeamEntity entity) {
		   log.info("IPLTeamServiceImpl..regsiterIPLTeam()..begin");
	      Integer teamId=teamRepo.save(entity).getTeamId();  
	      log.info("IPLTeamServiceImpl..regsiterIPLTeam()..Team inserted and id generated");
		return "IPL Team register with id value:"+teamId;
	}

	@Override
	public List<IPLTeamEntity> getAlliPLTeams() {
		 log.info("IPLTeamServiceImpl..getAlliPLTeam()..begin");
		return teamRepo.findAll();
	}

	@Override
	public IPLTeamEntity showTeamById(Integer teamId) {
		 log.info("IPLTeamServiceImpl..shoTeamByTeamId()..begin");
	     Optional<IPLTeamEntity> opt =teamRepo.findById(teamId);
	     if(opt.isPresent()) {
	         log.info("IPLTeamServiceImpl...findById()...executed and return  IPLTeam");
	    	    return opt.get();
	     }
	     log.info("IPLTeamServiceImpl...findById()...executed and IPLTeam not found");
		throw new IllegalArgumentException("team id not found");
	}

}
