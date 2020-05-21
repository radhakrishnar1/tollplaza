package com.example.userentity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="USER_MASTER")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer uId;
	
	@Column(name="USER_FNAME")
	private String firstName;
	
	@Column(name="USER_LNAME")
	private String lastName;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_PHN")
	private Long phoneNumber;
	
	@Column(name="USER_DOB")
	private Long dob;
	
	@Column(name="USER_GENDER")
	private String gender;
	
	@Column(name="USER_PWD")
	private String uPwd;
	
	@Column(name="USER_ROLE")
	private String uRole;
	
	@Column(name="LOCK_STATUS")
	private String 	lockStatus;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
}
	