package com.abdul.cogapp2.whowroteit;


import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBookTask extends AsyncTask<String,Void,String> {


    private TextView mTitleText;
    private TextView mAuthorText;

    public FetchBookTask(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = mTitleText;
        this.mAuthorText = mAuthorText;
    }

    @Override
    protected String doInBackground(String... bookname) {
        return NetworkUtils.getBookInfo(bookname[0]);    }

    @Override
    protected void onPostExecute(String jsonString) { //bookJSONString
        super.onPostExecute(jsonString);
    }
}
