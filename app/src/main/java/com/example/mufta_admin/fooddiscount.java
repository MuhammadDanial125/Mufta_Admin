package com.example.mufta_admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class fooddiscount extends AppCompatActivity {
    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10;
    String st1, st2, st3, st4, st5, st6, st7, st8, st9, st10;
    FirebaseDatabase database;
    DatabaseReference reference;
    Button imagebutton, savebtn;
    FirebaseAuth auth;
    Uri imageuri;
    Spinner spin,spinnerCities;

    ProgressDialog dialog;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddiscount);
        Objects.requireNonNull(getSupportActionBar()).hide();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        imagebutton = findViewById(R.id.uploadimage);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        et1 = findViewById(R.id.e1);
        et2 = findViewById(R.id.e2);
        spin = findViewById(R.id.spinner2);
        et4 = findViewById(R.id.e4);
        et5 = findViewById(R.id.e5);
        et6 = findViewById(R.id.e6);
        et8 = findViewById(R.id.e8);
        et9 = findViewById(R.id.e9);
        et10 = findViewById(R.id.e10);
        spinnerCities = findViewById(R.id.spinner3);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(adapter);
        savebtn = findViewById(R.id.savebtn);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void convertintoStrings() {

        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        st3 = spin.getSelectedItem().toString();
        st4 = et4.getText().toString();
        st5 = et5.getText().toString();
        st6 = et6.getText().toString();
        st7 = spinnerCities.getSelectedItem().toString();
        st8 = et8.getText().toString();
        st9 = et9.getText().toString();
        st10 = et10.getText().toString();
    }

    public void savedata(View view) {
        String id;
        convertintoStrings();
        id = FirebaseDatabase.getInstance().getReference().push().getKey();
        if (imageuri != null) {
            dialog = ProgressDialog.show(fooddiscount.this, "", "Saving...", true);
            StorageReference reference = storage.getReference().child("images/").child(id);
            reference.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if (task.isSuccessful()) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String imageUrl = uri.toString();
                                String id;
                                HashMap<String, Object> obj = new HashMap<>();
                                obj.put("image", imageUrl);
                                id = FirebaseDatabase.getInstance().getReference().push().getKey();
                                foodmodelclass modelclass = new foodmodelclass(st1, st2, st3, st4, st5, st6, st7, st8, st9, st10, id, imageUrl);
                                database.getReference().child("Discounts").child("Other Discounts").child(id)
                                        .setValue(modelclass)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                dialog.dismiss();
                                                Toast.makeText(fooddiscount.this, "Details Saved", Toast.LENGTH_SHORT).show();
                                            et1.getText().clear();
                                            et2.getText().clear();
                                            et10.getText().clear();
                                            }
                                        });
                            }
                        });
                    }
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageuri = data.getData();
//            uploadpicture();
        }
    }

//    private void uploadpicture() {
//        if (imageuri != null) {
//            final ProgressDialog progressDialog = new ProgressDialog(fooddiscount.this);
//            progressDialog.setTitle("Uploading...");
//            progressDialog.show();
//
//            StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
//            ref.putFile(imageuri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
//                            Toast.makeText(fooddiscount.this, "Uploaded", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                            progressDialog.setMessage("Uploading" + (int) progress + "%");
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            progressDialog.dismiss();
//                            Toast.makeText(fooddiscount.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        }
//    }
}