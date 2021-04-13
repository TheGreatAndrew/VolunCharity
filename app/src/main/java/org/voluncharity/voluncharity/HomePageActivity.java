package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

   public void MenuClick(View view){
       openMenu(drawerLayout);
   }

    public static void openMenu(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickEvent(View view){
        closeMenu(drawerLayout);
    }

    public static void closeMenu(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }


    public void ClickProfilePic(View view){
        directActivity(this,Profile.class);
    }

    public void ClickProfile(View view){
        directActivity(this,Profile.class);
    }

    public void ClickSettings(View view){
        directActivity(this,Settings.class);
    }
    public void CarWashClick(View view){
        directActivity(this,EventPage1.class);
    }
    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(final Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Do you want to Logout ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();

                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();


    }

    public static void directActivity(Activity activity,Class newClass) {

        Intent intent = new Intent(activity, newClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        closeMenu(drawerLayout);
    }



}