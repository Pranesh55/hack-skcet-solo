package com.example.chatapplication.openSubject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapplication.R
import com.example.chatapplication.SharedPreferenceManager
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(SharedPreferenceManager(requireContext()).user!!.userType=="Teacher"){
            iv_add_class.visibility=View.VISIBLE
        }
        var quizes=ArrayList<String>()
        quizes.addAll(arrayListOf("Quiz 1","Quiz 2","Quiz 3","Quiz 4","Quiz 5"))
        rv_quiz.adapter=ListMaterialsAdapter(requireContext(),quizes)
        rv_quiz.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}