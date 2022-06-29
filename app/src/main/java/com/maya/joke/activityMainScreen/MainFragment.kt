package com.maya.joke.activityMainScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.maya.joke.R
import com.maya.joke.activityListLikedJokes.ListJokesFragment
import com.maya.joke.databinding.FragmentMainscreenBinding
import com.maya.joke.entiti.AppDatabase

class MainFragment : Fragment(R.layout.fragment_mainscreen){

    private var appDatabase: AppDatabase? = null
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding:FragmentMainscreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainscreenBinding.bind(view)

        appDatabase = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "database-name"
        ).build()

        binding.exit.setOnClickListener { requireActivity().finish() }

        binding.listLikedJokes.setOnClickListener {
            val bundle = Bundle()
            val listJokesFragment = ListJokesFragment()
            listJokesFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.main_layout, listJokesFragment, null)
                .addToBackStack(null)
                .commit()
        }

        binding.liked.setOnClickListener { appDatabase?.let {
            viewModel.addItem(it, binding.joke.text.toString())
        }
        }
    }
}