package com.database.project.eventManagmentSystem.service;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.project.eventManagmentSystem.dao.MusicDAO;
import com.database.project.eventManagmentSystem.event.Music;

@Service("musicService")
public class MusicService {
	private MusicDAO musicDAO;

	/**
	 * @param musicDAO the musicDAO to set
	 */
	@Autowired
	public void setMusicDAO(MusicDAO musicDAO) {
		this.musicDAO = musicDAO;
	}

	public void createService(Music music) throws SQLException{
		musicDAO.create(music);
		
	}
}
	