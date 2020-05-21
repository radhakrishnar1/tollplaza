package com.example.userdomain;

import java.util.Date;

import lombok.Data;

@Data
public class UserDomain {
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private Date dob;
	private String gender;
}
