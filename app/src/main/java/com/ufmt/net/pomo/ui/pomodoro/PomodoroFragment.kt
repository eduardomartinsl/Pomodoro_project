package com.ufmt.net.pomo.ui.pomodoro

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ufmt.net.pomo.R
import kotlinx.android.synthetic.main.fragment_pomodoro.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Suppress("NAME_SHADOWING")
class PomodoroFragment : Fragment() {


    val minute:Long = 6000
    val millisInFuture:Long =(minute * 250)
    val countDownInterval:Long = 1000


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pomodoro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var i = 0
        progressBar.progress = i

        //60 segundos (1 minuto)

        textViewCronometro.text = "On"

//        timer(millisInFuture, countDownInterval).start()

    }

    private fun timer(millisInFuture:Long,countDownInterval:Long): CountDownTimer{

        return object: CountDownTimer(millisInFuture, countDownInterval){

            override fun onTick(millisUntilFinished: Long){
                val timeRemaining = timeString(millisUntilFinished)
                textViewCronometro.text = timeRemaining
            }

            override fun onFinish() {
                //nothing Yet
            }
        }
    }

    private fun timeString(millisUntilFinished: Long): String{
        val millisUntilFinished = millisUntilFinished

        val totalSeconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished).toDouble()
        val seconds = (totalSeconds % 60).toInt()

        val minutes = Math.floor(totalSeconds / 60).toInt()
        return String.format(
                Locale.getDefault(),
//                "%02d sec",
                "%02d:%02d",
                minutes, seconds
        )
    }

    override fun onPause() {
        super.onPause()
        textViewCronometro.text = "On"

//        timer(millisInFuture, countDownInterval).start()

    }


}