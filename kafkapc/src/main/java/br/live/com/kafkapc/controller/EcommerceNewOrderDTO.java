package br.live.com.kafkapc.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EcommerceNewOrderDTO {

    private String id;
    private String codDoPedido;
}
