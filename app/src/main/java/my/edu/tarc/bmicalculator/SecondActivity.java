package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageViewBMI;
    private TextView textViewBMIStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageViewBMI = findViewById(R.id.imageViewBMI);
        textViewBMIStatus = findViewById(R.id.textViewBMIStatus);

        Intent intent = getIntent();

        double bmi = intent.getDoubleExtra("BMI", 0);

        if( bmi < 18.5 ){
            imageViewBMI.setImageResource(R.drawable.under);
            textViewBMIStatus.setText("Underweight");
        }
        else if( bmi > 24.5 ){
            imageViewBMI.setImageResource(R.drawable.over);
            textViewBMIStatus.setText("Overweight");
        }
        else{
            imageViewBMI.setImageResource(R.drawable.normal);
            textViewBMIStatus.setText("Normal");
        }
    }
    public void close(View view){
        finish();
    }
}
