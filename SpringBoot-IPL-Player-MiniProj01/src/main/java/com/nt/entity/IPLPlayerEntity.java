package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="IPL_PLAYER")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IPLPlayerEntity {
 @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer playerId;
 private String playerName;
 private Integer age;
 private String role;
 @ManyToOne(targetEntity = IPLTeamEntity.class,cascade = CascadeType.MERGE)
 @JoinColumn(name = "team_id",referencedColumnName = "teamId")
 private IPLTeamEntity team;
@Override
public String toString() {
	return "IPLPlayerEntity [playerId=" + playerId + ", playeName=" + playerName + ", age=" + age + ", role=" + role
			+ ", team=" + team + "]";
}

 
}
