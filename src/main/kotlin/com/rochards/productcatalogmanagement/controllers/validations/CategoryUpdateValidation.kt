package com.rochards.productcatalogmanagement.controllers.validations

import com.rochards.productcatalogmanagement.controllers.category.v1.CategoryUpdateRequest
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CategoryUpdateValidator::class])
annotation class CategoryUpdateValidation(
    val message: String = "{updateCategory.validation.message}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class CategoryUpdateValidator : ConstraintValidator<CategoryUpdateValidation, CategoryUpdateRequest> {
    override fun isValid(value: CategoryUpdateRequest?, context: ConstraintValidatorContext?): Boolean {
        return value?.title != null && value.title.isNotBlank()
                || value?.description != null && value.description.isNotBlank()
                || value?.ownerId != null && value.ownerId.isNotBlank()
    }


}
