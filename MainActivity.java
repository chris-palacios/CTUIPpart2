package com.example.ctu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public EditText customerName, customerID, customerAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerName = findViewById(R.id.customerName);
        customerID = findViewById(R.id.customerID);
        customerAdd = (EditText) findViewById(R.id.customerAddress);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = customerName.getText().toString();
                String id = customerID.getText().toString();
                String address = customerAdd.getText().toString();

                if (!validate(name,id,address)) {
                    return;
                }
                else{
                    openOrderDetails();
                }

            }
        });
    }
    public void openOrderDetails(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public boolean validate(String name, String id, String address){
        int numOfErrors = 0;
        if(name.length()==0){
            customerName.setError("Field cannot be empty");
            numOfErrors += 1;
        }
        else if (!name.matches("[a-zA-Z]+")){
            customerName.setError("Please only enter alphabetical characters a-z");
            numOfErrors += 1;
        }
        if (id.length() == 0){
            customerID.setError("Please enter customer ID");
            numOfErrors += 1;
        }
        if (!address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")){
            customerAdd.setError("Please enter correct street address");
            numOfErrors += 1;
        }
        if (numOfErrors > 0){
            return false;
        }
        else {
            return true;
        }
    }
}
