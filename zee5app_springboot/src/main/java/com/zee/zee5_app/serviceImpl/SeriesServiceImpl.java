package com.zee.zee5_app.serviceImpl;

import java.sql.SQLException;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.repository.SeriesRepository;
import com.zee.zee5_app.service.SeriesService;
@Service

public class SeriesServiceImpl implements SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	
	//add 
	@Override
	public String add(Series series) throws SQLException {
		Series series2 = seriesRepository.save(series);
		if(series2!=null) {
			return "success";
		} else {
			return "fail";
		}
	}

	
	//update
	@Override
	public String update(String id, Series series2) {
		return null;
	}

	//get all 
	@Override
	public Series[] getAll() {
		List<Series> list = seriesRepository.findAll();
		Series[] array = new Series[list.size()];
		return list.toArray(array);
	}

	
	//get by id
	@Override
	public Optional<Series> getById(String id) throws IdNotFoundException, SQLException {
		return seriesRepository.findById(id);
	}

	
	//get all details
	@Override
	public Optional<List<Series>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException {
		return Optional.ofNullable(seriesRepository.findAll());
	}


	//delete by id
	@Override
	public String deleteById(String id) throws IdNotFoundException {
		try {
			Optional<Series> optional = this.getById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				seriesRepository.deleteById(id);
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		} 	
	}


}
	
