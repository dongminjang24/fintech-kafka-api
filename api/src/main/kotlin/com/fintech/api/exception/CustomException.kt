package com.fintech.api.exception

class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException()