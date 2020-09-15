package com.dhathri.demo.services;

import java.util.Collections;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dhathri.demo.Repo.UserRepository;

import com.dhathri.demo.model.User;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveMyTransaction(User user) {
		List<User> allUser=new UserService(userRepository).showAllTransactions();
		int len=allUser.size();
		int i=0;
		User newUser=null;
		if(len==0) {
			int bal=200000;
			user.balance=bal-user.transactionamount;
			userRepository.save(user);
		}
		else {
		for(User res:allUser)
		{
			if(i == len-1)
			{
				newUser=res;
				break;
			}
			i++;
		}	
		
		
		int bal=newUser.balance;
		System.out.println(bal);
		user.balance=bal-user.transactionamount;
		userRepository.save(user);
	}
	}
	public List<User> showAllTransactions(){ 
		 
		List<User> re=userRepository.findAll();
		  return re;		 
	 }

	public List<User> showTop5Transactions(){        
		 List<User> re=userRepository.findAll();
		 Collections.reverse(re);
		 int leng=re.size();
		 if(leng<=5) {
			 return re;
		 }
		 else {
		 List<User> arrlist2 = re.subList(0, 5);
		 return arrlist2;
	 }
	}
}