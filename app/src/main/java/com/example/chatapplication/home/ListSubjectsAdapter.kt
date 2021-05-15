package com.example.chatapplication.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.R
import com.example.chatapplication.models.Subject
import kotlinx.android.synthetic.main.card_subjects.view.*
import kotlinx.android.synthetic.main.card_users.view.*

class ListSubjectsAdapter (var context: Context, var subjects:ArrayList<Subject>,var navController: NavController):RecyclerView.Adapter<ListSubjectsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSubjectsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_subjects,parent,false))
    }

    override fun onBindViewHolder(holder: ListSubjectsAdapter.ViewHolder, position: Int) {
        var subject=subjects[position]
        holder.itemView.tv_subject_name.text=subject.name
        if(subject.className!=null){
            holder.itemView.tv_class_name.visibility=View.VISIBLE
            holder.itemView.tv_class_name.text=subject.className
        }
        holder.itemView.setOnClickListener {
            var action=FragmentListSubjectsDirections.actionFragmentListSubjectsToFragmentOpenSubject(subject.name!!,subject.id!!)
            navController.navigate(action)
        }

        holder.itemView.iv_chat.setOnClickListener {
//            var action=FragmentListSubjectsDirections.actionFragmentListSubjectsToFragmentOpenSubject(subject.name!!,subject.id!!)
//            navController.navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}