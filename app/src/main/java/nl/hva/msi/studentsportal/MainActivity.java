package nl.hva.msi.studentsportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<PortalReminder> portalReminderList = new ArrayList<>();
    PortalReminderAdapter portalReminderAdapter;
    RecyclerView recyclerView;
    public final static String CONST_URL = "constUrl";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.addPortal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        recyclerView = findViewById(R.id.recyclerViewMain);
        portalReminderAdapter = new PortalReminderAdapter(portalReminderList, this);
        recyclerView.setAdapter(portalReminderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        portalReminderList.add(new PortalReminder("Facebook", "http://www.facebook.com"));
        portalReminderList.add(new PortalReminder("Facebook2", "www.facebook.com"));
    }

    public void updateUI() {
        if (portalReminderAdapter == null) {
            portalReminderAdapter = new PortalReminderAdapter(portalReminderList, this);
            recyclerView.setAdapter(portalReminderAdapter);
        } else {
            portalReminderAdapter.notifyDataSetChanged();
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("OnActivityResul ", "I am here;");
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String url = data.getStringExtra("url");
                String title = data.getStringExtra("title");
                Log.d("URL: ",url);
                Log.d("Title: ",title);
                addToList(url, title);
                updateUI();
            }
            if (resultCode == Activity.RESULT_CANCELED){

            }
        }
    }


    private void addToList(String url, String title) {
        portalReminderList.add(new PortalReminder(title, url));
        Snackbar.make(findViewById(R.id.activity_main), "Portal added: " + title, Snackbar.LENGTH_SHORT ).show();
    }


}
