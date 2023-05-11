package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityOpenItemPostBinding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class OpenItemPost : AppCompatActivity() {
    lateinit var binding: ActivityOpenItemPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenItemPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        binding.collapsingDetail.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null)
            showData(dataPost)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return true
    }

    private fun showData(dataPost: ItemPost) {
        Glide.with(this).load(dataPost.urlImage).into(binding.imgDetail)
        binding.txtDetailTitle.text = dataPost.title
        binding.txtDetailSubtitle.text = dataPost.subtitle
        binding.txtDetailDetail.text  = dataPost.detail

        binding.fabDetail.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW , Uri.parse(dataPost.url))
            startActivity(intent)
        }

        binding.collapsingDetail.title = dataPost.title
    }
}