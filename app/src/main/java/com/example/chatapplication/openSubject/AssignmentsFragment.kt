package com.example.chatapplication.openSubject

import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.chatapplication.R
import com.example.chatapplication.SharedPreferenceManager
import kotlinx.android.synthetic.main.fragment_home_work.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*

class AssignmentsFragment:Fragment() {
    private lateinit var countDownTimer:CountDownTimer
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_assignments,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(SharedPreferenceManager(requireContext()).user!!.userType=="Teacher"){
            tv_todo_heading.text="Completed"
            tv_todo_heading.setTextColor(requireActivity().resources.getColor(R.color.green))
            tv_completed_heading.text="Yet To Complete"
            tv_completed_heading.setTextColor(requireActivity().resources.getColor(R.color.grey))
            tv_timer1.text="60"
            tv_timer2.text="60"
            tv_timer3.text="50"
            tv_timer4.text="0"
            tv_timer5.text="0"
            tv_time_left_heading.text="Count"
        }
        var formatter = SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        formatter.setLenient(false);
        var milliseconds:Long=0L

        var endTime = "15.05.2021, 15:05:36"

        var endDate:Date?=null
        try {
            endDate = formatter.parse(endTime);
            milliseconds = endDate!!.getTime();

        } catch (e: ParseException) {
            e.printStackTrace();
            Log.e("Timer","error occured")
        }

        var startTime = System.currentTimeMillis();

        var diff = milliseconds - startTime;

        var mCountDownTimer=object : CountDownTimer(20000,1000){
            override fun onTick(p0: Long) {
                startTime -= 1;
                var serverUptimeSeconds =(p0 - startTime) / 1000;

                var  daysLeft = String.format("%d", serverUptimeSeconds / 86400);
//                txtViewDays.setText(daysLeft);

                var hoursLeft = String.format("%d", (serverUptimeSeconds % 86400) / 3600);
//                txtViewHours.setText(hoursLeft);

                var minutesLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) / 60);

//                txtViewMinutes.setText(minutesLeft);

                var  secondsLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) % 60);
//                txtViewSecond.setText(secondsLeft);
                var md=""
                var mh=""
                var mm=""
                var ms=""
                if(daysLeft.toLong()<10.toLong()){
                    md="${0}"+daysLeft
                }
                if(hoursLeft.toLong()<10.toLong()){
                    mh="${0}"+hoursLeft
                }
                if(minutesLeft.toLong()<10.toLong()){
                    mm="${0}"+minutesLeft
                }
                if(secondsLeft.toLong()<10.toLong()){
                    ms="${0}"+secondsLeft
                }
                var time=md+":"+mh+":"+mm+":"+ms
                tv_timer1.text=time
            }

            override fun onFinish() {

            }
        }
        if(SharedPreferenceManager(requireContext()).user!!.userType!="Teacher") {
            printDifferenceDateForHours("15/05/2021 24:00:00", tv_timer1)
            printDifferenceDateForHours("16/05/2021 24:00:00", tv_timer2)
            tv_timer3.text = "-"
            tv_timer4.text = "-"
            tv_timer5.text = "-"
        }



    }

    fun printDifferenceDateForHours( endDateDay:String,timerView:TextView ) {

        val currentTime = Calendar.getInstance().time
//        val endDateDay = "13/05/2021 24:00:00"
        val format1 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss",Locale.getDefault())
        val endDate = format1.parse(endDateDay)

        //milliseconds
        var different = endDate.time - currentTime.time
        countDownTimer = object : CountDownTimer(different, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60
                val daysInMilli = hoursInMilli * 24

                val elapsedDays = diff / daysInMilli
                diff %= daysInMilli

                val elapsedHours = diff / hoursInMilli
                diff %= hoursInMilli

                val elapsedMinutes = diff / minutesInMilli
                diff %= minutesInMilli

                val elapsedSeconds = diff / secondsInMilli

                var md=""
                var mh=""
                var mm=""
                var ms=""
                if(elapsedDays.toLong()<10.toLong()){
                    md="${0}"+elapsedDays
                }else
                    md=elapsedDays.toString()
                if(elapsedHours.toLong()<10.toLong()){
                    mh="${0}"+elapsedHours
                }else
                    mh=elapsedHours.toString()
                if(elapsedMinutes.toLong()<10.toLong()){
                    mm="${0}"+elapsedMinutes
                }else
                    mm=elapsedMinutes.toString()
                if(elapsedSeconds.toLong()<10.toLong()){
                    ms="${0}"+elapsedSeconds
                }else
                    ms=elapsedSeconds.toString()
                var time=md+": "+mh+": "+mm+": "+ms
                timerView.text = time
            }

            override fun onFinish() {
//                txt_timeleft.text = "done!"
            }
        }.start()
    }

}
