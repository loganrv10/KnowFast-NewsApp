package com.subham.knowfast.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subham.knowfast.model.ArticlesItem
import com.subham.knowfast.model.Repo

class TheViewModel(private val repo: Repo) : ViewModel() {
    fun getData(): LiveData<List<ArticlesItem>> {
        return repo.getDataFromApi()
    }


}

class ViewModelFactory(private val repo: Repo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}
