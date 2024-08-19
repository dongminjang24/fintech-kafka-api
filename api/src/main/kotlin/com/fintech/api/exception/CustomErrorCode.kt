package com.fintech.api.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {
    RESULT_NOT_FOUNT(
        HttpStatus
        .BAD_REQUEST, "E001", errorMessage = "result not found")
}