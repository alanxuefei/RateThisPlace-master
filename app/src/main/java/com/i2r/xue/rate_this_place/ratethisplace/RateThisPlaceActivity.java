package com.i2r.xue.rate_this_place.ratethisplace;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.myrewards.AsyncTaskGetDataToMyRewardBar;
import com.i2r.xue.rate_this_place.utility.globalvariable;

public class RateThisPlaceActivity  extends TabActivity implements TabHost.OnTabChangeListener, LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_this_place);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec spec1=tabHost.newTabSpec("Tab 1");
        spec1.setIndicator("Rating");
        Intent startBasicIntent = new Intent();

        spec1.setContent(startBasicIntent.setClass(this, RateThisPlaceRatingActivity.class));

        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator("Activity");
        Intent startDetailIntent = new Intent();

        spec2.setContent(startDetailIntent.setClass(this, RateThisPlaceActivityActivity.class));

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);

        if (globalvariable.isRating_rated){
            tabHost.setCurrentTab(1);
        }


        LocationManager lm=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);



    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
        //  Intent intent = new Intent(this, SensorListenerService.class);
        // stopService(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rate_this_place, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabChanged(String tabId) {

    }

    public void ReturnButton(View v) {
     //   Log.i("test", "returen");
        super.onBackPressed();

    }


    @Override
    public void onLocationChanged(Location location) {
        globalvariable.thelocation=location;
      //  Log.i("ratelocation", "getlocation" + globalvariable.thelocation.getLatitude() + " " + globalvariable.thelocation.getLongitude());
        ((TextView)findViewById(R.id.textView_promote)).setText(" The current location is successfully obtained by " + location.getProvider() );
        ((ProgressBar)findViewById(R.id.progressBar_promote)).setVisibility(View.GONE);

        new AsyncTaskGetDataToMyRewardBar(this,(ProgressBar)findViewById(R.id.progressBar_promote),(TextView)findViewById(R.id.textView_promote),
                (ImageView)findViewById(R.id.imageView_rewards1),
                (ImageView)findViewById(R.id.imageView_rewards2),(ImageView)findViewById(R.id.imageView_rewards3),
                (ImageView)findViewById(R.id.imageView_rewards4),(ProgressBar)findViewById(R.id.progressBar_rewards),(TextView)findViewById(R.id.textView_Rewards)).execute();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }



}

