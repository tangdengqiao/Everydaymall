package com.everydaymall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.entity.Collection;
import com.everydaymall.mapper.CollectionMapper;
import com.everydaymall.service.ICollectionService;
import com.everydaymall.utils.DateUtil;
import com.everydaymall.utils.StringUtils;

@Service
public class CollectionServiceImpl implements ICollectionService {

	private Logger LOGGER = LoggerFactory.getLogger(CollectionServiceImpl.class);

	@Autowired
	private CollectionMapper collectionMapper;
	
	/**
	 * 增加收藏
	 */
	@Override
	public int saveCollection(Collection collection) {
		try {
			collection.setIdCollection(StringUtils.getInstance().randomString(Constants.SUM_20));
			collection.setCollectionCreatetime(DateUtil.getCurrentTime());
			return collectionMapper.insertSelective(collection);
		} catch (Exception e) {
			LOGGER.info("CollectionServiceImpl    saveCollection  增加异常----" + e.toString());
		}
		return Constants.SAVEREGISTER_SUCESS;
	}

}
