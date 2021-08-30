package com.hadi.mvvmplayground.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hadi.mvvmplayground.databinding.ActivityMainBinding
import com.hadi.mvvmplayground.ui.adapter.PicsAdapter
import com.hadi.mvvmplayground.util.Resource
import com.hadi.mvvmplayground.util.errorSnack
import com.hadi.mvvmplayground.util.hide
import com.hadi.mvvmplayground.util.show
import com.hadi.mvvmplayground.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var picsAdapter: PicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init() {
        binding.rvPics.setHasFixedSize(true)
        binding.rvPics.layoutManager = LinearLayoutManager(this)
        picsAdapter = PicsAdapter()
        getPictures()
    }

    private fun getPictures() {
        mainViewModel.getPictures()
        mainViewModel.picsResponse.observe(this, { response ->
            when (response) {
                is Resource.Success -> {
                    binding.progress.hide()
                    response.data?.let { picsResponse ->
                        picsAdapter.differ.submitList(picsResponse)
                        binding.rvPics.adapter = picsAdapter
                    }
                }

                is Resource.Error -> {
                    binding.progress.hide()
                    response.message?.let { message ->
                        binding.root.errorSnack(message, Snackbar.LENGTH_LONG)
                    }

                }

                is Resource.Loading -> {
                    binding.progress.show()
                }
            }
        })
    }


}