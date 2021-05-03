package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class EventPage1 extends AppCompatActivity {
    public static final String INCREAES_POINTS = "org.voluncharity.voluncharity.increase";
    public static final String DECREAES_POINTS = "org.voluncharity.voluncharity.decrease";

    DrawerLayout drawerLayout;

    Button regiEvent;
    int flag = 0;
    int increase = 0;
    int decrease = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page1);
        drawerLayout = findViewById(R.id.drawer_layout);
        regiEvent = (Button) findViewById(R.id.btn_event_register);
        regiEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                RegisterEvent(view);
                openProfile();
            }
        });
        }
    public void openProfile(){
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra(INCREAES_POINTS, increase);
        intent.putExtra(DECREAES_POINTS, decrease);
        startActivity(intent);
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
                    increase = 10;
                }
                else if(flag == 1){
                    Toast.makeText(this, "UnRegistered the Event -10 points", Toast.LENGTH_SHORT).show();
                    regiEvent.setText("Register Event");
                    flag = 0;
                    decrease = -10;
                }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        HomePageActivity.closeMenu(drawerLayout);
    }
}