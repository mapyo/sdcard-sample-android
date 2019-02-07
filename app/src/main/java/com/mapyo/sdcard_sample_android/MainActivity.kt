package com.mapyo.sdcard_sample_android

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mapyo.sdcard_sample_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.requestPermissionButton.setOnClickListener {
            Toast.makeText(this , "hoge", Toast.LENGTH_SHORT).show();
        }
    }
}
