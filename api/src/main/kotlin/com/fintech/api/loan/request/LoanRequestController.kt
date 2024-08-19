package com.fintech.api.loan.request

import com.fintech.api.loan.request.LoanRequestDto
import com.fintech.api.loan.request.LoanRequestServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/fintech/api/v1")
class LoanRequestController @Autowired constructor(
    private val loanRequestServiceImpl: LoanRequestServiceImpl
) {

    @PostMapping("/request")
    fun loanRequest(
        @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): ResponseEntity<LoanRequestDto.LoanRequestResponseDto>{
        return ResponseEntity.ok(loanRequestServiceImpl.loanRequestMain(loanRequestInputDto))
    }
}