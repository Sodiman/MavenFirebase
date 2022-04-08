/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import com.google.api.core.SettableApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import interfaces.UserInterf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Ody
 */
public class UserImpl implements UserInterf {

    private final FirebaseDatabase database;
    private final DatabaseReference reference;

    public UserImpl() {
        try {
            FileInputStream serviceAccount = new FileInputStream("C:\\firebase\\mavenfirebase-adminsdk.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://mavenfirebase.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("DBMaven/User");
        reference.keepSynced(true);
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> list = new ArrayList<>();
        final SettableApiFuture<DataSnapshot> future = SettableApiFuture.create();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                future.set(ds);
                try {
                    DataSnapshot snap = future.get();
                    for (DataSnapshot postSnapshot : snap.getChildren()) {
                        User u = postSnapshot.getValue(User.class);
                        if (u != null) {
                            list.add(u);
                        }
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
                System.out.println(de.getMessage());
            }
        });

        return list;
    }

    @Override
    public void save(User u) throws Exception {
        reference.child(u.getKey()).setValueAsync(u);
    }

    @Override
    public void update(User u) throws Exception {
        reference.child(u.getKey()).setValueAsync(u);
    }

    @Override
    public void deleteBy(String kunci) throws Exception {
        reference.child(kunci).removeValueAsync();
    }
}
