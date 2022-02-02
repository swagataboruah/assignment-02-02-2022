//user service interface

package com.zee.zee5_app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidEmailException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.Exception.InvalidPasswordException;
import com.zee.zee5_app.dto.Register;


public interface UserService {

	public String addUser(Register register) throws SQLException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException, InvalidEmailException, InvalidPasswordException, InvalidIdLengthException;
	public Register[] getAllUsers() throws InvalidEmailException, InvalidNameException, InvalidPasswordException, InvalidIdLengthException, SQLException;
	public String deleteUserById(String id) throws IdNotFoundException, SQLException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidNameException, InvalidPasswordException, InvalidIdLengthException, IdNotFoundException, SQLException;
	public String updateUser(String id, Register register);
	
}