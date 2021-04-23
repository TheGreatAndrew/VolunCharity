package org.voluncharity.voluncharity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sanAntonio = new LatLng( 29.61195349608321, -98.6132773231262);
        MarkerOptions marker = new MarkerOptions()
                .position(sanAntonio)
                .title("Toy Donation");
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 29.556, -98.4))
                .title("Clothes Charity"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 29.622, -98.5))
                .title("Free Book Everyday"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 29.79, -98.7))
                .title("Cancer Organization"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sanAntonio));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

    }
}


