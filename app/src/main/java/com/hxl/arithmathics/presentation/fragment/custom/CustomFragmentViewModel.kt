package com.hxl.arithmathics.presentation.fragment.custom

import androidx.lifecycle.ViewModel
import com.hxl.domain.models.QuestionDifficulty
import com.hxl.domain.usecase.prefs.GetCustom
import com.hxl.domain.usecase.prefs.GetTimer
import com.hxl.domain.usecase.prefs.SaveCustom
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CustomFragmentViewModel @Inject constructor(
    private val getCustom: GetCustom,
    private val saveCustom: SaveCustom,
    val getTimer: GetTimer
) : ViewModel() {
    var custom: QuestionDifficulty
        get() = getCustom()
        set(value) = saveCustom(value)
}