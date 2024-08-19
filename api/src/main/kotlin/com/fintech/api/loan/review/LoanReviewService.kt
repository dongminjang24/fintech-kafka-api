package com.fintech.api.loan.review

import com.fintech.com.fintech.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey: String) : LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String): LoanReview?


}