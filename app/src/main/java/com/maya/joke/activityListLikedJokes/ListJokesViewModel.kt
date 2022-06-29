package com.maya.joke.activityListLikedJokes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maya.joke.corutines.ScopeClass
import com.maya.joke.entiti.AppDatabase
import com.maya.joke.entiti.JokesItem
import kotlinx.coroutines.launch

class ListJokesViewModel :ViewModel() {

    private val scopeClass = ScopeClass()
    private val _jokesItemListData = MutableLiveData<List<JokesItem>>()
    val jokesItemListData: LiveData<List<JokesItem>>
        get() = _jokesItemListData

    fun getObsoleteDates(appDatabase: AppDatabase){
        scopeClass.scope.launch { val result = appDatabase.ListJokesDao().getAll() as ArrayList<JokesItem>
            _jokesItemListData.postValue(result) }
    }
}