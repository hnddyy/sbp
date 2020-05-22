package com.example.sbp.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude= {"userPassword"})
public class User {

	private String userId;
	
	private String userPassword;
	
	private String userName;
}
