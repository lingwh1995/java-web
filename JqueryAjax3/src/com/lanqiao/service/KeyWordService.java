package com.lanqiao.service;

import java.sql.SQLException;
import java.util.List;

import com.lanqiao.dao.KeyWordDao;

public class KeyWordService {

	/**
	 * 通过关键词查询
	 * @param keyword
	 * @return
	 * @throws SQLException 
	 */
	public List<Object> queryByName(String keyword) throws SQLException {
		return new KeyWordDao().findKw4Ajax(keyword);
	}

}
