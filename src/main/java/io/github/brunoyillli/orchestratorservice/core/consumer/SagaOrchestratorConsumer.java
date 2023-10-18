package io.github.brunoyillli.orchestratorservice.core.consumer;


import io.github.brunoyillli.orchestratorservice.core.dto.Event;
import io.github.brunoyillli.orchestratorservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class SagaOrchestratorConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.start-saga}"
    )
    public void consumerStartSagaEvent(String payload){
        log.info("Receiving  event {} from start-saga topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.orchestrator}"
    )
    public void consumerOrchestratorEvent(String payload){
        log.info("Receiving  event {} from orchestrator topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.finish-success}"
    )
    public void consumerFinishSuccessEvent(String payload){
        log.info("Receiving  event {} from finish-success topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.finish-fail}"
    )
    public void consumerFinishFailEvent(String payload){
        log.info("Receiving  event {} from finish-fail topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }
}
