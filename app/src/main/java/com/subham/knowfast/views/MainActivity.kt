package com.subham.knowfast.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.subham.knowfast.R
import com.subham.knowfast.views.adapter.NewsAdapter
import com.subham.knowfast.model.ArticlesItem
import com.subham.knowfast.model.local.DataDao
import com.subham.knowfast.model.local.TheDatabase
import com.subham.knowfast.model.Repo
import com.subham.knowfast.databinding.ActivityMainBinding
import com.subham.knowfast.viewModel.TheViewModel
import com.subham.knowfast.viewModel.ViewModelFactory
import com.subham.knowfast.views.adapter.OnItemClick

class MainActivity : AppCompatActivity() ,OnItemClick {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: TheViewModel
    lateinit var repo: Repo
    lateinit var dataDao: DataDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataDao = TheDatabase.getDatabaseInstance(this).getDao()
        repo = Repo(dataDao)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(TheViewModel::class.java)

        viewModel.getData().observe(this, Observer {
            val list = it as ArrayList<ArticlesItem>
            list.forEach {
                Log.d("list2", it.toString())
            }
            setRecyclerView(list)
        })
    }

    private fun setRecyclerView(list: java.util.ArrayList<ArticlesItem>) {
        val newsAdapter = NewsAdapter(list, this)
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onClick(articlesItem: ArticlesItem) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("data", articlesItem)
        startActivity(intent)
    }
}