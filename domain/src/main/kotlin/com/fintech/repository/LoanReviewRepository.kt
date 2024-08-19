package com.fintech.com.fintech.repository

import com.fintech.com.fintech.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

interface LoanReviewRepository : JpaRepository<LoanReview,Long> {

    fun findByUserKey(userKey: String): LoanReview
}