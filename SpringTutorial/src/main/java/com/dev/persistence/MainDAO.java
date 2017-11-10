package com.dev.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dev.domain.CosmosVO;

@Repository
public class MainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.dev.mapper.mainMapper";
	
	public List<CosmosVO> getCosmos(int id) {
		return session.selectList(namespace + ".getCosmos", id);
	}
}
