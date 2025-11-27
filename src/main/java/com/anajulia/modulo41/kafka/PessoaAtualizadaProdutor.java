package com.anajulia.modulo41.kafka;

import com.anajulia.modulo41.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class PessoaAtualizadaProdutor {
    private final String topico;
    private final KafkaTemplate<String, Pessoa> kafka;

    public PessoaAtualizadaProdutor(
            KafkaTemplate<String, Pessoa> kafka,
            @Value("${spring.kafka.topico.pessoa}") String topico) {
        this.topico = topico;
        this.kafka = kafka;
    }

    public void enviar(Pessoa pessoa) throws Exception {
        kafka.send(topico, UUID.randomUUID().toString(), pessoa)
                .get(5000, TimeUnit.MILLISECONDS);
    }
}
