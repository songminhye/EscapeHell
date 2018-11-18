package com.bistsmh.escapehell.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bistsmh.escapehell.Model.UserModel;
import com.bistsmh.escapehell.R;
import com.bistsmh.escapehell.listlistlist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GradelistFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_gradelist,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        recyclerView.setAdapter(new GradeFragmentRecyclerViewAdapter());
        return view;
    }

    class GradeFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        List<UserModel> userModels;

        public GradeFragmentRecyclerViewAdapter() {
            userModels = new ArrayList<>();
            FirebaseDatabase.getInstance().getReference().child("Graduate").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    userModels.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        userModels.add(snapshot.getValue(UserModel.class));
                    }
                    notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_my,parent,false);

            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

            ((CustomViewHolder)holder).part1.setText(userModels.get(i).Userpart);
            ((CustomViewHolder)holder).name1.setText(userModels.get(i).Username);
            ((CustomViewHolder)holder).age1.setText(userModels.get(i).Userage);
            ((CustomViewHolder)holder).score1.setText(userModels.get(i).Userscore);


        }

        @Override
        public int getItemCount() {
            return userModels.size();
        }

        private class CustomViewHolder extends RecyclerView.ViewHolder {
            public TextView part1, name1, age1, score1;

            public CustomViewHolder(View view) {
                super(view);
                part1 = (TextView)view.findViewById(R.id.Type);
                name1 = (TextView)view.findViewById(R.id.Name);
                age1 = (TextView)view.findViewById(R.id.Age);
                score1 = (TextView)view.findViewById(R.id.Grade);

            }
        }
    }

}
