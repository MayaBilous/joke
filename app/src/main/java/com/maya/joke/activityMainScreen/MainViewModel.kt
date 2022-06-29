package com.maya.joke.activityMainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maya.joke.corutines.ScopeClass
import com.maya.joke.entiti.AppDatabase
import com.maya.joke.entiti.JokesItem
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val scopeClass = ScopeClass()
    private val _jokesItemListData = MutableLiveData<List<JokesItem>>()
    val jokesItemListData: LiveData<List<JokesItem>>
        get() = _jokesItemListData

    fun addItem(appDatabase: AppDatabase, nameItem:String) {
        scopeClass.scope.launch { appDatabase.ListJokesDao().insert(JokesItem(0, nameItem)) }
    }
}