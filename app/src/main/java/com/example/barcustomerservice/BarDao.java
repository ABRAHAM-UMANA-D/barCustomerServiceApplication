package com.example.barcustomerservice;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class BarDao {
    private DatabaseReference databaseReference;

    public BarDao() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Mesa.class.getSimpleName());
    }

    public Query get(){
        return databaseReference;
    }

    public Task<Void> add (Mesa mesa){
        return databaseReference.push().setValue(mesa);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> delete(String key){
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query query(String key){
        return databaseReference.child(key);
    }
}
