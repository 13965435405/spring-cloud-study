package com.loafer.springcloud.controller;

import com.loafer.springcloud.entity.CommonResult;
import com.loafer.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL="http://localhost:8001";

    @RequestMapping("/order/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @RequestMapping("/order/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
