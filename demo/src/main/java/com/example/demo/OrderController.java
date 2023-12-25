package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.OrderService;
import com.expamlpe.classes.OrderObject;



@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")
	public String ecpayCheckout(@RequestBody OrderObject OOB) {
		String aioCheckOutALLForm = orderService.ecpayCheckout(OOB);
		
		return aioCheckOutALLForm;
	}
	@PostMapping("/queryOrder")
	public String queryOrder() {
		String PaymentInfo = orderService.queryOrder();
		System.out.println(PaymentInfo);
		return PaymentInfo;
	}
}