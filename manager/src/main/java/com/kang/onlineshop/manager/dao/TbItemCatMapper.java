package com.kang.onlineshop.manager.dao;

import com.kang.onlineshop.manager.pojo.TbItemCat;
import com.kang.onlineshop.manager.pojo.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbItemCatMapper {
    int countByExample(TbItemCatExample example);

    int deleteByExample(TbItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    List<TbItemCat> selectByExample(TbItemCatExample example);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
}