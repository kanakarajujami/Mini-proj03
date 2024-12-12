package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.IPLTeamEntity;

@FeignClient("IPLTEAM-SERVICE")
public interface IiplTeamClient {
	@GetMapping("/team-api/find/{teamId}")
	public IPLTeamEntity getIPLTeamById(@PathVariable Integer teamId);

}
