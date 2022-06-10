package com.example.weatherapp.formula_activities.triangle_formulas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.activities.ChoosingFigureActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.formula_activities.FormulaTriangleActivity;

public class TriangleRavnostor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_ravnostor_solve);
        int result = 0;
        TextView TriangleRavnostorFormulaView = findViewById(R.id.textView_TriangleRavnostor_formula);
        ImageView image_triangle_ravnostor = findViewById(R.id.image_triangle_ravnostor);
        RadioGroup radioGroup_TriangleRavnostor = findViewById(R.id.radioGroup_TriangleRavnostor);
        EditText TriangleRavnostorFormulaEditText = findViewById(R.id.editText_TriangleRavnostor_formula);
        TextView TriangleRavnostorResult = findViewById(R.id.textView_TriangleRavnostor_result);
        Button button_back_TriangleRavnostor = findViewById(R.id.button_back_TriangleRavnostor);
        Button button_solve_TriangleRavnostor = findViewById(R.id.button_solve_TriangleRavnostor);
        radioGroup_TriangleRavnostor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_TriangleRavnostor_storona:
                        TriangleRavnostorFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaView.setVisibility(View.VISIBLE);
                        image_triangle_ravnostor.setImageResource(R.drawable.triangle_ravnostor_storona);
                        TriangleRavnostorFormulaView.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaView.setText("S = (√3∙ a²)/4, где a — сторона треугольника");
                        break;


                    case R.id.radioButton_TriangleRavnostor_radiusVpisannoy:
                        image_triangle_ravnostor.setImageResource(R.drawable.triangle_ravnostor_vpis);
                        TriangleRavnostorFormulaView.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaView.setText("S = 3√3 ∙ r², где r — радиус вписанной окружности");
                        break;



                    case R.id.radioButton_TriangleRavnostor_radiusOpisannoy:
                        TriangleRavnostorFormulaView.setVisibility(View.VISIBLE);
                        image_triangle_ravnostor.setImageResource(R.drawable.triangle_ravnostor_opis);

                        TriangleRavnostorFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaView.setText("S = (3√3 ∙ R²)/4, где R - радиус описанной окружности");
                        break;



                    case R.id.radioButton_TriangleRavnostor_visota:
                        TriangleRavnostorFormulaView.setVisibility(View.VISIBLE);
                        image_triangle_ravnostor.setImageResource(R.drawable.triangle_ravnostor_visota);
                        TriangleRavnostorFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleRavnostorFormulaView.setText("S = h²/√3, где h - высота треугольника");
                        break;




                }


            }
        });


        button_back_TriangleRavnostor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),
                        FormulaTriangleActivity.class));
            }
        });

        button_solve_TriangleRavnostor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try{
                    Double result = 0.0;
                    String value = TriangleRavnostorFormulaEditText.getText().toString();
                    String formula = TriangleRavnostorFormulaView.getText().toString();
                    Double int_value = Double.valueOf(value);
                    if (formula.contains("сторона")){
                        result =  Math.sqrt(3) * (int_value * int_value) / 4;
                    }
                    if (formula.contains("высота")){
                        result = (int_value * int_value) / Math.sqrt(3);
                    }
                    if (formula.contains("вписанной")){
                        result =  3 * Math.sqrt(3) * (int_value * int_value);
                    }
                    if (formula.contains("описанной")){
                        result =  3 * Math.sqrt(3) * (int_value * int_value) / 4;

                    }
                    String itog_TriangleRavnostor = String.valueOf(String.format("%.3f",result));
                    TriangleRavnostorResult.setText(itog_TriangleRavnostor);}
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
//main_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String figure_full = user_field.getText().toString();
//                String elements = element_field.getText().toString();
//                String numbers = number_field.getText().toString();
//                int[] numArr = Arrays.stream(numbers.split(" "))
//                        .mapToInt(Integer::parseInt).toArray();
//                String[] arr = elements.split(" ");
//
//
//                if (figure_full.equals("треугольник")) {
//                    for (String i : arr) {
//                        Arrays.sort(arr);
//                        if (Arrays.asList(arr).contains("сторона")) {
//                            x = numArr[0];
//                            y = numArr[1];
//                            z = numArr[2];
//                            p = 0.5 * (x + y + z);
//                            results = ar.area(p, x, y, z);
//                        }
//                    }
//                }
//                if (figure_full.equals("квадрат")) {
//                    for (String i : arr) {
//                        Arrays.sort(arr);
//                        if (Arrays.asList(arr).contains("сторона")) {
//                            x = numArr[0];
//                            results = ar.area(x);
//
//                        }
//                    }
//                }
//                if (figure_full.equals("прямоугольник")) {
//                    for (String i : arr) {
//                        Arrays.sort(arr);
//                        if (Arrays.asList(arr).contains("сторона")) {
//                            x = numArr[0];
//                            y = numArr[1];
//                            results = ar.area(x, y);
//                        }
//                    }
//                }
//
//                if (figure_full.equals("круг")) {
//                    for (String i : arr) {
//                        Arrays.sort(arr);
//                        if (Arrays.asList(arr).contains("радиус")) {
//                            x = numArr[0];
//                            y = numArr[0];
//                            results = ar.area(pi, x, y);
//
//                        }
//                    }
//                }
//
//                String itog = String.valueOf(results);
//                result_field.setText(itog);
