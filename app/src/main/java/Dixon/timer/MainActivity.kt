package Dixon.timer

import Dixon.Timer.Timer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {


    lateinit var timeDisplay : TextView
    lateinit var timeButton : Button
    lateinit var aveButton : Button
    lateinit var diff: TextView
    lateinit var ave: TextView
    val timing = Timer()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeButton = findViewById(R.id.time_button)
        aveButton = findViewById(R.id.average)
        timeDisplay = findViewById(R.id.time_display)
        val current = timing.getTime()
        timeDisplay.text = current
        diff = findViewById(R.id.time_diff)
        ave= findViewById(R.id.time_ave)
        timeButton.setOnClickListener{handleTime()}
        aveButton.setOnClickListener{handleAverage()}

        }
    @RequiresApi(Build.VERSION_CODES.O)
    fun handleTime(){
        val newTime = timing.getTime()
        val timeDiff = timing.calculate()
        timeDisplay.text = newTime
        diff.text = timeDiff
    }

    fun handleAverage(){
        val averageTime = timing.average()
        ave.text = averageTime
    }



    }