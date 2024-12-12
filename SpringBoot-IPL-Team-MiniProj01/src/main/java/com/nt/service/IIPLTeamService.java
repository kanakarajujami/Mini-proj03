package com.nt.service;

import java.util.List;

import com.nt.entity.IPLTeamEntity;

public interface IIPLTeamService {
   public String registerIPLTeam(IPLTeamEntity entity);
   public List<IPLTeamEntity> getAlliPLTeams();
   public IPLTeamEntity showTeamById(Integer teamId);
}
