package com.fintech.com.fintech.kafka.producer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fintech.com.fintech.kafka.dto.LoanRequestDto
import com.fintech.com.fintech.kafka.enum.KafkaTopic
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LoanRequestSender(
    private val kafkaTemplate:KafkaTemplate<String, String>,
    private val objectMapper:ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestDto: LoanRequestDto){
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestDto))
    }
}