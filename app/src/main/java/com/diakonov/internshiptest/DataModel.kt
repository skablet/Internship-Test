package com.diakonov.internshiptest


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {

    val score: LiveData<Score> get() = scoreLiveData
    private val scoreLiveData = MutableLiveData<Score>()

    fun initState(score: Score){
        scoreLiveData.value = score
    }
    fun increment(){
        val oldScore = scoreLiveData.value
        scoreLiveData.value = oldScore?.copy(
            oldScore.countValue + 1
        )

    }

data class Score(val countValue: Int = 0)
}
