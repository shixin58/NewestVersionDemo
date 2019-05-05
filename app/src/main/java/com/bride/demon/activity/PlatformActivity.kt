package com.bride.demon.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bride.baselib.BaseActivity
import com.bride.baselib.BaseFragment
import com.bride.demon.R

/**
 * test startActivityForResult, View#postInvalidate, Timer
 */
class PlatformActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platform)
    }

    companion object {

        fun openActivity(context: Context) {
            val intent = Intent(context, PlatformActivity::class.java)
            ContextCompat.startActivity(context, intent, null)
        }

        /**
         * 先import再引用类，不事先import直接包点类引用有差别吗
         * @param requestCode -1给startActivity用，>=0能被onActivityResult收到
         */
        fun openActivityForResult(activity: BaseActivity, requestCode: Int) {
            val intent = Intent(activity, PlatformActivity::class.java)
            activity.startActivityForResult(intent, requestCode)
        }

        fun openActivityForResult(fragment: BaseFragment, requestCode: Int) {
            val intent = Intent(fragment.activity, PlatformActivity::class.java)
            fragment.startActivityForResult(intent, requestCode)
        }
    }
}