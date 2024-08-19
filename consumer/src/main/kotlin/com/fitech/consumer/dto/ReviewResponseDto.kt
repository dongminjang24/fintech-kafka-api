package com.fitech.consumer.dto

import com.fintech.com.fintech.domain.LoanReview


data class ReviewResponseDto(
    val userKey: String,
    val interest: Double,
    val limitAmount: Long
){
    fun toLoanReviewEntity(): LoanReview=
        LoanReview(
            userKey = userKey,
            loanInterest = interest,
            loanLimitedAmount = limitAmount
        )
}