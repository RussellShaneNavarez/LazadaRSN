package com.example.lazada.fragment;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.lazada.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.lazada.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng milan = new LatLng(45.464247688487646, 9.189012182307687);
        mMap.addMarker(new MarkerOptions().position(milan).title("Our principal store in Italy"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

        LatLng manila = new LatLng(14.508711844782122, 121.01498389213475);
        mMap.addMarker(new MarkerOptions().position(manila).title("Our store in the Philippines"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(manila));

        LatLng paris = new LatLng(48.85802643628439, 2.349726592545579);
        mMap.addMarker(new MarkerOptions().position(paris).title("Our store in France"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paris));

        LatLng london = new LatLng(51.50859353064432, -0.1272139317650628);
        mMap.addMarker(new MarkerOptions().position(london).title("Our store in the UK"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(london));

        LatLng newyork = new LatLng(40.70936820543911, -74.00980784515376);
        mMap.addMarker(new MarkerOptions().position(newyork).title("Our store in the USA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork));

        LatLng calgary = new LatLng(51.02277779057699, -114.0649964991816);
        mMap.addMarker(new MarkerOptions().position(calgary).title("Our store in Canada"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(calgary));

        LatLng singapore = new LatLng(1.2955757582731458, 103.84877766084702);
        mMap.addMarker(new MarkerOptions().position(singapore).title("Our store in Singapore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(singapore));

        LatLng tokyo = new LatLng(35.664793254110634, 139.69876808761387);
        mMap.addMarker(new MarkerOptions().position(tokyo).title("Our store in Japan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo));
    }
}