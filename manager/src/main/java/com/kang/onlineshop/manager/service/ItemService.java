package com.kang.onlineshop.manager.service;


import com.kang.onlineshop.common.pojo.EUDataGridResult;
import com.kang.onlineshop.common.pojo.TaotaoResult;
import com.kang.onlineshop.manager.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(long itemId);
	public EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception;
}
