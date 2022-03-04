package com.example.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.security.models.User;
import com.example.security.models.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepository repo;
	
	
	@Autowired
	UserRepository userRepository;
//	
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
//		User user=repo.findByUsername(username);
//		
//		if(user==null)
//			throw new UsernameNotFoundException("User 404");
		
		
		
		Optional<User> user=userRepository.findByUsername(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found : "+userName));
		
	

		return user.map(UserPrincipal::new).get();
		
	}

}
