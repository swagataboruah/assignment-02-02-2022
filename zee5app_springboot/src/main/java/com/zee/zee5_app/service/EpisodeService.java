package com.zee.zee5_app.service;
import java.sql.SQLException;
import java.util.List;

import java.util.Optional;

import com.zee.zee5_app.Exception.IdNotFoundException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.dto.Episode;

public interface EpisodeService {

	public String addEpi(Episode episode) throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String updateEpi(String id, Episode episode) throws SQLException;
	public Optional<Episode> getById(String id) throws IdNotFoundException;
	public Episode[] getAll();
	public Optional<List<Episode>> getAllDetails() throws InvalidIdLengthException, InvalidNameException, SQLException;
	public String delEpi(String id) throws IdNotFoundException;
}
