package com.hxl.domain.usecase.questions

import com.hxl.domain.models.Question
import com.hxl.domain.repository.QuestionRepository

class GetQuestion(private val questionRepository: QuestionRepository) {

    operator fun invoke(operations: Int, range: IntRange, operators: Array<String>): Question {
        return questionRepository.generateQuestion(operations, range, operators)
    }
}