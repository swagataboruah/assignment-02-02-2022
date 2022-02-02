package com.zee.zee5_app.service;

import java.sql.SQLException;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;

public interface LoginService {

	public String addCredentials(Login login);

	public String deleteCredentials(String userName) throws SQLException, IdNotFoundException;

	public String changePassword(String userName,String password);

	public String changeRole(String userName, ROLE role) throws SQLException;

}

