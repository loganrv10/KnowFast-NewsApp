package com.subham.knowfast.views

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.subham.knowfast.R
import com.subham.knowfast.databinding.ActivityDettailedBinding
import com.subham.knowfast.databinding.ActivityMainBinding
import com.subham.knowfast.model.ArticlesItem

class DetailedActivity : AppCompatActivity() {

    private lateinit var detailedBinding: ActivityDettailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
       detailedBinding= DataBindingUtil.setContentView(this,R.layout.activity_dettailed)
        if (intent != null && intent.hasExtra("data")) {
            val data = intent.getSerializableExtra("data") as ArticlesItem
            detailedBinding.item = data
        }

        detailedBinding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}