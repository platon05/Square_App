package com.example.weatherapp.formula_activities.triangle_formulas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.R;
import com.example.weatherapp.formula_activities.FormulaTriangleActivity;

public class TriangleSquare extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_pr_solve);
        int result = 0;
        ImageView image_triangle_pr = findViewById(R.id.image_triangle_pr);
        TextView TriangleprFormulaView = findViewById(R.id.textView_trianglepr);
        RadioGroup radioGroup_trianglepr = findViewById(R.id.radioGroup_trianglepr_solve);
        EditText TriangleprFormulaEditText = findViewById(R.id.editText_trianglepr_formula);
        EditText TriangleprFormulaEditText2 = findViewById(R.id.editText_trianglepr_formula2);

        TextView TriangleprResult = findViewById(R.id.textView_trianglepr_result);
        Button button_back_trianglepr = findViewById(R.id.button_back_trianglepr);
        Button button_solve_trianglepr = findViewById(R.id.button_solve_trianglepr);
        radioGroup_trianglepr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle_kateti:
                        image_triangle_pr.setImageResource(R.drawable.triangle_pr_kateti);
                        TriangleprFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText2.setVisibility(View.VISIBLE);

                        TriangleprFormulaEditText.setHint("1 сторона");
                        TriangleprFormulaEditText2.setHint("2 сторона");

                        TriangleprFormulaView.setVisibility(View.VISIBLE);
                        TriangleprFormulaView.setText("S =  1/2 ∙ a ∙ b - a, b катеты");
                        break;


                    case R.id.radioButton_triangle_gipiostr:
                        image_triangle_pr.setImageResource(R.drawable.triangle_pr_gipiostr);

                        TriangleprFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText.setHint("Гипотенуза");
                        TriangleprFormulaEditText2.setHint("Прилежащий угол");


                        TriangleprFormulaView.setVisibility(View.VISIBLE);
                        TriangleprFormulaView.setText("S =  1/4 ∙ c² ∙ sin(2α)  - c гипотенуза, α - любой из прилегающих острых углов");
                        break;


                    case R.id.radioButton_triangle_katetprilezh:
                        TriangleprFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText2.setVisibility(View.VISIBLE);
                        image_triangle_pr.setImageResource(R.drawable.triangle_pr_katetiprilezh);

                        TriangleprFormulaEditText.setHint("Катет");
                        TriangleprFormulaEditText2.setHint("Прилежащий угол");

                        TriangleprFormulaView.setVisibility(View.VISIBLE);
                        TriangleprFormulaView.setText("S =   1/2 ∙ a² ∙ tg(2α) - где a — катет треугольника, α — прилежащий угол");
                        break;


                    case R.id.radioButton_triangle_chastigip:
                        image_triangle_pr.setImageResource(R.drawable.triangle_pr_chastigip);

                        TriangleprFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText2.setVisibility(View.VISIBLE);

                        TriangleprFormulaEditText.setHint("1 часть");
                        TriangleprFormulaEditText2.setHint("2 часть");

                        TriangleprFormulaView.setVisibility(View.VISIBLE);
                        TriangleprFormulaView.setText("S = c1 ∙ c2 , где c1 и c2 - части гипотенузы");
                        break;


                    case R.id.radioButton_triangle_vpisgip:
                        image_triangle_pr.setImageResource(R.drawable.triangle_pr_vpisgip);

                        TriangleprFormulaEditText.setVisibility(View.VISIBLE);
                        TriangleprFormulaEditText2.setVisibility(View.VISIBLE);

                        TriangleprFormulaEditText.setHint("Радиус");
                        TriangleprFormulaEditText2.setHint("Гипотенуза");
                        TriangleprFormulaView.setVisibility(View.VISIBLE);
                        TriangleprFormulaView.setText("S = r ∙ (r + c) , где c — гипотенуза треугольника, r — радиус вписанной окружности");
                        break;

                }

            }
        });

        button_back_trianglepr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), FormulaTriangleActivity.class));
            }
        });

        button_solve_trianglepr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Double result = 0.0;
                String value = TriangleprFormulaEditText.getText().toString();
                String value2 = TriangleprFormulaEditText2.getText().toString();
                String formula = TriangleprFormulaView.getText().toString();
                if (formula.contains("катеты")){
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);
                    result = 0.5 * int_value * int_value2;
                }
                if (formula.contains("острых")){
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);
                    result = 0.2 * (int_value * int_value) * Math.sin(Math.toRadians(int_value2));
                }
                if (formula.contains("tg")){
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = 0.5 * (int_value * int_value) * Math.tan(Math.toRadians(int_value2));
                }
                if (formula.contains("части")){
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = int_value * int_value2;

                }
                if (formula.contains("радиус")){
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = int_value2 * (int_value + int_value2);
                }

                String itog_Trianglepr = String.valueOf(String.format("%.3f",result));
                TriangleprResult.setText(itog_Trianglepr); }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
