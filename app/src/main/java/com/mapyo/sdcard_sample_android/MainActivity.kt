package com.mapyo.sdcard_sample_android

import android.app.Activity
import android.app.Instrumentation
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mapyo.sdcard_sample_android.databinding.ActivityMainBinding
import android.content.Intent
import android.util.Log


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.requestPermissionButton.setOnClickListener {
            requestSdcardAccessPermission()
        }
    }

    // 5系でのみの許可を得る方法
    // TODO 事前にピッカーで指定された操作をやってもらうようにする必要がある。
    private fun requestSdcardAccessPermission() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        startActivityForResult(intent, SDCARD_ACCESS_PERMISSION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                Toast.makeText(this, "何かが選択されました。", Toast.LENGTH_SHORT).show()
                // TODO SDカードのフォルダ以外を選択肢た場合でもRESULT_OKが選択されるため、別途チェックが必要
            }
            else -> {
                Log.d(TAG, "resultCode: $resultCode")
            }
        }
    }

    companion object {
        private const val SDCARD_ACCESS_PERMISSION_REQUEST_CODE = 1
        private val TAG = MainActivity::class.java.simpleName
    }
}
