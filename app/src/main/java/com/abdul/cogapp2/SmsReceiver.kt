package com.abdul.cogapp2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context,"sms from cognizant",Toast.LENGTH_SHORT).show()
       /* var manager : SmsManager = SmsManager.getDefault()
        manager.sendTextMessage("5556",null,"from 5554",null,null)*/
    }
}