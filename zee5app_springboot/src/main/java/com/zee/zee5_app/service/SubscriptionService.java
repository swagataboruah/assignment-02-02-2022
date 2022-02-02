package com.zee.zee5_app.service;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidAmountException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Subscription;

public interface SubscriptionService {

	public String addSubs(Subscription subscription) throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String updateSubs(String id, Subscription subscription) throws SQLException;
	public Optional<Subscription> getSubsById(String id) throws IdNotFoundException, SQLException;
	public Subscription[] getAllSubs();
	public String delSubsById(String id) throws IdNotFoundException, SQLException;
	Optional<List<Subscription>> getAllSubsDetails() throws InvalidNameException, InvalidIdLengthException, InvalidAmountException, SQLException;
	
}
