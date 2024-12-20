package com.namafunction.namafunction.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namafunction.namafunction.entity.Payment;
import com.namafunction.namafunction.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping("{id}")
	public  Payment getPaymentById(@PathVariable Long id) {
		return service.getPaymentById(id);
	}
	
	@GetMapping
	public List<Payment> getAllPayment() {
		return service.getAllPayment();
	}
	
	@PostMapping()
	public Payment createPayment(@RequestBody Payment payment) {
		return service.createPayment(payment);
	}
	
	@PutMapping("{id}")
	public Payment updatePayment(@PathVariable Long id,@RequestBody Payment payment) {
		
		payment.setId(id);
		return service.updatePayment(id, payment);
	}
		
	@DeleteMapping("{id}")
	public String deletePaymentById(@PathVariable Long id) {
		return service.deletePaymentById(id);
		
	
		
	}

}
