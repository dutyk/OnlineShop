package com.kang.onlineshop.manager.controller;

import com.kang.onlineshop.common.pojo.EUDataGridResult;
import com.kang.onlineshop.manager.pojo.TbItem;
import com.kang.onlineshop.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuankang on 2017/7/2.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }
    @GetMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows){
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
}
