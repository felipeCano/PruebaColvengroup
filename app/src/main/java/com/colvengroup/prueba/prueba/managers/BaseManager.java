package com.colvengroup.prueba.prueba.managers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public abstract class BaseManager {

    protected FirebaseDatabase db = FirebaseDatabase.getInstance();
    protected DatabaseReference tripsRef = db.getReference("Usuarios");

}
