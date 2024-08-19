package com.fintech.api.loan.request

import com.fintech.com.fintech.domain.UserInfo
import com.fintech.com.fintech.kafka.dto.LoanRequestDto

data class UserInfoDto(
    val userKey: String,
    val userName: String,
    val userRegistrationNumber: String,
    val userIncomeAmount: Long
){
    fun toEntity(): UserInfo =UserInfo(
            userKey = userKey,
            userName = userName,
            userRegistrationNumber = userRegistrationNumber,
            userIncomeAmount = userIncomeAmount)


    fun toLoanRequestKafkaDto() =  LoanRequestDto(userKey, userName, userIncomeAmount, userRegistrationNumber)

}
