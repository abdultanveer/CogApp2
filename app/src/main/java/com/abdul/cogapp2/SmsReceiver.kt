package com.abdul.cogapp2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.widget.Toast
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class SmsReceiver : BroadcastReceiver() {
    var TAG = SmsReceiver::class.java.simpleName
    var SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context,"sms from cognizant",Toast.LENGTH_SHORT).show()

       /* var manager : SmsManager = SmsManager.getDefault()
        manager.sendTextMessage("5556",null,"from 5554",null,null)*/

        Log.i(TAG, "Intent recieved: " + intent.action)

        if (intent.action === SMS_RECEIVED) {
            val bundle = intent.extras
            if (bundle != null) {
                val pdus = bundle["pdus"] as Array<Any>?
                val messages: Array<SmsMessage?> = arrayOfNulls<SmsMessage>(pdus!!.size)
                for (i in pdus!!.indices) {
                    messages[i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
                }
                if (messages.size > -1) {
                    Log.i(TAG, "Message recieved: " + messages[0]!!.getMessageBody()
                    +"--  senders ph no --"+ messages[0]!!.originatingAddress)
                }
            }
        }
    }
}

/*
Log.i(TAG, "Intent recieved: " + intent.getAction());

if (intent.getAction() == SMS_RECEIVED) {
    Bundle bundle = intent.getExtras();
    if (bundle != null) {
        Object[] pdus = (Object[])bundle.get("pdus");
        final SmsMessage[] messages = new SmsMessage[pdus.length];
        for (int i = 0; i < pdus.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
        }
        if (messages.length > -1) {
            Log.i(TAG, "Message recieved: " + messages[0].getMessageBody());
        }
    }
}*/
