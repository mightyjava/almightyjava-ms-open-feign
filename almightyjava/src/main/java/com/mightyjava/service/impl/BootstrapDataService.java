package com.mightyjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mightyjava.model.Role;
import com.mightyjava.model.User;
import com.mightyjava.repository.RoleRepository;
import com.mightyjava.repository.UserRepository;

@Service
public class BootstrapDataService implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		insertRoles();
		insertUser();
	}

	private void insertRoles() {
		if(roleRepository.findAll().size() == 0) {
			List<Role> roles = new ArrayList<Role>();
			Role roleAdmin = new Role();
			roleAdmin.setName("admin");
			roles.add(roleAdmin);
			
			Role roleUser = new Role();
			roleUser.setName("user");
			roles.add(roleUser);
			
			roleRepository.saveAll(roles);
		}
	}
	
	@Value("${spring.profiles.active}")
	private String profile;
	
	private void insertUser() {
		if(userRepository.userList().size() == 0) {
			User user = new User();
			if(profile.equalsIgnoreCase("dev")) {
				user.setEmail("mightyjava@gmail.com");
				user.setFullName("Mighty Java");
				user.setUserId("MJ001");
				user.setUserName("mightyjava");
			} else {
				user.setEmail("almightyjava@gmail.com");
				user.setFullName("Almighty Java");
				user.setUserId("AMJ001");
				user.setUserName("almightyjava");
			}
			user.setMobile("9876543210");
			user.setPassword(new BCryptPasswordEncoder().encode("password"));
			user.setRole(roleRepository.findById(1L).get());
			
			userRepository.save(user);
		}
	}
}