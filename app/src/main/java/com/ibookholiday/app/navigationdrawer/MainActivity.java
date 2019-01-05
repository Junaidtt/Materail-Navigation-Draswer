package com.ibookholiday.app.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        //added toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //drawer initialisation
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();



    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        switch (id){

            case R.id.indox_id:
                Toast.makeText(getApplicationContext(),"Inbox",Toast.LENGTH_LONG).show();
                break;
            case R.id.starred_id:
                Toast.makeText(getApplicationContext(),"Starred",Toast.LENGTH_LONG).show();
                break;
            case R.id.send_email_id:
                Toast.makeText(getApplicationContext(),"Send Email",Toast.LENGTH_LONG).show();
                break;
            case R.id.draft_id:
                Toast.makeText(getApplicationContext(),"Draft",Toast.LENGTH_LONG).show();
                break;
            case R.id.allmail_id:
                Toast.makeText(getApplicationContext(),"All Mail",Toast.LENGTH_LONG).show();
                break;
            case  R.id.trash_id:
                Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_LONG).show();
                break;
            case R.id.spam_id:
                Toast.makeText(getApplicationContext(),"Spam",Toast.LENGTH_LONG).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
