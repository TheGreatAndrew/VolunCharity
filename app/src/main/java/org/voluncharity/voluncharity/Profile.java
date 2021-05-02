package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static org.voluncharity.voluncharity.HomePageActivity.directActivity;

public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView NameId;
    Button editProButtonId;
    EditText editNameId;
    Button achievementID;

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

    public void achievementOnClick(View view){
        Toast.makeText(this, "You Have Achievement on Next Event", Toast.LENGTH_SHORT).show();
        directActivity(this,Achievement.class);
    }


    public void NextEventOnClick(View view){
        Toast.makeText(this, "You Have click on Next Event", Toast.LENGTH_SHORT).show();
    }

    public void EventHistoryOnClick(View view){
        Toast.makeText(this, "You Have click on History", Toast.LENGTH_SHORT).show();;
    }
    public void FavOrgOnClick(View view){
        Toast.makeText(this, "You Have click on Favorite", Toast.LENGTH_SHORT).show();
    }
    public void DonationHistoryOnClick(View view){
        Toast.makeText(this, "You Have click on Donation History", Toast.LENGTH_SHORT).show();
    }

    public void StoreOnClick(View view){
         Toast.makeText(this, "You Have click on Store", Toast.LENGTH_SHORT).show();
    }

    public void RewardsOnClick(View view){
        Toast.makeText(this, "You Have click on Rewards", Toast.LENGTH_SHORT).show();
    }

    public void LogoutOnClick(View view){
        //System.out.println("Inside Log out Click Button");
        //directActivity(this,LoginFragment.class);
        HomePageActivity.logout(this);
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