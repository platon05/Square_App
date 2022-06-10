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

public class FormulaParallelogramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_parallelogram_activity);
        int result = 0;
        ImageView image_parallelogram = findViewById(R.id.image_parallelogram);
        TextView parallelogramFormulaView = findViewById(R.id.textView_parallelogram_formula);
        RadioGroup radioGroup_parallelogram = findViewById(R.id.radioGroup_parallelogram);
        EditText parallelogramFormulaEditText1 = findViewById(R.id.editText_parallelogram_formula1);
        EditText parallelogramFormulaEditText2 = findViewById(R.id.editText_parallelogram_formula2);
        EditText parallelogramFormulaEditText3 = findViewById(R.id.editText_parallelogram_formula3);
        TextView parallelogramResult = findViewById(R.id.textView_parallelogram_result);
        Button button_back_parallelogram = findViewById(R.id.button_back_parallelogram);
        Button button_solve_parallelogram = findViewById(R.id.button_solve_parallelogram);
        radioGroup_parallelogram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId){
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_parallelogram_visota:
                        parallelogramFormulaEditText1.setVisibility(View.VISIBLE);
                        parallelogramFormulaEditText2.setVisibility(View.VISIBLE);
                        parallelogramFormulaView.setVisibility(View.VISIBLE);
                        image_parallelogram.setImageResource(R.drawable.parallelogram_osn);
                        parallelogramFormulaEditText1.setHint("Основание");
                        parallelogramFormulaEditText2.setHint("Высота");
                        parallelogramFormulaView.setText("S = a ∙ h, где a — основание параллелограмма, h — его высота");
                        break;

                    case R.id.radioButton_parallelogram_ugol:
                        parallelogramFormulaEditText1.setVisibility(View.VISIBLE);
                        image_parallelogram.setImageResource(R.drawable.parallelogram_ugol);

                        parallelogramFormulaEditText2.setVisibility(View.VISIBLE);
                        parallelogramFormulaEditText1.setHint("Сторона a");
                        parallelogramFormulaEditText2.setHint("Сторона b");
                        parallelogramFormulaEditText3.setHint("Угол");
                        parallelogramFormulaView.setVisibility(View.VISIBLE);
                        parallelogramFormulaView.setText("S = a ∙ b ∙ sin(α), где a и b — стороны параллелограмма, α — угол между сторонами");
                        break;

                    case R.id.radioButton_parallelogram_diagonal:
                        parallelogramFormulaEditText1.setVisibility(View.VISIBLE);
                        parallelogramFormulaEditText2.setVisibility(View.VISIBLE);
                        image_parallelogram.setImageResource(R.drawable.parallelogram_diagonal);

                        parallelogramFormulaEditText1.setHint("Диагональ 1");
                        parallelogramFormulaEditText2.setHint("Диагональ 2");
                        parallelogramFormulaEditText3.setHint("Угол");
                        parallelogramFormulaView.setVisibility(View.VISIBLE);
                        parallelogramFormulaView.setText("S = 1/2 ∙ d1 ∙ d2 ∙ sin(a), где d1 и d2 — диагонали параллелограмма, α — угол между ними");
                        break;


                }
            }
        });
        button_back_parallelogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        button_solve_parallelogram.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                try{
                    Double result = 0.0;
                    String value1 = parallelogramFormulaEditText1.getText().toString();
                    String value2 = parallelogramFormulaEditText2.getText().toString();
                    String value3 = parallelogramFormulaEditText3.getText().toString();
                    String formula = parallelogramFormulaView.getText().toString();
                    Double int_value1 = Double.valueOf(value1);
                    Double int_value2 = Double.valueOf(value2);
                    Double int_value3 = Double.valueOf(value3);
                    if (formula.contains("основание")){
                        result = int_value1 * int_value2;
                    }
                    if (formula.contains("стороны")){
                        result = int_value1 * int_value2 * Math.sin(Math.toRadians(int_value3));
                    }
                    if (formula.contains("диагонали")){
                        result = 0.5 * int_value1 * int_value2 * Math.sin(Math.toRadians(int_value3));
                    }
                    String itog_parallelogram = String.valueOf(String.format("%.3f",result));
                    parallelogramResult.setText(itog_parallelogram);}
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

