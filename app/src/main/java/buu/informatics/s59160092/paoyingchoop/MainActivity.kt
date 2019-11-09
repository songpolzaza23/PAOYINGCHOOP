package buu.informatics.s59160092.paoyingchoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160092.paoyingchoop.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this , navController)
        Timber.i("onCreate Called!!")
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called!!")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume!!")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause!!")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called!!")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called!!")
    }
}
