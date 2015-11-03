package com.i2r.xue.rate_this_place.myrewards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
// android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.i2r.xue.rate_this_place.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MyRewardActivity extends AppCompatActivity {

    protected static final String MyRewardActivity_TAG = "MyRewardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.i2r.xue.rate_this_place.R.layout.activity_my_reward);
        JSONObject JsonGenerator_basicrating = new JSONObject();
        try {
            JsonGenerator_basicrating.put("UserID", this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new AsyncTaskGetDataToMyReward(this,(TextView)findViewById(R.id.textView_Rewards),(ProgressBar)findViewById(R.id.progressBar_locationname)).execute();

        ((TextView)findViewById(R.id.textView_UserID)).setText("\nUserID: \n"+this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null)+"");
        //("display_name").setTitle(this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.i2r.xue.rate_this_place.R.menu.menu_my_reward, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.i2r.xue.rate_this_place.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ReturnButton(View v) {
        super.onBackPressed();
       // Log.i(MyRewardActivity_TAG, "return");

    }
}
