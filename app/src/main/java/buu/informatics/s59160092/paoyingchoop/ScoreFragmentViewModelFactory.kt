package buu.informatics.s59160092.paoyingchoop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreFragmentViewModelFactory (private val n1 : String , private val n2 : String , private val p1 : Int , private val p2 :Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreFragmentViewModel::class.java)) {
            return ScoreFragmentViewModel(n1, n2, p1, p2) as T
        }
        throw IllegalAccessException ("Unknow")
    }


}