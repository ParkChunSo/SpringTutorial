package com.dev.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dev.domain.CosmosVO;
import com.dev.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService{

	@Inject
	private MainDAO mainDAO;
	
	@Override
	public List<CosmosVO> getCosmos(int id) throws Exception {
		return mainDAO.getCosmos(id);
	}

}
