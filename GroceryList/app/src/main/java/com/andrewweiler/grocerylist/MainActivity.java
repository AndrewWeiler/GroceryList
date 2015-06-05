package com.andrewweiler.grocerylist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //Layout
        RelativeLayout groceryList = new RelativeLayout(this);
        groceryList.setBackgroundColor(Color.parseColor("#457D64"));


        //Button Controls
        Button addButton = new Button(this);
        addButton.setText("Add Item");
        addButton.setTextColor(Color.WHITE);
        addButton.setBackgroundColor(Color.parseColor("#590105"));

        //Button Params
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        //Button Rules
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);


        //Store
        EditText store = new EditText(this);

        //Item
        EditText item = new EditText(this);


        //Widget Id
        addButton.setId(1);
        item.setId(2);
        store.setId(3);



        //Item Params
        RelativeLayout.LayoutParams itemParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        //Item Rules
        itemParams.addRule(RelativeLayout.ABOVE, addButton.getId());
        itemParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        itemParams.setMargins(0,0,0,100);


        //Store Params
        RelativeLayout.LayoutParams storeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        //Store Rules
        storeParams.addRule(RelativeLayout.ABOVE, item.getId());
        storeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        storeParams.setMargins(0,0,0,50);

        Resources r = getResources();
        int pix = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300,
                r.getDisplayMetrics());

        store.setWidth(pix);
        item.setWidth(pix);


        //Add Layout
        groceryList.addView(addButton, buttonParams);
        groceryList.addView(store, storeParams);
        groceryList.addView(item, itemParams);


        //Set Layout
        setContentView(groceryList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
