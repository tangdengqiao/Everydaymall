package com.everydaymall.service;

import com.everydaymall.entity.Collection;

public interface ICollectionService {
	/**
	 * 增加收藏
	 */
	int saveCollection(Collection collection);

}
