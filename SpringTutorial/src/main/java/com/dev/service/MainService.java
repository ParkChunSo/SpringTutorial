package com.dev.service;

import java.util.List;

import com.dev.domain.CosmosVO;

public interface MainService {

	public List<CosmosVO> getCosmos(int id) throws Exception;
	
}
