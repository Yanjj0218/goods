package com.jk.service;

import com.jk.entity.PrizeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/14 10:17
 * @Description:
 */
@FeignClient(value = "cloudprovider")//声明当前接口是一个feign客户端
public interface OrderService {
    @GetMapping("prize")
    public List<PrizeBean> queryList();
    @PostMapping("priza")
    void savePrize(PrizeBean prizeBean);
}
