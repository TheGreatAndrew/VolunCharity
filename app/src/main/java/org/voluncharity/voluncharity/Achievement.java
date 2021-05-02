package org.voluncharity.voluncharity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static org.voluncharity.voluncharity.HomePageActivity.directActivity;

public class Achievement extends AppCompatActivity {
    DrawerLayout drawerLayout;
    RecyclerView RCId;

    Button backId;

    private String VName[] = {
            "Registered", "Followed First Charity", "Completed First Event", "Two of A kind",
            "5th Event Completed"
    };

    private String SUrl[] = {
        "ribbon_01_blue", "ribbon_01_red",
            "trophy_01", "trophy_03_gold", "trophy_04"
    };

    int maxLength = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        drawerLayout = findViewById(R.id.drawer_layout);

        RCId = findViewById(R.id.RCId);
        this.RCId.setHasFixedSize(true);
        RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(),2);
        this.RCId.setLayoutManager(layout);

        ArrayList<AndroidVersion> androidVersionList = setList();
        RAdapter adapter = new RAdapter(getApplicationContext(), androidVersionList);
        this.RCId.setAdapter(adapter);

    }

    public void backOnClick(View view){
        Toast.makeText(this, "You Have click on Back Event", Toast.LENGTH_SHORT).show();
        directActivity(this,Profile.class);

    }


    private ArrayList<AndroidVersion> setList(){
        ArrayList<AndroidVersion> list = new ArrayList<>();
        for(int i=0; i< this.VName.length; i++){
            AndroidVersion av = new AndroidVersion();
            av.setVersionName(this.VName[i]);
            av.setImageURL(this.SUrl[i]);
            list.add(av);
        }

        return list;
    }


    @Override
    protected void onPause() {
        super.onPause();
        HomePageActivity.closeMenu(drawerLayout);
    }
}
