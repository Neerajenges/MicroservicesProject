package com.eg.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eg.os.api.common.Payment;
import com.eg.os.api.common.TransactionRequest;
import com.eg.os.api.common.TransactionResponse;
import com.eg.os.api.entity.Order;
import com.eg.os.api.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		Order order=request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//rest call
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment, Payment.class);
		response=paymentResponse.getPaymentStatus().equals("success")?"payment processed successfully and order placed":"there is failure in api,order added to cart";
		
		repository.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}

}
