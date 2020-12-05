package com.br.hrpayroll.services;

import com.br.hrpayroll.entities.Payment;
import com.br.hrpayroll.entities.dto.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;


    public Payment getPayment(long workerId,int days){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",""+workerId);

        WorkerDTO worker = restTemplate.getForObject(workerHost + "/workers/{id}",WorkerDTO.class,uriVariables);
        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

    public Payment getPaymentQueryParam(long workerId,int days){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",""+workerId);

        WorkerDTO worker = restTemplate.getForObject(workerHost + "/workers/Param?id={id}",WorkerDTO.class,uriVariables);
        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

}
