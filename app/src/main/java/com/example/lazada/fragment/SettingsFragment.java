package com.example.lazada.fragment;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.lazada.Login;
import com.example.lazada.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingsFragment extends Fragment {
    FirebaseAuth auth;
    Button button;
    TextView textView;
    TextView textView2;
    FirebaseUser user;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = view.findViewById(R.id.goMapBtn);
        auth = FirebaseAuth.getInstance();
        button = view.findViewById(R.id.logout);
        textView = view.findViewById(R.id.emailUser);
        textView2 = view.findViewById(R.id.IDUser);
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(SettingsFragment.this.getContext(), Login.class);
            startActivity(intent);

        } else {
            textView.setText("Email: " + user.getEmail());
            textView2.setText("Account ID: " + user.getUid());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SettingsFragment.this.getContext(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsFragment.this.getContext(), MapsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
