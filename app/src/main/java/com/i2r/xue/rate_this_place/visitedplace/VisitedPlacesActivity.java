package com.i2r.xue.rate_this_place.visitedplace;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.utility.Constants;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.i2r.xue.rate_this_place.R.layout.activity_visited_places);
       // ((TextView)findViewById(R.id.location0)).setText(Constants.Locations[0]);
        ((TextView)findViewById(R.id.location1)).setText(Constants.Locations[1]);
        ((TextView)findViewById(R.id.location2)).setText(Constants.Locations[2]);
        ((TextView)findViewById(R.id.location3)).setText(Constants.Locations[3]);
        ((TextView)findViewById(R.id.location4)).setText(Constants.Locations[4]);
        ((TextView)findViewById(R.id.location5)).setText(Constants.Locations[5]);
        ((TextView)findViewById(R.id.location6)).setText(Constants.Locations[6]);

        buildTableRow0();
        buildTableRow1();
        buildTableRow2();
        buildTableRow3();
        buildTableRow4();
        buildTableRow5();
        buildTableRow6();


        //TableLayout t= (TableLayout)findViewById(R.id.AllTableRow0);



       // t.removeView(t1);
       // TableRow t6= (TableRow)findViewById(R.id.AllTableRow6);
       // t6.setVisibility(View.INVISIBLE);


        //  readDB(VisitedPlaceList);

      //  HumanActivityListView = (ListView) findViewById(com.i2r.alan.rate_this_place.R.id.listView_HumanActivity);

        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
      //  arrayAdapter = new ArrayAdapter(this, com.i2r.alan.rate_this_place.R.layout.visitedplaces_list_eachrow, com.i2r.alan.rate_this_place.R.id.thetheTextView, VisitedPlaceList.toArray());
     //   HumanActivityListView.setAdapter(arrayAdapter);

      //  HumanActivityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       //     @Override
         //   public void onItemClick(AdapterView<?> a, View v, int position, long id) {
       //         clickthelistview(a, v, position, id);
      //      }
      //  });

    }

    public void addRATINGButton(ViewGroup vi, final String LocationName) {

        Button bt = new Button(this,null, android.R.attr.buttonStyleSmall);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vi.addView(bt);
        bt.setText("RATING   ");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplication(), RateThisPlaceRatingFromVisitedPlacesActivity.class);
                intent0.putExtra("From", LocationName);
             //   Log.i("VisitedPlace", LocationName + "RatingStatus");

                startActivity(intent0);

            }
        });
    }

    public void addACTIVITYButton(ViewGroup vi, final String LocationName) {

        Button bt = new Button(this,null, android.R.attr.buttonStyleSmall);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vi.addView(bt);
        bt.setText("ACTIVITY");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplication(), RateThisPlaceActivityFromVisitedPlaceActivity.class);
                intent0.putExtra("From", LocationName);
                //Log.i("VisitedPlace", LocationName + "RatingStatus"); finish();
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

        bt.setText(activities.replace("_","\n"));
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

   /* public void clickthelistview(AdapterView<?> a, View v, int position, long id) {

       String value = (String)a.getItemAtPosition(position);
        Log.i(HumanActivityTAG, value);

        Intent startRatingIntent = new Intent(this,  RateThisPlaceFromVistitedplaceActivity.class);
        startActivity(startRatingIntent);


    }*/

    public void ReturnButton(View v) {
       // Log.i("test", "return");
        super.onBackPressed();
    }


  /*  public void readDB(List<String> VisitedPlaceList) {

        DBHelper mDbHelper = new DBHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                DBContract.FeedEntry.COLUMN_NAME_DATE,
                DBContract.FeedEntry.COLUMN_NAME_TIME,
                DBContract.FeedEntry.COLUMN_LOCATION_LONGITUDE,
                DBContract.FeedEntry.COLUMN_LOCATION_LATITUDE,
                DBContract.FeedEntry.COLUMN_LOCATION_NAME
        };

// How you want the results sorted in the resulting Cursor


        Cursor c = db.query(
                DBContract.FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );


        Boolean rowExists=c.moveToFirst();
        if (rowExists){
            while (!c.isLast()) {
                String vLOCATION_NAME = c.getString(
                        c.getColumnIndexOrThrow(DBContract.FeedEntry.COLUMN_LOCATION_NAME)
                );

                String vTIME = c.getString(
                        c.getColumnIndexOrThrow(DBContract.FeedEntry.COLUMN_NAME_TIME)
                );

                VisitedPlaceList.add(vTIME + "\r\n" + vLOCATION_NAME);
                c.moveToNext();

            }
        }

    }


*/
    public void buildTableRow0() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "DateTime", "NA")).split("\n");
        Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TextView)findViewById(R.id.location0_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow0)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA"));
               // ((TableRow)findViewById(R.id.AllTableRow0)).setBackgroundColor(Color.GREEN);
               // ((TextView)findViewById(R.id.location0)).setBackgroundColor(Color.GREEN);
               // ((TextView)findViewById(R.id.location0_time)).setBackgroundColor(Color.GREEN);
              //  ((LinearLayout)findViewById(R.id.TableRow0)).setBackgroundColor(Color.GREEN);

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
          //  ((TextView)findViewById(R.id.location0_time)).setText("Wait for your visit");


                ((TableRow)findViewById(R.id.AllTableRow0)).setVisibility(TableRow.GONE);



        };
    }

    public void buildTableRow1() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "DateTime", "NA")).split("\n");
Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow1)).setVisibility(TableRow.GONE);

        };
    }

    public void buildTableRow2() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "DateTime", "NA")).split("\n");
        Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow2)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow3() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "DateTime", "NA")).split("\n");
        Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow3)).setVisibility(TableRow.GONE);

        };
    }

    public void buildTableRow4() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow4)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow5() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow5)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow6() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "DateTime", "NA")).split("\n");

        if  (datearray[0].equals(currentDate)){
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
            ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }
}
