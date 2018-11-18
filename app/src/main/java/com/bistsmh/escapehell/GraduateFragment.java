package com.bistsmh.escapehell;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GraduateFragment extends Fragment {

    View myView;
    private static final String TAG = "GraduateFragment";
    String link, output;
    DatabaseReference zonesRef = FirebaseDatabase.getInstance().getReference("Graduate");
    DatabaseReference zone1Ref = zonesRef.child(link);
    DatabaseReference zone1NameRef = zone1Ref.child("Userscore");



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.grade_layout, container, false);
        return myView;

    }


    @Override
      public void  onActivityCreated(Bundle savedInstanceState) {

          super.onActivityCreated(savedInstanceState);

          Addlist addlist = new Addlist();
          link = addlist.key;


        zone1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot linkKeySnapshot : dataSnapshot.getChildren()){

                    output = linkKeySnapshot.child("UserScore").getValue(String.class);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException());
            }
        });


      }








    }




