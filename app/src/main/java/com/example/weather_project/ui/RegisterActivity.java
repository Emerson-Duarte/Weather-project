package com.example.weather_project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.adapters.SpinnerBindingAdapter;

import com.example.weather_project.R;
import com.example.weather_project.model.Profile;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ImageView imageRegister;
    Button submitRegister;
    TextView editCity;
    TextView editName;
    Spinner selectProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


//        imageRegister = findViewById(R.id.imageRegister);
//        submitRegister = findViewById(R.id.SubmitRegister);
//        selectProfile = findViewById(R.id.select_profile);
//        editCity = findViewById(R.id.editCity);
//        editName = findViewById(R.id.editName);

        String[] array = new String[] {
                getString(Profile.SIMPLE.getName()),
                getString(Profile.SURF.getName())
        };

        SpinnerAdapter spinnerAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, array);

        selectProfile.setAdapter(spinnerAdapter);
    }

    public void register(View view){
        Intent intent = new Intent(this,MainActivity.class);

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("name", editName.getText().toString());
        user.put("city", editCity.getText().toString());
        user.put("profile", selectProfile.getSelectedItem().toString());

// Add a new document with a generated ID
        db.collection("user")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getBaseContext(), "Erro ao registrar!", Toast.LENGTH_SHORT).show();
                    }
                });


    }

}
