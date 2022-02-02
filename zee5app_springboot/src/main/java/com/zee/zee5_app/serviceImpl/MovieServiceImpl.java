package com.zee.zee5_app.serviceImpl;

import java.sql.SQLException;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.repository.MovieRepository;
import com.zee.zee5_app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	//add
	@Override
	public String add(Movie movie) throws InvalidIdLengthException, InvalidNameException, SQLException {
		Movie movie2 = movieRepository.save(movie);
		if (movie2 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	//update
	@Override
	public String update(String id, Movie movie) throws SQLException {
		return null;
	}

	//get all 
	@Override
	public Movie[] getAll() {
		List<Movie> list = movieRepository.findAll();
		Movie[] array = new Movie[list.size()];
		return list.toArray(array);
	}

	//get by id
	@Override
	public Optional<Movie> getById(String id)
			throws IdNotFoundException, InvalidIdLengthException, SQLException, InvalidNameException {
		return movieRepository.findById(id);
	}

	//get all details
	@Override
	public Optional<List<Movie>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException {
		return Optional.ofNullable(movieRepository.findAll());
	}
	
	//delete by id
	@Override
	public String deleteById(String id) throws IdNotFoundException, SQLException {
		try {
			Optional<Movie> optional = this.getById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				movieRepository.deleteById(id);
				return "success";
			}
		} catch ( IdNotFoundException | InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		} 		
	}

}
