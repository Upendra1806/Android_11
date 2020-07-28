package com.payoda.android_11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.payoda.android_11.fragments.FragmentAddUser
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addUserFragment = FragmentAddUser()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, addUserFragment)
            .commit();
    }


    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment, tag).addToBackStack("").commit()
    }
}
