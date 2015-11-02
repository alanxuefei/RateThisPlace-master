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
        buildTableRow10();
        buildTableRow11();
        buildTableRow12();
        buildTableRow13();
        buildTableRow14();

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
            ((TableRow)findViewById(R.id.AllTableRow0)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location0_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow0)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "RatingStatus", "NA"));
               // ((TableRow)findViewById(R.id.AllTableRow0)).setBackgroundColor(Color.GREEN);
               // ((TextView)findViewById(R.id.location0)).setBackgroundColor(Color.GREEN);
               // ((TextView)findViewById(R.id.location0_time)).setBackgroundColor(Color.GREEN);
              //  ((LinearLayout)findViewById(R.id.TableRow0)).setBackgroundColor(Color.GREEN);

            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow0)), Constants.Locations[0]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow0)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[0] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow0)), Constants.Locations[0]+ "ActivityStatus");
            }

        }
        else{
          //  ((TextView)findViewById(R.id.location0_time)).setText("Wait for your visit");


              //  ((TableRow)findViewById(R.id.AllTableRow0)).setVisibility(TableRow.GONE);



        };
    }

    public void buildTableRow1() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "DateTime", "NA")).split("\n");
Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow1)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location1_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow1)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow1)), Constants.Locations[1]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow1)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[1] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow1)), Constants.Locations[1]+ "ActivityStatus");
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
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow2)), Constants.Locations[2]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow2)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[2] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow2)), Constants.Locations[2]+ "ActivityStatus");
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
        Log.i("datearray",datearray[0]);
        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow3)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location3_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "RatingStatus", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow3)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "RatingStatus", "NA"));


            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow3)), Constants.Locations[3]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow3)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[3] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow3)), Constants.Locations[3]+ "ActivityStatus");
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
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow4)), Constants.Locations[4]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow4)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[4] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow4)), Constants.Locations[4]+ "ActivityStatus");
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
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow5)), Constants.Locations[5]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow5)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[5] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow5)), Constants.Locations[5]+ "ActivityStatus");
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
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow6)), Constants.Locations[6]+"RatingStatus");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "ActivityStatus", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow6)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString(Constants.Locations[6] + "ActivityStatus", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow6)), Constants.Locations[6]+ "ActivityStatus");
            }

        }
        else{
           // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
           // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }


















    public void buildTableRow10() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra0DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow10)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location10_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra0DateTime", "NA")).replace("_", "\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating0", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow10)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating0", "NA"));
            }
            else{
                 addRATINGButton(((ViewGroup) findViewById(R.id.TableRow10)), "VisitedPlaceStatusExtraRating0");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity0", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow10)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity0", "NA"));
            }
            else{
                  addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow10)), "VisitedPlaceStatusExtraActivity0");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow11() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra1DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow11)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location11_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra1DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating1", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow11)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating1", "NA"));
            }
            else{
                addRATINGButton(((ViewGroup) findViewById(R.id.TableRow11)), "VisitedPlaceStatusExtraRating1");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity1", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow11)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity1", "NA"));
            }
            else{
                addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow11)), "VisitedPlaceStatusExtraActivity1");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow12() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra2DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow12)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location12_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra2DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating2", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow12)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating2", "NA"));
            }
            else{
                   addRATINGButton(((ViewGroup) findViewById(R.id.TableRow12)), "VisitedPlaceStatusExtraRating2");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity2", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow12)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity2", "NA"));
            }
            else{
                  addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow12)), "VisitedPlaceStatusExtraActivity2");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }



    public void buildTableRow13() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra3DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow13)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location13_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra3DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating3", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow13)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating3", "NA"));
            }
            else{
                   addRATINGButton(((ViewGroup) findViewById(R.id.TableRow13)), "VisitedPlaceStatusExtraRating3");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity3", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow13)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity2", "NA"));
            }
            else{
                   addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow13)), "VisitedPlaceStatusExtraActivity3");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }


    public void buildTableRow14() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra4DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow14)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location14_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra4DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating4", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow14)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating4", "NA"));
            }
            else{
                 addRATINGButton(((ViewGroup) findViewById(R.id.TableRow14)), "VisitedPlaceStatusExtraRating4");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity4", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow14)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity2", "NA"));
            }
            else{
                 addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow14)),"VisitedPlaceStatusExtraActivity4");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }

    public void buildTableRow15() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        String datearray[]=(this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra5DateTime", "NA")).split("_");

        if  (datearray[0].equals(currentDate)){
            ((TableRow)findViewById(R.id.AllTableRow15)).setVisibility(TableRow.VISIBLE);
            ((TextView)findViewById(R.id.location15_time)).setText(((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtra5DateTime", "NA")).replace("_","\n")));
            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating5", "NA")).equals("NA"))){
                addStar(((ViewGroup) findViewById(R.id.TableRow15)), this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraRating5", "NA"));
            }
            else{
                   addRATINGButton(((ViewGroup) findViewById(R.id.TableRow15)), "VisitedPlaceStatusExtraRating5");
            }

            if (!((this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity5", "NA")).equals("NA"))){
                addACTIVITYcontent(((ViewGroup) findViewById(R.id.TableRow15)),  this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraActivity5", "NA"));
            }
            else{
                   addACTIVITYButton(((ViewGroup) findViewById(R.id.TableRow15)), "VisitedPlaceStatusExtraActivity5");
            }

        }
        else{
            // ((TextView)findViewById(R.id.location6_time)).setText("Wait for your visit");
            // ((TableRow)findViewById(R.id.AllTableRow6)).setVisibility(TableRow.GONE);
        };
    }
}
