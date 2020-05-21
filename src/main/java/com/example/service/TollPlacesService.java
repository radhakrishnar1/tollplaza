package com.example.service;

import java.util.List;

import com.example.userdomain.ForgotPwd;
import com.example.userdomain.Login;
import com.example.userdomain.UnlockAccountDomain;
import com.example.userdomain.UserDomain;
import com.example.userentity.UserEntity;

public interface TollPlacesService {
 public  UserEntity saveUserDetails(UserDomain userDomain);
 public boolean UnlockAccount(UnlockAccountDomain unlockAccountDomain);
	public UserEntity findLoginDetails(Login login);
	public UserEntity findPwdByEmail(ForgotPwd fgtPwd);
	public UserEntity saveAdminData(UserDomain userDomain) ;
	public UserEntity saveAgentData(UserDomain userDomain);
	public List<UserEntity> getAllAgentsDetails();
	public List<UserEntity> getAllAdminsDetails();
}




