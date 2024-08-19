package com.fintech.api.loan.request

import com.fintech.api.loan.request.UserInfoDto


class LoanRequestDto {

    data class LoanRequestInputDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String
    ){
        fun toUserInfoDto(userKey: String): UserInfoDto = UserInfoDto(
            userKey,
            userName,
           userRegistrationNumber,
            userIncomeAmount
        )

    }

    data class LoanRequestResponseDto(
        val userKey: String
    )

}