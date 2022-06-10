package com.example.weatherapp.formula_activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.activities.ChoosingFigureActivity;
import com.example.weatherapp.R;

public class FormulaRectangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_rectangle_activity);
        int result = 0;
        ImageView image_rectangle_storoni = findViewById(R.id.image_rectangle_storoni);
        ImageView image_rectangle_diagonal = findViewById(R.id.image_rectangle_diagonal);
        TextView RectangleFormulaView = findViewById(R.id.textView_rectangle_formula);
        RadioGroup radioGroup_rectangle = findViewById(R.id.radioGroup_rectangle);
        EditText RectangleFormulaEditText1 = findViewById(R.id.editText_rectangle_formula1);
        EditText RectangleFormulaEditText2 = findViewById(R.id.editText_rectangle_formula2);
        TextView RectangleResult = findViewById(R.id.textView_rectangle_result);
        Button button_back_rectangle = findViewById(R.id.button_back_rectangle);
        Button button_solve_rectangle = findViewById(R.id.button_solve_rectangle);
        radioGroup_rectangle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId){
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_rectangle_storoni:
                        RectangleFormulaEditText1.setVisibility(View.VISIBLE);
                        RectangleFormulaEditText2.setVisibility(View.VISIBLE);
                        RectangleFormulaView.setVisibility(View.VISIBLE);
                        image_rectangle_storoni.setVisibility(View.VISIBLE);
                        image_rectangle_diagonal.setVisibility(View.INVISIBLE);
                        RectangleFormulaEditText1.setHint("1 Сторона");
                        RectangleFormulaEditText2.setHint("2 Сторона");
                        RectangleFormulaView.setText("S = a ∙ b, где a и b = стороны");
                        break;

                    case R.id.radioButton_rectangle_diagonal:
                        RectangleFormulaEditText1.setVisibility(View.VISIBLE);
                        RectangleFormulaEditText2.setVisibility(View.VISIBLE);
                        image_rectangle_diagonal.setVisibility(View.VISIBLE);
                        image_rectangle_storoni.setVisibility(View.INVISIBLE);
                        RectangleFormulaEditText1.setHint("Диагональ");
                        RectangleFormulaEditText2.setHint("Угол");
                        RectangleFormulaView.setVisibility(View.VISIBLE);
                        RectangleFormulaView.setText("S = d²/2 ∙ sin(a), где d - диагональ, а - угол между ними");
                        break;


                }
            }
        });
        button_back_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        button_solve_rectangle.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                try{
                Double result = 0.0;
                String value1 = RectangleFormulaEditText1.getText().toString();
                String value2 = RectangleFormulaEditText2.getText().toString();
                String formula = RectangleFormulaView.getText().toString();
                Double int_value1 = Double.valueOf(value1);
                Double int_value2 = Double.valueOf(value2);
                if (formula.contains("стороны")){
                    result = int_value1 * int_value2;
                }
                if (formula.contains("диагональ")){
                    result = (int_value1 * int_value1)/2 * Math.sin(Math.toRadians(int_value2));
                }
                String itog_rectangle = String.valueOf(String.format("%.3f",result));
                RectangleResult.setText(itog_rectangle);}
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

