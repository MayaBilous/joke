package com.maya.joke.activityMainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maya.joke.corutines.ScopeClass
import com.maya.joke.entiti.AppDatabase
import com.maya.joke.entiti.JokesItem
import com.maya.joke.retrofit.QuotesApi
import com.maya.joke.retrofit.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val scopeClass = ScopeClass()
    private val _jokesItemListData = MutableLiveData<List<JokesItem>>()
    val jokesItemListData: LiveData<List<JokesItem>>
        get() = _jokesItemListData
    private val _jokes = MutableLiveData<String>()
    val jokes: LiveData<String>
        get() = _jokes

    fun addItem(appDatabase: AppDatabase, nameItem:String) {
        scopeClass.scope.launch { appDatabase.ListJokesDao().insert(JokesItem(0, nameItem)) }
    }

    fun jokeText() : String{
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            _jokes.value = quotesApi.getQuotes().toString()
        }
        return jokes.value.toString()
    }
}