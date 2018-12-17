package com.jk.controller;

import com.jk.entity.PrizeBean;
import com.jk.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/13 20:56
 * @Description:
 */
@Controller
@RequestMapping("goods")
public class GoodController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("queryPrize")
    @ResponseBody
    public List<PrizeBean> queryPrize (){
        PrizeBean[] forObject = restTemplate.getForObject("http://cloudprovider/prize", PrizeBean[].class);
        List<PrizeBean> list= Arrays.asList(forObject);
        return list;
    }

    @RequestMapping("savePrize")
    @ResponseBody
    public void savePrize(PrizeBean prizeBean) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("prizeName",prizeBean.getPrizeName());
        requestEntity.add("prizeSum",prizeBean.getPrizeSum().toString());
        String s = restTemplate.postForObject("http://cloudprovider/prize", requestEntity, String.class);
    }


    @RequestMapping("editPrize")
    @ResponseBody
    public void editPrize(PrizeBean prizeBean) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("prizeId",prizeBean.getPrizeId().toString());
        requestEntity.add("prizeName",prizeBean.getPrizeName());
        requestEntity.add("prizeSum",prizeBean.getPrizeSum().toString());
        String s = restTemplate.postForObject("http://cloudprovider/editPrize", requestEntity, String.class);
    }


    @RequestMapping("queryById")
    @ResponseBody
    public PrizeBean queryById (Integer id){
        PrizeBean prizeBean = restTemplate.getForObject("http://cloudprovider/queryById?id="+id, PrizeBean.class);
        return prizeBean;
    }

    @RequestMapping("delPrizeByIds")
    @ResponseBody
    public void delPrizeByIds(String ids){
        restTemplate.delete("http://cloudprovider/prize?ids="+ids);
    }


    @RequestMapping("login")
    @ResponseBody
    public Integer loginUser(String loginNum, String loginPwd, HttpServletRequest request){
        UserBean userBean = restTemplate.getForObject("http://cloudprovider/login?loginNum="+loginNum, UserBean.class);
        System.out.println(userBean);
        if (userBean != null){
            System.out.println(userBean);
            request.getSession().setAttribute("userBean",userBean);
            return 1;
        }else {
            return 2;
        }
    }



    @RequestMapping("toindex")
    public String toindex(){
        return "index";
    }

    @RequestMapping("toaddPrize")
    public String toaddPrize(){
        return "addPrize";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("toeditPrize")
    public String toeditPrize(){
        return "editPrize";
    }

}
