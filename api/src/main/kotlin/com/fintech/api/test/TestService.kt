package com.fintech.api.test


import com.fintech.api.test.TestDto
import com.fintech.com.fintech.domain.UserInfo
import com.fintech.com.fintech.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}