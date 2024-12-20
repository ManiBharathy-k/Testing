package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Payment;

public interface IpaymentService {
	
	public Payment createPayment(Payment payment);
	public Payment getPaymentById(Long id);
	public List<Payment> getAllPayment();
	public Payment updatePayment(Long id,Payment payment);
	public String deletePaymentById(Long id);

}
