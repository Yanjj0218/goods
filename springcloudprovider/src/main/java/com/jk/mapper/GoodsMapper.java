package com.jk.mapper;

import com.jk.entity.PrizeBean;
import com.jk.entity.UserBean;

import java.util.List;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/13 20:42
 * @Description:
 */
public interface GoodsMapper {

    List<PrizeBean> queryPrize(PrizeBean prizeBean);

    void delPrizeByIds(String ids);

    void addPrize(PrizeBean prizeBean);

    PrizeBean queryById(Integer id);

    void editPrize(PrizeBean prizeBean);

    UserBean getUserInfoByuserName(String loginNum);
}
