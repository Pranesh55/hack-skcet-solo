package com.example.chatapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class UsersAdapter(var context:Context,var users:ArrayList<String?>) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_users,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var user=users[position]
        holder.userName.text=user
    }

    override fun getItemCount(): Int {
        return  users.size
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var userName=itemView.findViewById<TextView>(R.id.tv_name)
    }
}