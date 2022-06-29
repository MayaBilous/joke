package com.maya.joke.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maya.joke.R
import com.maya.joke.entiti.JokesItem

class CustomAdapter(
        val onDeleteClickAction: (JokesItem) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

        private val jokesItem = mutableListOf<JokesItem>()

        fun addData(item: List<JokesItem>){
                jokesItem.clear()
                jokesItem.addAll(item)
                notifyDataSetChanged()
        }

        fun deleteData(item:JokesItem){
                jokesItem.remove(item)
                notifyDataSetChanged()
        }

        override fun getItemCount() = jokesItem.size

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
              val view = LayoutInflater.from(viewGroup.context)
                      .inflate(R.layout.recyclerview_item, viewGroup, false)
                return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bind(jokesItem[position])
        }

        inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
                private val name: TextView = view.findViewById(R.id.joke)
                private val deleteButton: Button = view.findViewById(R.id.deleteButton)

                fun bind(jokesItem: JokesItem){
                        name.text = jokesItem.name
                        deleteButton.setOnClickListener { onDeleteClickAction(jokesItem) }
                }
        }
}