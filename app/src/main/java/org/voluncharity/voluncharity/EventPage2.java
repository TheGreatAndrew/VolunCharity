package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventPage2 extends AppCompatActivity {
    DrawerLayout drawerLayout;

    Button regiEvent;
    int flag = 0;
    int presentPoints;
    Globals g = Globals.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page2);
        drawerLayout = findViewById(R.id.drawer_layout);
        regiEvent = (Button) findViewById(R.id.btn_event_register);
        g.setPresentPoints(BuildConfig.VERSION_CODE);
    }

    public void MenuClick(View view){
        HomePageActivity.openMenu(drawerLayout);
    }

    public void ClickProfilePic(View view){
        HomePageActivity.directActivity(this,Profile.class);

    }

    public void ClickEvent(View view){
        HomePageActivity.directActivity(this,HomePageActivity.class);

    }
    public void ClickProfile(View view){
        HomePageActivity.directActivity(this,Profile.class);
    }
    public void ClickSettings(View view){

        HomePageActivity.directActivity(this,Settings.class);
    }

    public void ClickLogout(View view){
        HomePageActivity.logout(this);
    }

    public void RegisterEvent(View view){
        int id = view.getId();

        switch (id){
            case R.id.btn_event_register:
                if(flag == 0) {
                    Toast.makeText(this, "Registered the Event +10 points", Toast.LENGTH_SHORT).show();
                    regiEvent.setText("Unregister Event");
                    flag = 1;
                    presentPoints = g.getPresentPoints();
                    presentPoints = presentPoints + 10;
                    g.setPresentPoints(presentPoints);
                }
                else if (flag == 1){
                    Toast.makeText(this, "UnRegistered the Event -10 points", Toast.LENGTH_SHORT).show();
                    regiEvent.setText("Register Event");
                    flag = 0;
                    presentPoints = g.getPresentPoints();
                    presentPoints = presentPoints - 10;
                    g.setPresentPoints(presentPoints);
                }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        HomePageActivity.closeMenu(drawerLayout);
    }
}