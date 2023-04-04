package com.eg.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.os.api.common.Payment;
import com.eg.os.api.common.TransactionRequest;
import com.eg.os.api.common.TransactionResponse;
import com.eg.os.api.entity.Order;
import com.eg.os.api.service.OrderService;
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service ;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request ) {
		
		
		return service.saveOrder(request);
		//do a rest call to payment & pass the order id
	}
	

}
