package br.live.com.kafkapc.controller;

import br.live.com.kafkapc.producer.EcommerceNewOrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/neworder")
public class EcommerceNewOrderController {

    @Autowired
    private EcommerceNewOrderProducer ecommerceNewOrderProducer;

    @PostMapping
    public ResponseEntity<EcommerceNewOrderDTO> create(@RequestBody EcommerceNewOrderDTO ecommerceNewOrderDTO) {
        EcommerceNewOrderDTO newOrderDTO = EcommerceNewOrderDTO.builder().id(UUID.randomUUID().toString()).codDoPedido(ecommerceNewOrderDTO.getCodDoPedido()).build();
        ecommerceNewOrderProducer.send(newOrderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderDTO);
    }
}
