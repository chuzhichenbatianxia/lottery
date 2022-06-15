package com.chuyu.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.chuyu.lottery.util.IndexUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LotteryController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @PostMapping("/lottery")
    public String lottery(HttpServletRequest request,String lottery, Integer number){
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> integers = IndexUtil.lottery(lottery);
            a.add(integers);
        }
        request.setAttribute("lottery" ,a);
        return "list";
    }

    @GetMapping("/gaobai")
    public String gaobai(HttpServletRequest request){

        return "gaobai";
    }

}
