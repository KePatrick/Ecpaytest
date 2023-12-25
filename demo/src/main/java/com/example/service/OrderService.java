package com.example.service;


import java.util.UUID;

import org.springframework.stereotype.Service;

import com.expamlpe.classes.OrderObject;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.QueryTradeInfoObj;

@Service
public class OrderService {

	public String ecpayCheckout() {
		
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		
		AllInOne all = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(uuId);
		obj.setMerchantTradeDate("2017/01/01 08:05:23");
		obj.setTotalAmount("50");
		obj.setTradeDesc("test Description");
		obj.setItemName("TestItem");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}
	public String ecpayCheckout(OrderObject OOB) {
		
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		
		AllInOne all = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(uuId);
		obj.setMerchantTradeDate("2017/01/01 08:05:23");
		obj.setTotalAmount(OOB.getTotalAmount());
		obj.setTradeDesc("test Description");
		obj.setItemName(OOB.getItemName());
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setOrderResultURL("http://localhost:8080/query.html");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}
		public String queryOrder() {
			AllInOne all = new AllInOne("");
			QueryTradeInfoObj obj = new QueryTradeInfoObj();
			obj.setMerchantTradeNo("37e4356d6e1441e99275");
			return all.queryTradeInfo(obj);
				
			}
}