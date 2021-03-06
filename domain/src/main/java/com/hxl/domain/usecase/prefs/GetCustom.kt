package com.hxl.domain.usecase.prefs

import com.hxl.domain.models.QuestionDifficulty
import com.hxl.domain.repository.CustomRepository

class GetCustom(private val customRepository: CustomRepository) {

    operator fun invoke(): QuestionDifficulty {
        return customRepository.getCustom()
    }
}