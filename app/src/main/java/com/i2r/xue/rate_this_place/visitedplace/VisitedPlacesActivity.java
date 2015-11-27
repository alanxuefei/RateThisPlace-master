package com.i2r.xue.rate_this_place.visitedplace;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.i2r.xue.rate_this_place.MainActivity;
import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.mapview.MapsActivity;
import com.i2r.xue.rate_this_place.utility.Constants;
import com.i2r.xue.rate_this_place.utility.globalvariable;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class VisitedPlacesActivity extends AppCompatActivity {

    protected static final String HumanActivityTAG = "HumanActivity";

    // JSONArray mJsonArray = new JSONArray(o.toString().replace("[],",""));

    List<String> VisitedPlaceList = new ArrayList<>();

    private ListView HumanActivityListView;
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(com.i2r.xue.rate_this_place.R.layout.activity_visited_places);


        buildTableRow0();
        buildTableRow1();
        buildTableRow2();
        buildTableRow3();
        buildTableRow4();
        buildTableRow5();
        buildTableRow6();
        buildTableRow7();
        buildTableRow8();
        buildTableRow9();
        buildTableRow10();
        buildTableRow11();
        buildTableRow12();
        buildTableRow13();
        buildTableRow14();
        buildTableRow15();
        buildTableRow16();
        buildTableRow17();
        buildTableRow18();
        buildTableRow19();
      /*  buildTableRow20();
        buildTableRow21();
        buildTableRow22();
        buildTableRow23();
        buildTableRow24();
        buildTableRow25();
        buildTableRow26();
        buildTableRow27();
        buildTableRow28();
        buildTableRow29();
        buildTableRow30();
        buildTableRow31();
        buildTableRow32();
        buildTableRow33();
        buildTableRow34();
        buildTableRow35();
        buildTableRow36();
        buildTableRow37();
        buildTableRow38();
        buildTableRow39();
        buildTableRow40();
        buildTableRow41();
        buildTableRow42();
        buildTableRow43();
        buildTableRow44();
        buildTableRow45();
        buildTableRow46();
        buildTableRow47();
        buildTableRow48();
        buildTableRow49();*/

        //Non-Special Places
        buildTableRow100();
        buildTableRow101();
        buildTableRow102();
        buildTableRow103();
        buildTableRow104();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void addRATINGButton(ViewGroup vi, final String LocationName) {

        Button bt = new Button(this,null, android.R.attr.buttonStyleSmall);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final int index= Integer.parseInt(LocationName.replace("Location", ""));

        vi.addView(bt);
        bt.setText("RATING   ");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplication(), RateThisPlaceRatingFromVisitedPlacesActivity.class);
                intent0.putExtra("From", LocationName);
                Log.i("VisitedPlace", LocationName + "RatingStatus");

                if (index > 100) {
                    Location targetLocation = new Location("");//provider name is unecessary
                    targetLocation.setLatitude(Double.parseDouble(((getApplication().getSharedPreferences("VisitedPlaceStatus", getApplication().MODE_PRIVATE).getString("VisitedPlaceStatusLatitude" + index, "NA")))));
                    targetLocation.setLongitude(Double.parseDouble(((getApplication().getSharedPreferences("VisitedPlaceStatus", getApplication().MODE_PRIVATE).getString("VisitedPlaceStatusLongitude" + index, "NA")))));//your coords of course
                    globalvariable.setThelocation(targetLocation);
                }


                finish();
                startActivity(intent0);

            }
        });
    }

    public void addACTIVITYButton(ViewGroup vi, final String LocationName) {

        Button bt = new Button(this,null, android.R.attr.buttonStyleSmall);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final int index= Integer.parseInt(LocationName.replace("Location", ""));
        vi.addView(bt);
        bt.setText("ACTIVITY");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplication(), RateThisPlaceActivityFromVisitedPlaceActivity.class);
                intent0.putExtra("From", LocationName);
                //Log.i("VisitedPlace", LocationName + "RatingStatus"); finish();

                if (index > 100) {
                    Location targetLocation = new Location("");//provider name is unecessary
                    targetLocation.setLatitude(Double.parseDouble(((getApplication().getSharedPreferences("VisitedPlaceStatus", getApplication().MODE_PRIVATE).getString("VisitedPlaceStatusLatitude" + index, "NA")))));
                    targetLocation.setLongitude(Double.parseDouble(((getApplication().getSharedPreferences("VisitedPlaceStatus", getApplication().MODE_PRIVATE).getString("VisitedPlaceStatusLongitude" + index, "NA")))));//your coords of course
                    globalvariable.setThelocation(targetLocation);
                }
                finish();
                startActivity(intent0);
            }
        });
    }

    public void addStar(ViewGroup vi, String number) {

        //  Log.i("VisitedPlace", vi.toString() + " number");

        TextView bt = new TextView(this);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        vi.addView(bt);
        String star="";

        star="★ "+number;

        bt.setText(star);
    }

    public void addACTIVITYcontent(ViewGroup vi, String activities) {

        //  Log.i("VisitedPlace", vi.toString() + " number");

        TextView bt = new TextView(this);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        vi.addView(bt);

        bt.setText(activities.replace("_", "\n"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.i2r.xue.rate_this_place.R.menu.menu_human_activity_diary, menu);
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
        // Log.i("test", "return");

        startActivity(new Intent(getApplication(), MainActivity.class));
    }

    public void buildTableRow0() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "DateTime", "NA")).split("\n");
        Log.i("datearray", datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow0)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location0_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow0)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow0)), Constants.Locations[0]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow0)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow0)), Constants.Locations[0]);
            }

        }
        else{




        };
    }

    public void buildTableRow1() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "DateTime", "NA")).split("\n");
        Log.i("datearray", datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow1)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location1_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow1)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow1)), Constants.Locations[1]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow1)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow1)), Constants.Locations[1]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location1_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow1)).setVisibility(TableRow.GONE);

        };
    }

    public void buildTableRow2() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "DateTime", "NA")).split("\n");
        Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow2)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location2_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow2)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow2)), Constants.Locations[2]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow2)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow2)), Constants.Locations[2]);
            }

        }
        else{
            //((TextView)findViewById(R.id.location2_time)).setText("Wait for your visit");
            //((TableRow)findViewById(R.id.AllTableRow2)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow3() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "DateTime", "NA")).split("\n");
        Log.i("datearray", datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow3)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location3_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow3)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow3)), Constants.Locations[3]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow3)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow3)), Constants.Locations[3]);
            }

        }
        else{
            //((TextView)findViewById(R.id.location3_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow3)).setVisibility(TableRow.GONE);

        };
    }

    public void buildTableRow4() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow4)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location4_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow4)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow4)), Constants.Locations[4]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow4)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow4)), Constants.Locations[4]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location4_time)).setText("Wait for your visit");
            //((TableRow)findViewById(R.id.AllTableRow4)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow5() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow5)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location5_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow5)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow5)), Constants.Locations[5]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow5)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow5)), Constants.Locations[5]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location5_time)).setText("Wait for your visit");
            //((TableRow)findViewById(R.id.AllTableRow5)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow6() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location6_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow6)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow6)), Constants.Locations[6]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow6)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow6)), Constants.Locations[6]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }





    public void buildTableRow7() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow7)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location7_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow7)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow7)), Constants.Locations[7]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow7)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[7] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow7)), Constants.Locations[7]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location7_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow7)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow8() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow8)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location8_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow8)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow8)), Constants.Locations[8]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow8)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[8] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow8)), Constants.Locations[8]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location8_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow8)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow9() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow9)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location9_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow9)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow9)), Constants.Locations[9]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow9)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[9] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow9)), Constants.Locations[9]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location9_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow9)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow10() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow10)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location10_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow10)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow10)), Constants.Locations[10]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow10)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[10] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow10)), Constants.Locations[10]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location10_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow10)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow11() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow11)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location11_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow11)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow11)), Constants.Locations[11]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow11)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[11] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow11)), Constants.Locations[11]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location11_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow11)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow12() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow12)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location12_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow12)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow12)), Constants.Locations[12]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow12)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[12] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow12)), Constants.Locations[12]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location12_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow12)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow13() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow13)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location13_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow13)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow13)), Constants.Locations[13]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow13)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[13] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow13)), Constants.Locations[13]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location13_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow13)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow14() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow14)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location14_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow14)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow14)), Constants.Locations[14]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow14)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[14] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow14)), Constants.Locations[14]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location14_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow14)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow15() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow15)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location15_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow15)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow15)), Constants.Locations[15]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow15)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[15] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow15)), Constants.Locations[15]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location15_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow15)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow16() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow16)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location16_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow16)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow16)), Constants.Locations[16]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow16)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[16] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow16)), Constants.Locations[16]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location16_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow16)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow17() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow17)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location17_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow17)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow17)), Constants.Locations[17]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow17)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[17] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow17)), Constants.Locations[17]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location17_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow17)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow18() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow18)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location18_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow18)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow18)), Constants.Locations[18]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow18)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[18] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow18)), Constants.Locations[18]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location18_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow18)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow19() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow19)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location19_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow19)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow19)), Constants.Locations[19]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow19)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[19] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow19)), Constants.Locations[19]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location19_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow19)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow20() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow20)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location20_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow20)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow20)), Constants.Locations[20]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow20)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[20] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow20)), Constants.Locations[20]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location20_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow20)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow21() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow21)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location21_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow21)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow21)), Constants.Locations[21]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow21)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[21] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow21)), Constants.Locations[21]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location21_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow21)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow22() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow22)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location22_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow22)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow22)), Constants.Locations[22]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow22)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[22] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow22)), Constants.Locations[22]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location22_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow22)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow23() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow23)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location23_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow23)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow23)), Constants.Locations[23]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow23)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[23] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow23)), Constants.Locations[23]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location23_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow23)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow24() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow24)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location24_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow24)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow24)), Constants.Locations[24]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow24)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[24] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow24)), Constants.Locations[24]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location24_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow24)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow25() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow25)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location25_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow25)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow25)), Constants.Locations[25]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow25)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[25] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow25)), Constants.Locations[25]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location25_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow25)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow26() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow26)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location26_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow26)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow26)), Constants.Locations[26]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow26)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[26] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow26)), Constants.Locations[26]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location26_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow26)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow27() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow27)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location27_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow27)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow27)), Constants.Locations[27]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow27)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[27] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow27)), Constants.Locations[27]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location27_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow27)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow28() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow28)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location28_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow28)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow28)), Constants.Locations[28]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow28)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[28] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow28)), Constants.Locations[28]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location28_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow28)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow29() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow29)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location29_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow29)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow29)), Constants.Locations[29]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow29)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[29] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow29)), Constants.Locations[29]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location29_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow29)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow30() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow30)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location30_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow30)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow30)), Constants.Locations[30]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow30)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[30] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow30)), Constants.Locations[30]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location30_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow30)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow31() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow31)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location31_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow31)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow31)), Constants.Locations[31]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow31)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[31] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow31)), Constants.Locations[31]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location31_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow31)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow32() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow32)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location32_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow32)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow32)), Constants.Locations[32]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow32)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[32] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow32)), Constants.Locations[32]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location32_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow32)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow33() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow33)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location33_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow33)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow33)), Constants.Locations[33]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow33)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[33] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow33)), Constants.Locations[33]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location33_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow33)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow34() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow34)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location34_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow34)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow34)), Constants.Locations[34]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow34)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[34] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow34)), Constants.Locations[34]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location34_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow34)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow35() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow35)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location35_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow35)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow35)), Constants.Locations[35]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow35)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[35] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow35)), Constants.Locations[35]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location35_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow35)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow36() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow36)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location36_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow36)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow36)), Constants.Locations[36]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow36)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[36] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow36)), Constants.Locations[36]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location36_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow36)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow37() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow37)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location37_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow37)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow37)), Constants.Locations[37]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow37)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[37] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow37)), Constants.Locations[37]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location37_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow37)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow38() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow38)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location38_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow38)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow38)), Constants.Locations[38]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow38)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[38] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow38)), Constants.Locations[38]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location38_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow38)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow39() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow39)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location39_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow39)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow39)), Constants.Locations[39]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow39)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[39] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow39)), Constants.Locations[39]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location39_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow39)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow40() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow40)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location40_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow40)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow40)), Constants.Locations[40]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow40)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[40] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow40)), Constants.Locations[40]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location40_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow40)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow41() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow41)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location41_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow41)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow41)), Constants.Locations[41]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow41)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[41] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow41)), Constants.Locations[41]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location41_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow41)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow42() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow42)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location42_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow42)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow42)), Constants.Locations[42]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow42)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[42] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow42)), Constants.Locations[42]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location42_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow42)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow43() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow43)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location43_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow43)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow43)), Constants.Locations[43]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow43)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[43] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow43)), Constants.Locations[43]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location43_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow43)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow44() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow44)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location44_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow44)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow44)), Constants.Locations[44]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow44)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[44] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow44)), Constants.Locations[44]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location44_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow44)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow45() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow45)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location45_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow45)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow45)), Constants.Locations[45]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow45)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[45] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow45)), Constants.Locations[45]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location45_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow45)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow46() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow46)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location46_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow46)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow46)), Constants.Locations[46]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow46)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[46] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow46)), Constants.Locations[46]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location46_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow46)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow47() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow47)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location47_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow47)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow47)), Constants.Locations[47]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow47)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[47] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow47)), Constants.Locations[47]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location47_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow47)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow48() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow48)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location48_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow48)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow48)), Constants.Locations[48]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow48)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[48] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow48)), Constants.Locations[48]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location48_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow48)).setVisibility(TableRow.GONE);
        };
    }




    public void buildTableRow49() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow49)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location49_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow49)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "RatingStatus", "NA"));

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow49)), Constants.Locations[49]);
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow49)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[49] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow49)), Constants.Locations[49]);
            }

        }
        else{
            // ((TextView)findViewById(R.id.location49_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow49)).setVisibility(TableRow.GONE);
        };
    }









    public void startmap(int i) {
        Location targetLocation = new Location("");//provider name is unecessary
        targetLocation.setLatitude(Constants.Lat[i]);
        targetLocation.setLongitude(Constants.Lng[i]);//your coords of course
        globalvariable.setThelocation(targetLocation);
        startActivity(new Intent(this, MapsActivity.class));
    }



    public void startmap2(int i) {
        Location targetLocation = new Location("");//provider name is unecessary
        targetLocation.setLatitude(Double.parseDouble(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude10"+Integer.toString(i), "NA")))));
        targetLocation.setLongitude(Double.parseDouble(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude10"+Integer.toString(i), "NA")))));
        globalvariable.setThelocation(targetLocation);
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void clickTableRow0Image(View v) {
        startmap(0);
    }

    public void clickTableRow1Image(View v) {
        startmap(1);
    }


    public void clickTableRow2Image(View v) {
        startmap(2);
    }


    public void clickTableRow3Image(View v) {
        startmap(3);
    }


    public void clickTableRow4Image(View v) {
        startmap(4);
    }

    public void clickTableRow5Image(View v) {
        startmap(5);
    }

    public void clickTableRow6Image(View v) {
        startmap(6);
    }

    public void clickTableRow7Image(View v) {
        startmap(7);
    }
    public void clickTableRow8Image(View v) {
        startmap(8);
    }
    public void clickTableRow9Image(View v) {
        startmap(9);
    }

    public void clickTableRow10Image(View v) {
        startmap(10);
    }
    public void clickTableRow11Image(View v) {
        startmap(11);
    }


    public void clickTableRow12Image(View v) {
        startmap(12);
    }


    public void clickTableRow13Image(View v) {
        startmap(13);
    }


    public void clickTableRow14Image(View v) {
        startmap(14);
    }

    public void clickTableRow15Image(View v) {
        startmap(15);
    }

    public void clickTableRow16Image(View v) {
        startmap(16);
    }

    public void clickTableRow17Image(View v) {
        startmap(17);
    }
    public void clickTableRow18Image(View v) {
        startmap(18);
    }
    public void clickTableRow19Image(View v) {
        startmap(19);
    }

    public void clickTableRow20Image(View v) {
        startmap(20);
    }


    public void clickTableRow31Image(View v) {
        startmap(31);
    }


    public void clickTableRow32Image(View v) {
        startmap(32);
    }


    public void clickTableRow33Image(View v) {
        startmap(33);
    }


    public void clickTableRow34Image(View v) {
        startmap(34);
    }

    public void clickTableRow35Image(View v) {
        startmap(35);
    }

    public void clickTableRow36Image(View v) {
        startmap(36);
    }

    public void clickTableRow37Image(View v) {
        startmap(37);
    }
    public void clickTableRow38Image(View v) {
        startmap(38);
    }
    public void clickTableRow39Image(View v) {
        startmap(39);
    }

    public void clickTableRow40Image(View v) {
        startmap(40);
    }

    public void clickTableRow41Image(View v) {
        startmap(41);
    }
    public void clickTableRow42Image(View v) {
        startmap(42);
    }
    public void clickTableRow43Image(View v) {
        startmap(43);
    }
    public void clickTableRow44Image(View v) {
        startmap(44);
    }
    public void clickTableRow45Image(View v) {
        startmap(45);
    }
    public void clickTableRow46Image(View v) {
        startmap(46);
    }
    public void clickTableRow47Image(View v) {
        startmap(47);
    }

    public void clickTableRow48Image(View v) {
        startmap(48);
    }
    public void clickTableRow49Image(View v) {
        startmap(49);
    }
    public void clickTableRow50Image(View v) {

        startmap(50);
    }


    public void ClickTableRow100Location(View v) {
        Log.i("123", "123");
        startmap2(0);
    }


    public void ClickTableRow101Location(View v) {

        startmap2(1);
    }


    public void ClickTableRow102Location(View v) {

        startmap2(2);
    }


    public void ClickTableRow103Location(View v) {

        startmap2(3);
    }


    public void ClickTableRow104Location(View v) {

        startmap2(4);
    }

    public void buildTableRow100() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra0DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow100)).setVisibility(TableRow.VISIBLE);
            /*((TextView)findViewById(R.id.location100)).setText(
                    ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude0", "NA")))+"\n"+
                            ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude0", "NA"))));*/
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen0"+ ".png";
            ((ImageView)findViewById(R.id.location100_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));
            ((TextView) findViewById(R.id.location100_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra0DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location100RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow100)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location100RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow100)), "Location100");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location100ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow100)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location100ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow100)), "Location100");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow101() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra1DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow101)).setVisibility(TableRow.VISIBLE);
            /*((TextView)findViewById(R.id.location101)).setText(
                    ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude0", "NA")))+"\n"+
                            ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude0", "NA"))));*/
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen0"+ ".png";
            ((ImageView)findViewById(R.id.location101_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));
            ((TextView) findViewById(R.id.location101_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra1DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location101RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow101)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location101RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow101)), "Location101");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location101ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow101)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location101ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow101)), "Location101");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow102() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra2DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow102)).setVisibility(TableRow.VISIBLE);
            /*((TextView)findViewById(R.id.location102)).setText(
                    ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude0", "NA")))+"\n"+
                            ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude0", "NA"))));*/
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen0"+ ".png";
            ((ImageView)findViewById(R.id.location102_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));
            ((TextView) findViewById(R.id.location102_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra2DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location102RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow102)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location102RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow102)), "Location102");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location102ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow102)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location102ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow102)), "Location102");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow103() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra3DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow103)).setVisibility(TableRow.VISIBLE);
            /*((TextView)findViewById(R.id.location103)).setText(
                    ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude0", "NA")))+"\n"+
                            ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude0", "NA"))));*/
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen0"+ ".png";
            ((ImageView)findViewById(R.id.location103_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));
            ((TextView) findViewById(R.id.location103_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra3DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location103RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow103)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location103RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow103)), "Location103");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location103ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow103)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location103ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow103)), "Location103");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow104() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra4DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow104)).setVisibility(TableRow.VISIBLE);
            /*((TextView)findViewById(R.id.location104)).setText(
                    ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLongitude0", "NA")))+"\n"+
                            ((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusLatitude0", "NA"))));*/
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen0"+ ".png";
            ((ImageView)findViewById(R.id.location104_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));
            ((TextView) findViewById(R.id.location104_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra4DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location104RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow104)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location104RatingStatus", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow104)), "Location104");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location104ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow104)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("Location104ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow104)), "Location104");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow105() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra5DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow105)).setVisibility(TableRow.VISIBLE);
            String Image_Path= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/" + "MapScreen5"+ ".png";
            ((ImageView)findViewById(R.id.location105_imageView)).setImageBitmap(BitmapFactory.decodeFile(Image_Path));

            ((TextView)findViewById(R.id.location105_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra5DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating5", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow105)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating5", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow105)), "Location105");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity5", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow105)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity5", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow105)), "Location105");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }
}
