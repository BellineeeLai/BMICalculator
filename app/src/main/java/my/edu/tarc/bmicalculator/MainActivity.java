package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_MESSAGE = "";
    private EditText editTextWeight;
    private EditText edittextHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWeight = findViewById(R.id.editWeight);
        edittextHeight = findViewById(R.id.editHeight);
    }
    public void calculateBMI(View view){
        Double weightMsg;
        Double heightMsg;
        if(TextUtils.isEmpty(editTextWeight.getText())){
            editTextWeight.setError("Please enter your weight");
            return;
        }else if(TextUtils.isEmpty(edittextHeight.getText())){
            edittextHeight.setError("Please enter your height");
            return;
        }
        weightMsg = Double.parseDouble(editTextWeight.getText().toString());
        heightMsg = Double.parseDouble(edittextHeight.getText().toString());

        double bmi = weightMsg/(heightMsg*heightMsg);

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG_MESSAGE,bmi);
        startActivity(intent);
    }

}
