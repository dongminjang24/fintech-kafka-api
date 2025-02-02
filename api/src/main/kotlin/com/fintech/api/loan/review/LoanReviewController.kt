package com.fintech.api.loan.review

import com.fintech.api.loan.review.LoanReviewDto
import com.fintech.api.loan.review.LoanReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController(
    private val loanReviewService: LoanReviewService
) {

    @GetMapping("/review/{userKey}")
    fun getReviewData(
        @PathVariable userKey: String,
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
            loanReviewService.loanReviewMain(userKey)
        )
    }
}