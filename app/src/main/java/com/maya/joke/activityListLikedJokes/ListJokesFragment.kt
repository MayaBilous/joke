package com.maya.joke.activityListLikedJokes

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.maya.joke.R
import com.maya.joke.corutines.ScopeClass
import com.maya.joke.databinding.FragmentListBinding
import com.maya.joke.entiti.AppDatabase
import com.maya.joke.entiti.JokesItem
import com.maya.joke.recycleView.CustomAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ListJokesFragment : Fragment(R.layout.fragment_list) {

    private var adapter = CustomAdapter { jokesItem -> onDeleteClickAction(jokesItem) }

    private var appDatabase: AppDatabase? = null
    private val viewModel: ListJokesViewModel by viewModels()
    private val scopeClass = ScopeClass()
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        appDatabase = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "database-name"
        ).build()

        appDatabase?.let {
            viewModel.getObsoleteDates(it)
        }

        viewModel.jokesItemListData.observe(this) { jokesItemList ->
            adapter.addData(jokesItemList)
        }

        binding.exitButton.setOnClickListener { parentFragmentManager.popBackStack() }

    }
    fun onDeleteClickAction(jokesItem : JokesItem){
        adapter.deleteData(jokesItem)
        scopeClass.scope.launch { appDatabase?.ListJokesDao()?.delete(jokesItem) }
//        Thread{}.start()
    }
}