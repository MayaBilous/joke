package com.maya.joke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maya.joke.activityMainScreen.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_layout, MainFragment(), null)
                .commit()
        }
    }
}