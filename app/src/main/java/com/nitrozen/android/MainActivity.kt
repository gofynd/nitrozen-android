package com.nitrozen.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nitrozen.android.navigator.AppNavigator
import com.nitrozen.android.navigator.Navigator

class MainActivity : AppCompatActivity() {

    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        navigator = AppNavigator(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}