package com.example.chatapplication.openSubject

import android.content.Context
import android.util.Log
import androidx.fragment.app.*


class ViewPagerAdapter(private val context: Context, fm: FragmentManager, NoOfTabs:Int, TabTitles:ArrayList<String>)
    : FragmentPagerAdapter(fm){
    var noOftabs=NoOfTabs

    private var TAB_TITLES=TabTitles
    override fun getItem(position: Int): Fragment {

        Log.d("ViewPagerAdapter","no of tabs=$noOftabs")
        Log.d("ViewPagerAdapter", "get item position = ${position.toString()}")
        var fragment = Fragment()
        if (position == 0) {
            fragment =
                MaterialsFragment()
            return fragment
        }else if(position==1){
            fragment =
                HomeWorkFragment()
            return fragment
        }
        else if(position==2){
            fragment =
                AssignmentsFragment()
            return fragment
        }
        else{

            fragment =
                QuizFragment()
            return fragment

        }
    }


    override fun getPageTitle(position: Int): String{
        Log.d("ViewPagerAdapter",position.toString())
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return noOftabs
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

}
