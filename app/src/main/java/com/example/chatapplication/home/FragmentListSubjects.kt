package com.example.chatapplication.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chatapplication.R
import com.example.chatapplication.SharedPreferenceManager
import com.example.chatapplication.UserData
import com.example.chatapplication.models.Subject
import kotlinx.android.synthetic.main.dialog_add_class.view.*
import kotlinx.android.synthetic.main.fragment_list_subjects.*


class FragmentListSubjects:Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_subjects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var subjects=ArrayList<Subject>()

        if(SharedPreferenceManager(requireContext()).user?.userType=="Student") {
            subjects.add(Subject().apply {
                id = 1
                name = "Python"
            })

            subjects.add(Subject().apply {
                id = 2
                name = "DAA"
            })
            subjects.add(Subject().apply {
                id = 3
                name = "WT"
            })
            subjects.add(Subject().apply {
                id = 4
                name = "Maths"
            })
            subjects.add(Subject().apply {
                id = 5
                name = "OS"
            })
        }else{


            subjects.add(Subject().apply {
                id = 2
                name = "DAA"
              className="CSE-B"
            })
            subjects.add(Subject().apply {
                id = 3
                name = "WT"
                className="CSE-A"
            })
            subjects.add(Subject().apply {
                id = 5
                name = "OS"
                className="CSE-B"
            })
        }
        rv_subjects.adapter=ListSubjectsAdapter(requireContext(), subjects, findNavController())
        rv_subjects.layoutManager=GridLayoutManager(requireContext(), 2)
        iv_add_class.setOnClickListener {
            showAddClassPopup()
        }


    }
    fun showAddClassPopup(){
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        val customLayout: View = layoutInflater.inflate(R.layout.dialog_add_class, null)
        if(SharedPreferenceManager(requireContext()).user?.userType=="Teacher"){
            customLayout.til_add_class.visibility=View.GONE
            customLayout.til_create_class.visibility=View.VISIBLE
        }
        alertDialog.setView(customLayout)
        if(SharedPreferenceManager(requireContext()).user?.userType=="Teacher"){
            alertDialog.setPositiveButton("Create", DialogInterface.OnClickListener { dialog, which -> // send data from the AlertDialog to the Activity

            })
        }else {
            alertDialog.setPositiveButton("ADD", DialogInterface.OnClickListener { dialog, which -> // send data from the AlertDialog to the Activity

            })
        }
        alertDialog.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, which -> // send data from the AlertDialog to the Activity
        })
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
}