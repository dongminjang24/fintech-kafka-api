package com.fintech.api.loan.request

import com.fintech.com.fintech.domain.UserInfo

interface LoanRequestService {

    fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(
        userInfo: UserInfoDto
    ): UserInfo

    fun loanRequestReview(userInfo: UserInfoDto)
}