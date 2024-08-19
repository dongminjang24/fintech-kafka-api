//package com.fintech.api.loan.request
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.KotlinModule
//import com.fintech.api.loan.GenerateKey
//import com.fintech.api.loan.encrypt.EncryptComponent
//import com.fintech.com.fintech.domain.UserInfo
//import com.fintech.com.fintech.repository.UserInfoRepository
//
//import io.mockk.every
//import io.mockk.mockk
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.DisplayName
//import org.junit.jupiter.api.Test
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.post
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//@WebMvcTest(LoanRequestController::class)
//internal class LoanRequestControllerTest{
//    private lateinit var mockMvc: MockMvc
//
//    private lateinit var loanRequestController: LoanRequestController
//
//    // serviceImpl 만드는데 필요한 것들
//    private lateinit var generateKey: GenerateKey
//    private lateinit var encryptComponent: EncryptComponent
//    private val userInfoRepository: UserInfoRepository=mockk()
//
//    private lateinit var mapper: ObjectMapper
//
//    @MockBean
//    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl
//
//    companion object{
//        private const val baseUrl="/fintech/api/v1"
//    }
//
//    @BeforeEach
//    fun init(){
//        generateKey= GenerateKey()
//        encryptComponent= EncryptComponent()
//
//        loanRequestServiceImpl = LoanRequestServiceImpl(
//            generateKey, userInfoRepository, encryptComponent
//        )
//        loanRequestController= LoanRequestController(loanRequestServiceImpl)
//
//        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()
//
//        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
//    }
//
//    @Test
//    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다.")
//    fun testNormalCase(){
//        //given
//        val loanRequestInfoDto:LoanRequestDto.LoanRequestInputDto=
//            LoanRequestDto.LoanRequestInputDto(
//                userName="Test",
//                userIncomeAmount = 10000,
//                userRegistrationNumber = "000101-101010"
//            )
//
//        every { userInfoRepository.save(any())} returns UserInfo("","","",1)
//
//        //when
//        //then
//        mockMvc.post(
//            "$baseUrl/request"
//        ){
//            contentType= MediaType.APPLICATION_JSON
//            accept= MediaType.APPLICATION_JSON
//            content=mapper.writeValueAsString(loanRequestInfoDto)
//        }.andExpect {
//            status { isOk() }
//        }
//    }
//}