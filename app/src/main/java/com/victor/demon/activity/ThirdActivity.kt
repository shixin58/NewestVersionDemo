package com.victor.demon.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import com.max.baselib.BaseActivity
import com.victor.demon.R

/**
 *
 * Created by shixin on 2018/9/6.
 */
class ThirdActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when {
            v?.id==R.id.tv_jump -> SecondActivity.openActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        initView()
    }

    private fun initView() {
        findViewById<View>(R.id.tv_jump).setOnClickListener(this)
    }

    companion object {
        fun openActivity(activity: FragmentActivity?) {
            val intent = Intent(activity, ThirdActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}