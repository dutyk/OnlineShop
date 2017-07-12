package com.kang.onlineshop.manager.service;

import com.kang.onlineshop.common.pojo.EUTreeNode;
import com.kang.onlineshop.common.pojo.TaotaoResult;

import java.util.List;


public interface ContentCategoryService {
	public List<EUTreeNode> getCategoryList(long parentId);
	public TaotaoResult insertContentCategory(long parentId, String name);
}
