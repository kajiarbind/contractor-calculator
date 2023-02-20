package com.example.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRestaurant;
    private EditText editTextDish;
    private EditText editTextRating;
    private ContractorCalculatorClass dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextRestaurant = findViewById(R.id.editRestaurant);
        editTextDish = findViewById(R.id.editDish);
        editTextRating = findViewById(R.id.editRating);
        dataSource = new ContractorCalculatorClass(this);
    }

    public void save(View view) {
        String name = editTextRestaurant.getText().toString();
        String dish = editTextDish.getText().toString();
        String rating  = editTextRating.getText().toString();
        if(name.isEmpty() || dish.isEmpty()|| rating.isEmpty())
        {
            Toast.makeText(this,"Please enter values",Toast.LENGTH_LONG).show();
        }
        else {
            long id  = dataSource.insertData(name,dish,rating);
            if(id<0)
            {
                Toast.makeText(this,"The value is not saved",Toast.LENGTH_LONG).show();
                editTextRestaurant.setText("");
                editTextDish.setText("");
                editTextRating.setText("");
            }
            else
            {
                Toast.makeText(this,"The value is not saved",Toast.LENGTH_LONG).show();
                editTextRestaurant.setText("");
                editTextDish.setText("");
                editTextRating.setText("");
            }
        }
    }
}