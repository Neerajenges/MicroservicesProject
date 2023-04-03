package com.eg.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	
	@RequestMapping("/orderFallback")
	public Mono<String> OrderServiceFallback(){
		return Mono.just("Order Service is taking too long to respond or is down.please try again later");
		
	}
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("payment service is taking too long to respond or is down.please try again later");
	}

}
