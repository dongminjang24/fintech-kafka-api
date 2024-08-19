package com.fintech.api.loan.request

import com.fintech.api.loan.GenerateKey
import com.fintech.api.loan.encrypt.EncryptComponent
import com.fintech.com.fintech.kafka.enum.KafkaTopic
import com.fintech.com.fintech.kafka.producer.LoanRequestSender
import com.fintech.com.fintech.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent,
    private val loanRequestSender: LoanRequestSender
) : LoanRequestService {

    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {
        val userKey = generateKey.generateUserKey()
       loanRequestInputDto.userRegistrationNumber =
           encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfo = loanRequestInputDto.toUserInfoDto(userKey)
        saveUserInfo(userInfo)
        loanRequestReview(userInfo)
        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }


    override fun saveUserInfo(
        userInfo: UserInfoDto
    ) = userInfoRepository.save(userInfo.toEntity())


    override fun loanRequestReview(userInfo: UserInfoDto) {
        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfo.toLoanRequestKafkaDto()
        )
    }
}