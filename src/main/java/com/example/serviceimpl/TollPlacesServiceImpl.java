package com.example.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.UserRepo;
import com.example.service.TollPlacesService;
import com.example.userdomain.ForgotPwd;
import com.example.userdomain.Login;
import com.example.userdomain.UnlockAccountDomain;
import com.example.userdomain.UserDomain;
import com.example.userentity.UserEntity;
import com.example.utils.EmailUtils;
@Service
public class TollPlacesServiceImpl implements TollPlacesService {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private TollPlacesServiceImpl tollPlacesServiceImpl;

	@Override
	public UserEntity saveUserDetails(UserDomain userDomain) {


		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userDomain, entity );
		String lock="LOCKED";
		entity.setLockStatus(lock);
		String role="user";
		entity.setURole(role);
		entity.setUPwd(generateRandomPwd(6));

		UserEntity userEntity = userRepo.save(entity);

		if (userEntity.getUId()>0) {
			tollPlacesServiceImpl.sendRegEmail(userEntity);

		}else {
			System.out.println("mail doesnt send");
		}

		return userEntity;
	}

	public void sendRegEmail(UserEntity u) {
		String body =null;
		String sub ="TollPlus Registration";
		try {
			body = getMailBody(u);
			System.out.println("generatedBody:"+ body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			emailUtils.sendEmail(u.getEmail() , sub, body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getMailBody(UserEntity u) throws Exception{
		StringBuilder body = new StringBuilder();
		String filename= "reg-email.txt";
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			if (line.contains("${firstName}")) {
				line= line.replace("${firstName}", u.getFirstName());
				System.out.println("line ::"+line);
			}
			if (line.contains("${lastName}")) {
				line= line.replace("${lastName}", u.getLastName());
			}

			if (line.contains("${uPwd}")) {
				line= line.replace("${uPwd}", u.getUPwd());
			}
			if (line.contains("${email}")) {
				line= line.replace("${email}", u.getEmail());
			}
			body.append(line);
			line = br.readLine();
		}
		br.close();
		return body.toString();
	}
	public static String generateRandomPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	@Override
	public boolean UnlockAccount(UnlockAccountDomain unlockAccountDomain) {
		UserEntity userEntity =userRepo.findByemailanduPwd(unlockAccountDomain.getEmail(), unlockAccountDomain.getTempPwd() );
	if(userEntity != null) {
		userEntity.setLockStatus("UNLOCKED");
		userEntity.setUPwd(unlockAccountDomain.getNewPwd());
		userEntity = userRepo.save(userEntity);
		return true;
	}
		return false;
	}

	public UserEntity findLoginDetails(Login login) {
		UserEntity entity = userRepo.findByemailanduPwd(login.getUserEmail(), login.getPassword());

		return entity;
	}

	public UserEntity findPwdByEmail(ForgotPwd fgtPwd) {
		UserEntity entity = userRepo.findByemail(fgtPwd.getUserEmail());
		return entity;
	}

	public UserEntity saveAdminData(UserDomain userDomain) {
	UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userDomain, entity);
		String lock = "LOCKED";
		entity.setLockStatus(lock);
		  String role = "Admin"; 
		  entity.setURole(role);
		entity.setUPwd(generateRandomPwd(6));
		UserEntity userEntity = userRepo.save(entity);
		if (userEntity != null) {
			// sendRegEmail(entity);
		}
		return userEntity;
	}

	public List<UserEntity> getAllAdminsDetails() {
		List<UserEntity> list = userRepo.findAllByRole("Admin");
		return list;
	}

	@Override
	public UserEntity saveAgentData(UserDomain userDomain) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userDomain, entity);
		String lock = "LOCKED";
		entity.setLockStatus(lock);
		  String role = "Agent";
		   entity.setURole(role);
		entity.setUPwd(generateRandomPwd(6));
		UserEntity userEntity = userRepo.save(entity);
		if (userEntity != null) {
		}
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllAgentsDetails() {
		List<UserEntity> list = userRepo.findAllByRole("Agent");
		return list;
	}
}

