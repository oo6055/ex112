package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The type Main activity.
 *
 *  @author Ori Ofek <oriofek106@gmail.com> 23/11/2020
 *  @version 1.0
 *  @since 23/11/2020
 *  sort description:
 *  this is the activty the implement the exericse that my teacher gave...
 */
public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    int counter;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);
        counter = 0;
        
        getData();
    }

    private void getData() {
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        String str = settings.getString("str","");
        counter = settings.getInt("counter",0);
        et.setText(str);
        tv.setText(String.valueOf(counter));
    }

    /**
     * count.
     * short dec: add 1 to the counter and present it in the tv
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
    public void count(View view) {
        counter++;
        tv.setText(String.valueOf(counter));
    }

    /**
     * reset.
     * short dec: reset the counter and the tv and save the new data
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
    public void reset(View view) {
        counter = 0;
        et.setText("");
        tv.setText(String.valueOf(counter));
        save();

    }

     /**
     * save.
     * short dec: dava the data in the SharedPreferences file
     *
     * <p>
     *
     * @return	none
     */
    private void save() {
        SharedPreferences.Editor editor = getSharedPreferences("PREFS_NAME", MODE_PRIVATE).edit();
        editor.putString("str", et.getText().toString());
        editor.putInt("counter",counter);
        editor.commit();
    }

    /**
     * exit.
     * short dec: save and exit from the app
     *
     * <p>
     *      View view
     * @param	view - see which button pressed
     * @return	none
     */
    public void exit(View view) {
        save();
        finish();
    }

    /**
     * onCreateContextMenu
     * Short description.
     * onCreateContextMenu listener use for the ContextMenu
     * <p>
     *     ContextMenu menu
     *     View v
     *     ContextMenu.ContextMenuInfo menuInfo
     *
     * @param  menu - the object,v - the item that selected ,menuInfo - the info
     * @return	true if it success
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.generalmenu, menu);
        return true;
    }

    /**
     * onOptionsItemSelected
     * Short description.
     * what happen if an item was selected
     * <p>
     *     MenuItem item
     *
     * @param  item - the menuItem
     * @return	true if it success
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String whatClicked = (String) item.getTitle();

        if(whatClicked.equals("credits"))
        {
            si = new Intent(this, credits.class);
            startActivity(si);
        }

        return  true;
    }
}