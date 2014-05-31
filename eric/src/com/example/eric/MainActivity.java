package com.example.eric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	//give an intent -- this is an action
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//edit_message is an id first introduced by layout file
    	//EditText is what you input at the box
    	//R is uner /gen, and it's a resource definition file (memory address)
    	//findViewById -
    	//Finds a view that was identified by the id attribute from the XML 
    	//that was processed in onCreate(Bundle).
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	//what's the message? it's 
    	String message = editText.getText().toString();
    	//Add extended data to the intent. 
    	//EXTRA_MESSAGE is from a package
    	intent.putExtra(EXTRA_MESSAGE, message);
    	//start the 2nd activity
    	startActivity(intent);
    }

}
