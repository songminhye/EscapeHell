package com.bistsmh.escapehell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bistsmh.escapehell.Model.UserModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.Random;


public class Addlist extends AppCompatActivity {


    Spinner spinner1,spinner2,spinner3;
    EditText edittext1;
    Button button1, button2;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    String text1, text2, text3, text4;
    public String key;



    String[] item1 = {"전공", "전공기반", "기본소양","교양"};
    String[] item2 = {"1-1","1-2","2-1","2-2","3-1","3-2","4-1","4-2"};
    String[] item3 = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","F"};

    ArrayAdapter<String> adapter1,adapter2,adapter3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlist);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2 = (Spinner)findViewById(R.id.spinner2);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3 = (Spinner)findViewById(R.id.spinner3);
        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);




        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                text1 = spinner1.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(), "선택하세요", Toast.LENGTH_SHORT).show();

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                text2 = spinner2.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(), "선택하세요", Toast.LENGTH_SHORT).show();

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                text3 = spinner3.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(), "선택하세요", Toast.LENGTH_SHORT).show();

            }
        });



        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        edittext1 = (EditText)findViewById(R.id.editText1);


        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                key = text2 + text3 + new Random().nextInt(10);

                text4 = edittext1.getText().toString();

                UserModel userModel = new UserModel();
                userModel.Userpart = text1;
                userModel.Username = text4;
                userModel.Userage = text2;
                userModel.Userscore =text3;

                FirebaseDatabase.getInstance().getReference().child("Graduate").child(key).setValue(userModel);






            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(),gradelist.class);
                startActivity(intent);



            }
        });





    }

    //private void writeData(String main, String part, String name, String score, String age) {

        //listlistlist love = new listlistlist(part, name, score, age);
        //databaseReference.child(main).child(key).setValue(love);


   // }


}

