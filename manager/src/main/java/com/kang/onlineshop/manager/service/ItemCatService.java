package com.kang.onlineshop.manager.service;

import com.kang.onlineshop.common.pojo.EUTreeNode;

import java.util.List;


public interface ItemCatService {
	public List<EUTreeNode> getItemCatList(long parentId);
}
