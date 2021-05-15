package com.example.chatapplication.openSubject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.R
import com.example.chatapplication.models.Subject
import kotlinx.android.synthetic.main.card_document_thumbnail.view.*
import kotlinx.android.synthetic.main.card_subjects.view.*
import kotlinx.android.synthetic.main.card_users.view.*

class ListMaterialsAdapter (var context: Context, var materials:ArrayList<String>):RecyclerView.Adapter<ListMaterialsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMaterialsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_document_thumbnail,parent,false))
    }

    override fun onBindViewHolder(holder: ListMaterialsAdapter.ViewHolder, position: Int) {
        var subject=materials[position]
        holder.itemView.doc_name.text=subject
    }

    override fun getItemCount(): Int {
        return materials.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}