package com.rn.navegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.rn.navegacao.databinding.ActivityTabsBinding

class TabsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabsBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val pagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}