package buu.informatics.s59160092.paoyingchoop

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160092.paoyingchoop.database.History
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabase
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabaseDAO
import kotlinx.coroutines.*
import kotlin.math.log

class ScoreFragmentViewModel(n1 :String ,n2 :String ,p1 :String ,p2 :String , val database: HistoryDatabaseDAO , application: Application) : ViewModel() {

    private val _name1 = MutableLiveData<String>()
    val name1:LiveData<String>
        get() = _name1

    private val _name2 = MutableLiveData<String>()
    val name2:LiveData<String>
        get() = _name2

    private val _point1 = MutableLiveData<String>()
    val point1:LiveData<String>
        get() = _point1

    private val _point2 = MutableLiveData<String>()
    val point2:LiveData<String>
        get() = _point2

    private var viewModelJob = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var tohistory = MutableLiveData<History?>()

    init {

        _name1.value = n1
        _name2.value = n2
        _point1.value = p1
        _point2.value = p2

//        initializeTohistory()
//
//        onInsert()

        Log.i("ScoreFragmentViewModel" , "ScoreFragmentViewModel Created!!")
    }

//    private fun initializeTohistory() {
//        uiScope.launch {
//            tohistory.value = getToHistoryFromDatabase() }
//    }
//
//    private suspend fun getToHistoryFromDatabase(): History? {
//        return withContext(Dispatchers.IO) {
//            var history = database.getToHistory()
//
//            history
//        }
//    }
//
//    fun onInsert() {
//        uiScope.launch {
//            val newHistory = History(1 , _name1.value.toString() , _name2?.value.toString() , _point1?.value!!.toInt(), _point2?.value!!.toInt())
//            insert(newHistory)
//        }
//    }
//
//    private suspend fun insert(history: History) {
//        withContext(Dispatchers.IO) {
//            database.insert(history)
//        }
//    }

    fun InsertEb(waitInsertData: WaitInsertData ) {
        uiScope.launch {
            insert(History(null , waitInsertData.namePlayer1 , waitInsertData.namePlayer2 , waitInsertData.score1 , waitInsertData.score2))
//            var result = database.getToHistory()
//            withContext(Dispatchers.Main) {
//                _name1.value = result?.namePlayer1
//                _name2.value = result?.namePlayer2
//                _point1.value = result?.scorePlayer1
//                _point2.value = result?.scorePlayer2
////                Log.i("database" , "${waitInsertData.namePlayer1}")
//            }
        }
    }

    private suspend  fun insert(newHistory: History) {
        withContext(Dispatchers.IO) {
            database.insert(newHistory)
            Log.i("database" , "${newHistory}")
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }
}