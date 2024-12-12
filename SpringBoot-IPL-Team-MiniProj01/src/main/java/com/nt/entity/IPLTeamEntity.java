package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="IPL_TEAM")
public class IPLTeamEntity {
  @Id
  @SequenceGenerator(name="team_seq",sequenceName = "iplteam_seq",initialValue = 10000,allocationSize = 1)
  @GeneratedValue(generator="team_seq",strategy=GenerationType.SEQUENCE)
  private Integer teamId;
  @Column(length = 30)
  private String teamName;
  @Column(length = 30)
  private String owner;
  @Column(length = 30)
  private String area;
  
}
