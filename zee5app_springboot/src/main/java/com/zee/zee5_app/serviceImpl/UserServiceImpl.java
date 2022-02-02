package com.zee.zee5_app.serviceImpl;
import java.sql.SQLException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidEmailException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.Exception.InvalidPasswordException;
import com.zee.zee5_app.repository.UserRepository;
import com.zee.zee5_app.service.UserService;

@Service // using this we get the singleton object
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;	
	
	
	//add
	@Override
	public String addUser(Register register) throws SQLException {
		Register register2 = userRepository.save(register);
		if(register2!=null) {			
			return "success";
		} else {
			return "fail";
		}		
	}
	
	//update
	@Override
	public String updateUser(String id, Register register) {
		//done internally
		return null;
	}

	//get user by id
	@Override
	public Optional<Register> getUserById(String id) throws InvalidEmailException, InvalidNameException, InvalidPasswordException, InvalidIdLengthException {
		return userRepository.findById(id);
	}
	
	
	//get all users
	@Override
	public Register[] getAllUsers() throws InvalidEmailException, InvalidNameException, InvalidPasswordException, InvalidIdLengthException, SQLException {
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	
	//delete user by id
	@Override
	public String deleteUserById(String id) throws SQLException, IdNotFoundException {
		//cross check with findbyid to check if record exists
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userRepository.deleteById(id);
				return "success";
			}
		} catch ( IdNotFoundException | InvalidEmailException | InvalidNameException | InvalidPasswordException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		} 		
	}

	
	//get all users details
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidNameException, InvalidPasswordException, InvalidIdLengthException, IdNotFoundException, SQLException {
		return Optional.ofNullable(userRepository.findAll());
	}

	

}