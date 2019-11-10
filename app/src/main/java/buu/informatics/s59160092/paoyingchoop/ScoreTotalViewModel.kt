package buu.informatics.s59160092.paoyingchoop

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160092.paoyingchoop.database.History
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabaseDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ScoreTotalViewModel(
    val dataResource: HistoryDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    val database = dataResource

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var toHistory = MutableLiveData<History?>()
    val history = database.getAllHistory()


}