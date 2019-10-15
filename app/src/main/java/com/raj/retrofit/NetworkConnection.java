package com.raj.retrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkConnection extends AsyncTask<Void, Void, Void> {
    POSTCardService postCardService;
    GETCardService getCardService;


    public NetworkConnection() {

    }

    @Override
    protected Void doInBackground(Void... voids) {

        ///////////////////// GET ////////////////////////////
        final Message msg = new Message();


        if (this.getCardService == null) {
            this.getCardService = new GETCardService();
        }

        getCardService
                .getAPI()
                .getResults()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.v("post","Val");


                        final Bundle b = new Bundle();
                        b.putString("KEY", (response.body()).toString());
                        msg.setData(b);




                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v("post","Val");
                    }
                });
        //////////////////// GET END///////////////////////////////



        /////////////////// POST /////////////////////////

//            if (this.postCardService == null) {
//                this.postCardService = new POSTCardService();
//            }
//
//            postCardService
//                    .getAPI()
//                    .createuser("raj", "consul")
//                    .enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            Log.v("post","Val");
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.v("post","Val");
//                        }
//                    });

        /////////////////// POST END /////////////////////////


        return null;
    }

}