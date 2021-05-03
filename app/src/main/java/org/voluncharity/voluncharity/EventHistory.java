package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import org.voluncharity.voluncharity.databinding.ActivityEventHistoryBinding;

public class EventHistory extends AppCompatActivity {

    DrawerLayout drawerLayout;

    ActivityEventHistoryBinding binding;
    String[] descriptionData = {"Registered","Approved","Finished"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventHistoryBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_event_history);
        setContentView(binding.getRoot());
        drawerLayout = findViewById(R.id.drawer_layout);

        binding.progressBar1.setLabels(descriptionData)
                .setBarColorIndicator(Color.BLACK)
                .setProgressColorIndicator(getResources().getColor(R.color.colorAccent))
                .setLabelColorIndicator(getResources().getColor(R.color.colorAccent))
                .drawView();

        binding.progressBar2.setLabels(descriptionData)
                .setBarColorIndicator(Color.BLACK)
                .setProgressColorIndicator(getResources().getColor(R.color.colorAccent))
                .setLabelColorIndicator(getResources().getColor(R.color.colorAccent))
                .drawView();

        binding.progressBar3.setLabels(descriptionData)
                .setBarColorIndicator(Color.BLACK)
                .setProgressColorIndicator(getResources().getColor(R.color.colorAccent))
                .setLabelColorIndicator(getResources().getColor(R.color.colorAccent))
                .drawView();

        binding.progressBar1.setCompletedPosition(0);
        binding.progressBar2.setCompletedPosition(1);
        binding.progressBar3.setCompletedPosition(2);




    }

    public void CarWashClick(View view){
        HomePageActivity.directActivity(this,EventPage1.class);
    }
    public void SanitizerClick(View view){
        HomePageActivity.directActivity(this,EventPage2.class);
    }
    public void MountainClick(View view){
        HomePageActivity.directActivity(this,EventPage3.class);
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

}