package com.kang.onlineshop.manager.controller;

/**
 * Created by yuankang on 2017/7/3.
 */

import com.kang.onlineshop.common.pojo.EUTreeNode;
import com.kang.onlineshop.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value="/item/cat/list")
    @ResponseBody
    public List<EUTreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
        List<EUTreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }
}
