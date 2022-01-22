package com.subham.knowfast.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.subham.knowfast.model.ArticlesItem
import com.subham.knowfast.R
import com.subham.knowfast.databinding.ItemViewBinding

class NewsAdapter(val newsList: ArrayList<ArticlesItem>,
                    private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemViewBinding: ItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_view, parent, false)
        return NewsHolder(itemViewBinding)
    }


    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bindData(newsList[position],onItemClick)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


    class NewsHolder(private val itemViewBinding: ItemViewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
     fun bindData(articlesItem: ArticlesItem,onItemClick: OnItemClick){
         itemViewBinding.item = articlesItem
         itemViewBinding.itemClick = onItemClick
     }
    }
}