package com.fintech.com.fintech.kafka.dto

data class LoanRequestDto(
    val userKey: String,
    val userName: String,
    val userIncomeAmount: Long,
    var userRegistrationNumber: String
)