package com.example.mad_practical5_21012011126

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonBrowse: Button = findViewById(R.id.button_browse)
        var editURL: EditText = findViewById(R.id.editTextURL)

        buttonBrowse.setOnClickListener{
            Browse(editURL.text.toString())
        }

        // Call Buttons
        var callButton: Button = findViewById(R.id.buttoncall)
        var mobileNumber: EditText = findViewById(R.id.editTextText3)

        callButton.setOnClickListener{
            call(mobileNumber.text.toString())
        }

        // for call logs
        var callLogButton: Button = findViewById(R.id.button5)
        callLogButton.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also{startActivity(it)}
        }

        // for Gellary
        var galleryButton : Button = findViewById(R.id.button7)
        galleryButton.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
        }

        //for Camera
        var cameraButton: Button = findViewById(R.id.button8)
        cameraButton.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }

        //for Alarm
        var alarmButton : Button = findViewById(R.id.button9)
        alarmButton.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }

    }



    private fun implicitIntent() {}

    private fun Browse(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }

    private fun call(number:String){
        Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)).also { startActivity(it) }
    }







}