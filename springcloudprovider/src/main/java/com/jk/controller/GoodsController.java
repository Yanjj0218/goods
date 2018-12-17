package com.jk.controller;

import com.jk.entity.PrizeBean;
import com.jk.entity.UserBean;
import com.jk.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/13 20:40
 * @Description:
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "prize",method = RequestMethod.GET)
    public List<PrizeBean> queryPrize (PrizeBean prizeBean){
        return goodsService.queryPrize(prizeBean);
    }


    @RequestMapping(value = "prize",method = RequestMethod.DELETE)
    public Boolean delPrizeByIds(String ids) {
        try {
            goodsService.delPrizeByIds(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "prize",method = RequestMethod.POST)
    public Boolean addPrize(@RequestBody PrizeBean prizeBean) {
        try {
            goodsService.addPrize(prizeBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "queryById",method = RequestMethod.GET)
    public PrizeBean queryById(Integer id){
        return goodsService.queryById(id);
    }

    @RequestMapping(value = "editPrize",method = RequestMethod.POST)
    public Boolean editPrize(PrizeBean prizeBean) {
        try {
            goodsService.editPrize(prizeBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @RequestMapping(value = "login",method = RequestMethod.GET)
    private UserBean login(String  loginNum) {
        UserBean userInfo = goodsService.getUserInfoByuserName(loginNum);
        return userInfo;
    }
}
