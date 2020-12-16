package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ex112.R;

/**
 * The type Credits activity
 *
 *  @author Ori Ofek <oriofek106@gmail.com> 23/11/2020
 *  @version 1.0
 *  @since 23/11/2020
 *  sort description:
 *  this is the credits activty that says thanks to the man that created the application
 *
 */
public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
     * @return	true if it succed
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String whatClicked = (String) item.getTitle();

        if(whatClicked.equals("Main Activity"))
        {
            finish();
        }

        return  true;
    }
}