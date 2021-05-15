package com.example.chatapplication.openSubject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chatapplication.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_open_subject.*

class FragmentOpenSubject:Fragment() {
    var subjectId=0
    var name=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_open_subject, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tabLayout=tabLayout
        var tabNames=ArrayList<String>()
        tabNames.addAll(arrayListOf("PPT","Home Work","Assignments","Quiz"))
        tabLayout.addTab(tabLayout.newTab().setText("PPT"));
        tabLayout.addTab(tabLayout.newTab().setText("Home Work"));
        tabLayout.addTab(tabLayout.newTab().setText("Assignments"));
        tabLayout.addTab(tabLayout.newTab().setText("Quiz"));
        viewPager.adapter=ViewPagerAdapter(requireContext(),requireFragmentManager(),4,tabNames)
        tabLayout.setupWithViewPager(viewPager)
        arguments?.let {
            var args= FragmentOpenSubjectArgs.fromBundle(it)
            subjectId=args.id
            name=args.name
        }
        requireActivity().toolbar.title=name

//        try {
//            AppSettings.init(args)
//            Thumbnailer.start()
//            val `in` = File("/inputFile.docx")
//            if (`in`.exists()) {
//                val candidate = ThumbnailCandidate(`in`, "unique_code")
//                Thumbnailer.createThumbnail(candidate, object : ThumbnailListener() {
//                    fun onThumbnailReady(hash: String?, thumbnail: File) {
//                        System.out.println("FILE created in : " + thumbnail.getAbsolutePath())
//                    }
//
//                    fun onThumbnailFailed(hash: String?, message: String?, code: Int) {}
//                })
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        } catch (e: ThumbnailerException) {
//            e.printStackTrace()
//        }
    }
}