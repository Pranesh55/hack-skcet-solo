package com.example.chatapplication.openSubject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapplication.R
import com.example.chatapplication.SharedPreferenceManager
import kotlinx.android.synthetic.main.fragment_materials.*

class MaterialsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_materials,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var names=ArrayList<String>()
        names.addAll(arrayListOf("Mod1.docx","Mod2.docx","Mod3.ppt"))
        rv_materials.adapter=ListMaterialsAdapter(requireContext(),names)
        rv_materials.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        if(SharedPreferenceManager(requireContext()).user!!.userType=="Teacher"){
            iv_add_class.visibility=View.VISIBLE
        }
    }
}