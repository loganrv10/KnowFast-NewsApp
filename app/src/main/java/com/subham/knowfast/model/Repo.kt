package com.subham.knowfast.model

import androidx.lifecycle.LiveData
import com.subham.knowfast.model.local.DataDao
import com.subham.knowfast.model.remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repo (val dataDao: DataDao){
    fun getDataFromApi(): LiveData<List<ArticlesItem>>{
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = Network.apiService.getData("in","106631ece5a74bf88ff7ca39ca05ac47").articles
                if (list != null){
                    dataDao.deleteFromDB()
                }
                list!!.forEach {
                    dataDao.addData(it!!)
                }

            }catch (e : Exception){

            }
        }
        return dataDao.getData()
    }


}