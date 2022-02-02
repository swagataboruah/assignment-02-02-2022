package com.zee.zee5_app.serviceImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidAmountException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.repository.SubscriptionRepository;
import com.zee.zee5_app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;	
	
	
	//add
	@Override
	public String addSubs(Subscription subscription) throws InvalidIdLengthException, InvalidNameException, SQLException{
		Subscription subscription2 = subscriptionRepository.save(subscription);
		if(subscription2!=null) {
			return "success";
		} else {
			return "fail";
		}
	}

	
	//update subs
	@Override
	public String updateSubs(String id, Subscription subscription) throws SQLException { 
		return null;
	}

	
	//get subs by id
	@Override
	public Optional<Subscription> getSubsById(String id) throws IdNotFoundException, SQLException {
		return subscriptionRepository.findById(id);
	}

	
	//get all subs
	@Override
	public Subscription[] getAllSubs() {
		List<Subscription> list = subscriptionRepository.findAll();
		Subscription[] array = new Subscription[list.size()];
		return list.toArray(array);
	}

	
	@Override
	public String delSubsById(String id) throws IdNotFoundException {
		try {
			Optional<Subscription> optional = this.getSubsById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				subscriptionRepository.deleteById(id);
				return "success";
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		} 			
	}
	
	
	//get all sub details
	@Override
	public Optional<List<Subscription>> getAllSubsDetails() throws InvalidNameException, InvalidIdLengthException, InvalidAmountException, SQLException {
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

}
