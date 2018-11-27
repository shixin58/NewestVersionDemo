package com.bride.widget.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.bride.widget.R

class BossFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = BossFragment()
    }

    private lateinit var viewModel: BossViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_boss, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BossViewModel::class.java)
        // TODO: Use the ViewModel
    }

}