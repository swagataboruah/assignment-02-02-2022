package com.zee.zee5_app.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Movie;

public interface MovieService {

	public String add(Movie movie) throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String update(String id, Movie movie) throws SQLException;
	public Optional<Movie> getById(String id) throws IdNotFoundException, InvalidIdLengthException, SQLException, InvalidNameException;
	public Movie[] getAll();
	public Optional<List<Movie>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String deleteById(String id) throws IdNotFoundException, SQLException;
}
