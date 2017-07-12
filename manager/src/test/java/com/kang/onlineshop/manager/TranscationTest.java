package com.kang.onlineshop.manager;

import com.kang.onlineshop.manager.pojo.TbItem;
import com.kang.onlineshop.manager.service.ItemService;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by yuankang on 2017/6/28.
 */
@MapperScan("com.kang.onlineshop.manager.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscationTest {
    @Resource
    private ItemService itemService;
    @org.junit.Test
    public void test() {
        int itemId = 536563;
        TbItem tbItem = itemService.getItemById(itemId);
        System.out.println(tbItem.toString());
    }
}
