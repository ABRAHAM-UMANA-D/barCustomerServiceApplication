package com.example.barcustomerservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    BarAdapter adapter;
    BarDao dao;
    boolean isLoading=false;
    String key=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        btn1=findViewById(R.id.idbuttonmesa1);
        btn2=findViewById(R.id.idbuttonmesa2);
        btn3=findViewById(R.id.idbuttonmesa3);
        btn4=findViewById(R.id.idbuttonmesa4);
        btn5=findViewById(R.id.idbuttonmesa5);
        btn6=findViewById(R.id.idbuttonmesa6);
        btn7=findViewById(R.id.idbuttonmesa7);
        btn8=findViewById(R.id.idbuttonmesa8);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new BarAdapter(this);
        recyclerView.setAdapter(adapter);
        dao=new BarDao();
        loadData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager linearLayoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItem = linearLayoutManager.getItemCount();
                int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(totalItem< lastVisible+3)
                {
                    if(!isLoading)
                    {
                        isLoading=true;
                        loadData();
                    }
                }
            }
        });
    }

    private void loadData(){
        dao.get(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Mesa> mesas = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Mesa mesa=dataSnapshot.getValue(Mesa.class);
                    mesa.setKey(dataSnapshot.getKey());
                    mesas.add(mesa);
                    key = dataSnapshot.getKey();
                }
                adapter.setItems(mesas);
                adapter.notifyDataSetChanged();
                isLoading=false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(
                        getApplicationContext(),
                        "ERROR",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}

