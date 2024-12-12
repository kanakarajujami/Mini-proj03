package com.nt.service;

import java.util.List;

import com.nt.entity.IPLPlayerEntity;

public interface IiPLPlayerService {
   public String registerPlayer(IPLPlayerEntity entity);
   public List<IPLPlayerEntity> getAllPlayers();
   public IPLPlayerEntity showPlayerById(Integer playerId);
}
