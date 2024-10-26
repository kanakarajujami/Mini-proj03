package com.nt.entity;

import java.time.LocalDate;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="USER_DETAILS")
public class UserMaster {
 @Id	
@SequenceGenerator(name="gen1",sequenceName = "user_id_seq",initialValue = 10000,allocationSize = 1)	
@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
 private Integer userId;
@Column(length = 30)
 private String name;
@Column(length = 30)
 private String password;
@Column(length = 30)
 private String mail;
 private LocalDate dob;
 private Long contactNo;
 @Column(length = 30)
 private String gender;
 @Column(length = 30)
 private String activeSW;
 @CreationTimestamp()
 @Column(insertable = true,updatable = false)
 private LocalDateTime creationTime;
 @UpdateTimestamp
 @Column(insertable = false,updatable=true)
 private LocalDateTime updationTime;
 @Column(length = 30)
 private String updatedBy;
 @Column(length = 30)
 private String createdBy;
}
