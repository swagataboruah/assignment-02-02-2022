package com.zee.zee5_app.serviceImpl;

import java.sql.SQLException;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.repository.EpisodeRepository;
import com.zee.zee5_app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	private EpisodeRepository episodeRepository;

	//add
	@Override
	public String addEpi(Episode episode) throws InvalidIdLengthException, InvalidNameException, SQLException {
		Episode episode2 = episodeRepository.save(episode);
		if (episode2 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	//update
	@Override
	public String updateEpi(String id, Episode episode) throws SQLException {
		return null;
	}

	//get all
	@Override
	public Episode[] getAll() {
		List<Episode> list = episodeRepository.findAll();
		Episode[] array = new Episode[list.size()];
		return list.toArray(array);
	}

	//delete by id 
	@Override
	public String delEpi(String id) throws IdNotFoundException {
		try {
			Optional<Episode> optional = this.getById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				episodeRepository.deleteById(id);
				return "success";
			}
		} catch ( IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		} 	
	}

	//get by id
	@Override
	public Optional<Episode> getById(String id) throws IdNotFoundException {
		return episodeRepository.findById(id);
	}

	@Override
	public Optional<List<Episode>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException {
		return Optional.ofNullable(episodeRepository.findAll());
	}

}
