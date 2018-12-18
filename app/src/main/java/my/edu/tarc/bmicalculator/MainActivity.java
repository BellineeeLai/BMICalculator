package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextHeight, editTextWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);

    }

    public void calculateBMI(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        double weight, height;
        if(TextUtils.isEmpty(editTextWeight.getText())){
            editTextWeight.setError("Please enter your weight.");
        }
        if(TextUtils.isEmpty(editTextHeight.getText())){
            editTextHeight.setError("Please enter your height.");
        }
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        double bmi = weight/(height*height);
        intent.putExtra("BMI", bmi);
        startActivity(intent);
    }
}
