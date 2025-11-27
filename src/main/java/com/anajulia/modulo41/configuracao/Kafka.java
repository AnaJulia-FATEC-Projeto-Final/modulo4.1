package com.anajulia.modulo41.configuracao;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Kafka {
    @Bean
    public NewTopic pessoaTopico(
            @Value("${spring.kafka.topico.pessoa}") String topico,
            @Value("${spring.kafka.particoes}") int particoes,
            @Value("${spring.kafka.replicas}") short replicas) {
        return new NewTopic(topico, particoes, replicas);
    }
}
