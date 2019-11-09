package buu.informatics.s59160092.paoyingchoop

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log

class ScoreFragmentViewModel(n1 :String ,n2 :String ,p1 :Int ,p2 :Int) : ViewModel() {

    private val _name1 = MutableLiveData<String>()
    val name1:LiveData<String>
        get() = _name1

    private val _name2 = MutableLiveData<String>()
    val name2:LiveData<String>
        get() = _name2

    private val _point1 = MutableLiveData<Int>()
    val point1:LiveData<Int>
        get() = _point1

    private val _point2 = MutableLiveData<Int>()
    val point2:LiveData<Int>
        get() = _point2



    init {

        _name1.value = n1
        _name2.value = n2
        _point1.value = p1
        _point2.value = p2

        Log.i("ScoreFragmentViewModel" , "ScoreFragmentViewModel Created!!")
    }

    fun InsertEb(nm1:String , nm2:String, pp1 :Int , pp2 :Int ) {

    }
}