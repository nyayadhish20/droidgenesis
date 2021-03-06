package com.nyayadhish.droidgenesis.samplemvpactivity;

import android.util.Log;

import com.nyayadhish.droidgenesis.lib.retrofit.CustomRetroCallbacks;
import com.nyayadhish.droidgenesis.model.Resp;

import retrofit2.Call;

/**
 * Created by Nikhil Nyayadhish on 25 Mar 2019 at 10:19.
 */
public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View mView;
    private static final String TAG = NewsPresenter.class.getSimpleName();
    Call<Resp> mCall;

    public NewsPresenter(NewsContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {
        Log.i("STOpping new api", "onDestroy: ");
        mCall.cancel();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        Log.i("STOpping new api", "onStop: ");
        mCall.cancel();
    }

    @Override
    public void callingPresenterFromView() {

       mCall =  mView.getAPIComponent().getRetroService().getBaseUrl().getAllNews("https://newsapi.org/v2/everything?q=bitcoin&from=2019-04-21&sortBy=publishedAt&apiKey=300e401e143940bc91c1d344186b36ea");
        mCall.enqueue(new CustomRetroCallbacks<Resp>() {
            @Override
            protected void onSuccess(Resp response) {
                mView.onNewsFetched(response);
            }

            @Override
            protected void onFailure(String generalErrorMsg, String systemErrorMsg) {
                mView.faliure();

            }
        });


        /*CustomVolleyRequest mRequest = new CustomVolleyRequest(Request.Method.GET
                , "https://newsapi.org/v2/everything?q=bitcoin&from=2019-04-21&sortBy=publishedAt&apiKey=300e401e143940bc91c1d344186b36ea"
                , new CustomHashMap().new Builder().add("key","2").build()
                , new CustomVolleyRequest.VolleyCallBack() {
            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.i(TAG, "onSuccess: "+ jsonObject.toString());
                Resp resp =  mView.getAPIComponent().getGson().fromJson(jsonObject.toString(), Resp.class);
                if (resp != null)
                    mView.onNewsFetched(resp);
            }

            @Override
            public void onError(int errorCode, String message) {
                mView.faliure();
            }

            @Override
            public void onFailed() {

            }

            @Override
            public void onUnauthorisedAccess() {

            }
        });
        mView.getAPIComponent().getServerData().addToRequestQueue(mRequest,this);
*/


    }
}
