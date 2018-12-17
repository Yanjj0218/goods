package com.jk.service;

import com.jk.entity.PrizeBean;
import com.jk.entity.UserBean;
import com.jk.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/13 20:42
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<PrizeBean> queryPrize(PrizeBean prizeBean) {
        List<PrizeBean> list =  goodsMapper.queryPrize(prizeBean);
        return list;
    }

    @Override
    public void delPrizeByIds(String ids) {
        goodsMapper.delPrizeByIds(ids);
    }

    @Override
    public void addPrize(PrizeBean prizeBean) {
        goodsMapper.addPrize(prizeBean);
    }

    @Override
    public PrizeBean queryById(Integer id) {
        return goodsMapper.queryById(id);
    }

    @Override
    public void editPrize(PrizeBean prizeBean) {
        goodsMapper.editPrize(prizeBean);
    }

    @Override
    public UserBean getUserInfoByuserName(String loginNum) {
        return goodsMapper.getUserInfoByuserName(loginNum);
    }
}
