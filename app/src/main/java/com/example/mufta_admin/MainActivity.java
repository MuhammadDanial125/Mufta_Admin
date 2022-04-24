package com.example.mufta_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText e1, e3, e4, e5, e6, e7, e8, e9, e10;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    FirebaseDatabase database;
    Spinner spinner;
    DatabaseReference reference;
    ProgressDialog dailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        e1 = findViewById(R.id.ed1);
        spinner = findViewById(R.id.spinner1);
        e3 = findViewById(R.id.ed3);
        e4 = findViewById(R.id.ed4);
        e5 = findViewById(R.id.ed5);
        e6 = findViewById(R.id.ed6);
        e7 = findViewById(R.id.ed7);
        e8 = findViewById(R.id.ed8);
        e9 = findViewById(R.id.ed9);
        e10 = findViewById(R.id.ed10);
        btn = findViewById(R.id.savebtn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.website_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void convertintoStrings() {
        s1 = e1.getText().toString();
        s2 = spinner.getSelectedItem().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        s5 = e5.getText().toString();
        s6 = e6.getText().toString();
        s7 = e7.getText().toString();
        s8 = e8.getText().toString();
        s9 = e9.getText().toString();
        s10 = e10.getText().toString();
    }

    public void Savedata(View view) {
        String id;
        dailog = ProgressDialog.show(MainActivity.this, "", "Saving...", true);
        convertintoStrings();
        id = FirebaseDatabase.getInstance().getReference().push().getKey();
        muftamodelclass profileModelClass = new muftamodelclass(s1, s2, s10, s3, s4, s5, s6, s7, s8, s9, id);
        reference.child("Discounts").child("Education").child(id).setValue(profileModelClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this, "Discount details are saved", Toast.LENGTH_LONG).show();
                dailog.dismiss();
                e1.getText().clear();
                e10.getText().clear();
                e9.getText().clear();
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error" + e, Toast.LENGTH_LONG).show();
                dailog.dismiss();
            }
        });
    }
}