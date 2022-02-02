package com.zee.zee5_app.service;

import java.sql.SQLException;
import java.util.List;

import java.util.Optional;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Series;
public interface SeriesService {

	public String add(Series series) throws SQLException;
	public String update(String id, Series series);
	public Optional<Series> getById(String id) throws IdNotFoundException, SQLException;
	public Series[] getAll();
	public Optional<List<Series>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String deleteById(String id) throws IdNotFoundException;
	
}
