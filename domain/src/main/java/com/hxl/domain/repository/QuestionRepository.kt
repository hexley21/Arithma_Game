package com.hxl.domain.repository

import com.hxl.domain.models.Question

interface QuestionRepository {

    fun generateQuestion(operations: Int, numberRange: Int, operators: Array<String>): Question

}