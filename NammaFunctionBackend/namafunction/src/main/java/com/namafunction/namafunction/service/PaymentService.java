package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Payment;
import com.namafunction.namafunction.repository.PaymentRepository;
@Service
public class PaymentService implements IpaymentService {

	@Autowired
	private PaymentRepository paymentRepo;
	@Override
	public Payment createPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepo.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		// TODO Auto-generated method stub
		return paymentRepo.findById(id).get();
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}

	@Override
	public Payment updatePayment(Long id, Payment payment) {
        Optional<Payment> existingPaymentOptional = paymentRepo.findById(id);
        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();

            // Update fields if provided
            if (payment.getBooking() != null) existingPayment.setBooking(payment.getBooking());
            if (payment.getAmount() > 0) existingPayment.setAmount(payment.getAmount());
            if (payment.getPaymentDate() != null)
                existingPayment.setPaymentDate(payment.getPaymentDate());
            if (payment.getPaymentMethod() != null)
                existingPayment.setPaymentMethod(payment.getPaymentMethod());

            // Save and return the updated payment
            return paymentRepo.save(existingPayment);
        } else {
            throw new RuntimeException("Payment with ID " + id + " not found");
        }
    }

	@Override
	public String deletePaymentById(Long id) {
		// TODO Auto-generated method stub
		paymentRepo.deleteById(id);
		return "Payment Deleted";
	}

}
