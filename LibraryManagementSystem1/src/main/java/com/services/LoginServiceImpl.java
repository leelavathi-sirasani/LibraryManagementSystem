package com.services;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.entities.Login;
import com.repository.LoginRepository;
import com.repository.UsersRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository loginrepo;
	@Autowired
	UsersRepository usersrepo;
	@Override
	public Login addLoginDetails(Login login) {
		return loginrepo.save(login);
	}
    @Override
	public Login updateLoginDetails(Login login) throws Throwable {
		int loginid=login.getLoginId();
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login l=loginrepo.findById(loginid).orElseThrow(s1);
		l.setLoginId(l.getLoginId());
		l.setUserName(l.getUserName());
		l.setPassword(l.getPassword());
		loginrepo.save(login);
		return login;
	}

	@Override
	public String deleteLoginDetails(Login login) {
		loginrepo.delete(login);
		return "deleted";
	}

	@Override
	public List<Login> viewloginList() {
		List<Login> l=loginrepo.findAll();
		return l;
	}

	@Override
	public Login viewusersbyid(int loginid) throws Throwable {
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login l= loginrepo.findById(loginid).orElseThrow(s1);
		return l;
	}
    @Override
	public Login findByUserName(String userName) {
		Login u=loginrepo.findByUserName(userName);
		return u;
	}

}
