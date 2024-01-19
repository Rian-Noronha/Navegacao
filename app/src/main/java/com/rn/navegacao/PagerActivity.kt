package com.rn.navegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.rn.navegacao.databinding.ActivityPagerBinding

class PagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagerBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val tabsPagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = tabsPagerAdapter
        binding.viewPager.setPageTransformer(true, ZoomPageTransformer())

    }
}