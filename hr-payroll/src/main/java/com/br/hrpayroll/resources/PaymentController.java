package com.br.hrpayroll.resources;

import com.br.hrpayroll.entities.Payment;
import com.br.hrpayroll.entities.request.WorkerRequest;
import com.br.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable Integer days){
        Payment payment = paymentService.getPayment(workerId,days);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/worker/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPaymentQueryParam(@PathVariable long workerId, @PathVariable Integer days){
        Payment payment = paymentService.getPaymentQueryParam(workerId,days);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/result")
    public ResponseEntity<?> getPaymentQueryParam(@RequestBody WorkerRequest request){
        var result = paymentService.postWorkerTest(request);
        return ResponseEntity.ok(result);
    }
}
