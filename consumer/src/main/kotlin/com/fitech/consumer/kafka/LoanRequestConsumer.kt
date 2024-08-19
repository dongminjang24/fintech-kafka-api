package com.fitech.consumer.kafka
import com.fasterxml.jackson.databind.ObjectMapper
import com.fintech.com.fintech.kafka.dto.LoanRequestDto
import com.fitech.consumer.service.LoanRequestService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper,
    private val loanRequestService: LoanRequestService
) {
    @KafkaListener(topics=["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String){
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)

        loanRequestService.loanRequest(loanRequestKafkaDto)
    }
}