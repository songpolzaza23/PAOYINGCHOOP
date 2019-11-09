package buu.informatics.s59160092.paoyingchoop

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreTotalViewModel : ViewModel() {

    init {
        Log.i("ScoreTotalViewModel", "ScoreTotalViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreTotalViewModel", "ScoreTotalViewModel destroyed!")
    }

}