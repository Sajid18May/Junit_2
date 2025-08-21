package com.junit_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.junit_2.entity.User;
import com.junit_2.repository.UserRepository;
import com.junit_2.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void test_User_Found() {
		
		when(userRepository.findById(1)).thenReturn(Optional.of(new User(1, "Alice")));
		
		 String name = userService.getUserName(1);
		 assertEquals("Alice", name);
		 
		 verify(userRepository, times(1)).findById(1);
	}
	
	@Test
	public void test_User_NotFound() {
		
		when(userRepository.findById(2)).thenReturn(Optional.empty());
		
		String name= userService.getUserName(2);
		assertEquals("Unknown User",name);
		
		verify(userRepository,times(1)).findById(2);
	}
}
