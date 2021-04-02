package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        drawerLayout = findViewById(R.id.drawer_layout);
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

        HomePageActivity.closeMenu(drawerLayout);
    }

    public void ClickLogout(View view){
        HomePageActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        HomePageActivity.closeMenu(drawerLayout);
    }
}