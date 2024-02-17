package com.rochards.productcatalogmanagement.domain

class BusinessException(
    val code: ExceptionCode = ExceptionCode.UNKNOWN,
    message: String
) : Exception(message)

enum class ExceptionCode {
    UNKNOWN,
    CATEGORY_NOT_FOUND,
    PRODUCT_NOT_FOUND,
    OWNER_MISMATCH
}
