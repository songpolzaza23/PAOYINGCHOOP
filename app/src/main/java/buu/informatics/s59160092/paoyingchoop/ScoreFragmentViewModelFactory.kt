package buu.informatics.s59160092.paoyingchoop

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabaseDAO

class ScoreFragmentViewModelFactory (
    private val n1 : String , private val n2 : String , private val p1 : String , private val p2 :String , private val dataSource: HistoryDatabaseDAO, private val application: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreFragmentViewModel::class.java)) {
            return ScoreFragmentViewModel(n1, n2, p1, p2 , dataSource , application) as T
        }
        throw IllegalAccessException ("Unknow")
    }


}