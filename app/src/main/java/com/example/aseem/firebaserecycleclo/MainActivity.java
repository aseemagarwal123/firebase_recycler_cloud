package com.example.aseem.firebaserecycleclo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    FirebaseDatabase dbb;
    List<DModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dbb = FirebaseDatabase.getInstance();
        mDatabase = dbb.getReference("children");
        mDatabase.keepSynced(true);
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator( new DefaultItemAnimator());

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                list = new ArrayList<DModel>();
                list = new ArrayList<>();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren())
                {
                    DModel dModel = userSnapshot.getValue(DModel.class);
                    String name= userSnapshot.child("name").getValue().toString();
                    String age= userSnapshot.child("age").getValue().toString();

                    DModel userdetails = userSnapshot.getValue(DModel.class);
                    DModel listdata = new DModel();

                    listdata.setUserName(name);
                    listdata.setUserAge(age);
                    list.add(listdata);

                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutmanager);
                recyclerView.setItemAnimator( new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Hey", "Error", databaseError.toException());
            }
        });

    }
}
