package com.fitech.consumer.service

import com.fintech.com.fintech.domain.LoanReview
import com.fintech.com.fintech.kafka.dto.LoanRequestDto
import com.fintech.com.fintech.repository.LoanReviewRepository
import com.fitech.consumer.dto.ReviewResponseDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    companion object{
        const val nginxUrl = "http://nginx:8085/css/api/v1/request"
    }

    fun loanRequest(loanRequestDto: LoanRequestDto){
        val reviewResult = loanRequestCb(loanRequestDto)

        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    fun loanRequestCb(loanRequestDto: LoanRequestDto): ReviewResponseDto{
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        return restTemplate.postForEntity(nginxUrl, loanRequestDto, ReviewResponseDto::class.java).body!!

    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)


}