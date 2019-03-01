package com.colvengroup.prueba.prueba.managers;

import com.colvengroup.prueba.prueba.data.DataUsuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class UsuarioManager extends BaseManager {


    private  OnUserManagerListener onUserManagerListener;
    private static final String USUARIO_ID = "Usuarios";

    public UsuarioManager(OnUserManagerListener onUserListener) {
        this.onUserManagerListener = onUserListener;
    }




    public void addlonglatitud(final DataUsuario dataUsuario) {
/*
        DocumentReference docRef = db.collection(USUARIO_ID).document(dataUsuario.getUniqueld());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        DataUsuario user = document.toObject(DataUsuario.class);
                        //user.replaceProduct(dataUsuario);
                        updateORder(user);
                    }

                } else {
                    onUserManagerListener.onUnknownUserFetchError();
                }
            }
        });*/

    }


    public void ReadUser() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<DataUsuario> list = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                  DataUsuario user = ds.getValue(DataUsuario.class);
                  list.add(user);
                }
              onUserManagerListener.onLoadUSer(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        tripsRef.addListenerForSingleValueEvent(valueEventListener);
    }

    public void updateUser(DataUsuario user) {
        tripsRef.child(user.getUniqueId()).setValue(user);
    }

    public interface OnUserManagerListener {
        void onUnknownUserFetchError();



     //   void onUpdateCart(boolean hasSuccess);

        void onLoadUSer(List<DataUsuario> user);

        // void onDeleteDocumentCart(DataCart cart);

        void onUserHasNoUser();

     //   void onEmptyCartCreated(boolean hasEmptyCartCreated);
    }


}
