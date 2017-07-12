package com.kang.onlineshop.manager.service.impl;

import java.util.List;

import com.kang.onlineshop.common.pojo.TaotaoResult;
import com.kang.onlineshop.manager.dao.TbItemParamMapper;
import com.kang.onlineshop.manager.pojo.TbItemParam;
import com.kang.onlineshop.manager.pojo.TbItemParamExample;
import com.kang.onlineshop.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		TbItemParamExample.Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return TaotaoResult.ok(list.get(0));
		}
		
		return TaotaoResult.ok();
	}
}
