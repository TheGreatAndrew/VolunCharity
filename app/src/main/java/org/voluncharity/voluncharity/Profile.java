package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static org.voluncharity.voluncharity.HomePageActivity.directActivity;

public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView NameId;
    Button editProButtonId;
    EditText editNameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        drawerLayout = findViewById(R.id.drawer_layout);

        editNameId = (EditText) findViewById(R.id.editNameId);
        NameId= (TextView) findViewById(R.id.NameId);
        editProButtonId = (Button) findViewById(R.id.editProButtonId);

    }
    public void MenuClick(View view){
        HomePageActivity.openMenu(drawerLayout);
    }

    public void ClickProfilePic(View view){
        HomePageActivity.closeMenu(drawerLayout);

    }

    public void EditProButtonOnClick(View view){
        System.out.println("In Next Event Button");
        if(this.editProButtonId.getText().equals("Edit")){ //toggle to save
                this.editProButtonId.setText("Save");
                //this.editNameId.setClickable(true);
                this.editNameId.setEnabled(true);
                this.editNameId.setText("");
                this.editNameId.setVisibility(View.VISIBLE);

                this.NameId.setEnabled(false);
                this.NameId.setVisibility(View.INVISIBLE);
        }else if(this.editProButtonId.getText().equals("Save")){
                this.editProButtonId.setText("Edit");
                //this.editNameId.setClickable(false);
                this.NameId.setText(this.editNameId.getText());
                this.NameId.setEnabled(true);

                this.NameId.setVisibility(View.VISIBLE);
                this.editNameId.setEnabled(false);
                this.editNameId.setVisibility(View.INVISIBLE);
        }
    }


    public void NextEventOnClick(View view){
        System.out.println("In Next Event Button");
    }

    public void EventHistoryOnClick(View view){
        System.out.println("In Event History Button");
    }
    public void FavOrgOnClick(View view){
        System.out.println("In Fav Org. Button");
    }
    public void DonationHistoryOnClick(View view){
        System.out.println("In Donation History Button");
    }

    public void StoreOnClick(View view){
        System.out.println("Inside Store Click Button");
    }

    public void RewardsOnClick(View view){
        System.out.println("Inside Rewards Click Button");
    }

    public void LogoutOnClick(View view){
        System.out.println("Inside Log out Click Button");
        directActivity(this,LoginFragment.class);
    }



    public void ClickEvent(View view){
        directActivity(this,HomePageActivity.class);

    }
    public void ClickProfile(View view){
        HomePageActivity.closeMenu(drawerLayout);
    }
    public void ClickSettings(View view){
       directActivity(this,Settings.class);
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