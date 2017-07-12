package com.kang.onlineshop.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.onlineshop.manager.dao.TbItemMapper;
import com.kang.onlineshop.manager.pojo.TbItem;
import com.kang.onlineshop.manager.pojo.TbItemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by yuankang on 2017/7/2.
 */
@MapperScan("com.kang.onlineshop.manager.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPageHelper {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Test
    public void testPageHelper() {
        TbItemExample tbItemExample = new TbItemExample();
        PageHelper.startPage(1, 10);
        List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
        for(TbItem tbItem: list){
            System.out.println(tbItem.getTitle());
        }
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("一共有："+total);
    }
}
