package com.jk.conreoller;

import com.jk.entity.PrizeBean;
import com.jk.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/14 10:16
 * @Description:
 */
@Controller
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("prize")
    @ResponseBody
    public List<PrizeBean> queryList (){
        return orderService.queryList();
    }

    @PostMapping("prize")
    @ResponseBody
    public void savePrize(PrizeBean prizeBean){
        orderService.savePrize(prizeBean);
    }
}
