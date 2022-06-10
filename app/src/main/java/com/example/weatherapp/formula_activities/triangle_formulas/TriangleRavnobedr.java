package com.example.weatherapp.formula_activities.triangle_formulas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
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

public class TriangleRavnobedr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_ravnobedr_solve);
        int result = 0;
        TextView TrianglerbFormulaView = findViewById(R.id.textView_triangle_rb_formula);
        ImageView image_triangle_ravnobedr = findViewById(R.id.image_triangle_ravnobedr);
        RadioGroup radioGroup_triangle_rb = findViewById(R.id.radioGroup_triangle_rb);
        EditText TrianglerbFormulaEditText = findViewById(R.id.editText_triangle_rb_formula);
        EditText TrianglerbFormulaEditText2 = findViewById(R.id.editText_triangle_rb_formula2);
        EditText TrianglerbFormulaEditText3 = findViewById(R.id.editText_triangle_rb_formula3);

        TextView TrianglerbResult = findViewById(R.id.textView_triangle_rb_result);
        Button button_back_triangle_rb = findViewById(R.id.button_back_triangle_rb);
        Button button_solve_triangle_rb = findViewById(R.id.button_solve_triangle_rb);
        radioGroup_triangle_rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle_rb_storona:
                        image_triangle_ravnobedr.setImageResource(R.drawable.triangle_ravnobedr_storona);
                        TrianglerbFormulaEditText.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText2.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText.setHint("Сторона a");
                        TrianglerbFormulaEditText2.setHint("Основание b");
                        TrianglerbFormulaView.setVisibility(View.VISIBLE);
                        TrianglerbFormulaView.setText("S= b/4 ∙ √4∙a² - b² , где a — боковая сторона треугольника, b — основание треугольника");
                        break;


                    case R.id.radioButton_triangle_rb_ugol:
                        image_triangle_ravnobedr.setImageResource(R.drawable.triangle_ravnobedr_ugol);
                        TrianglerbFormulaEditText.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText2.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText.setHint("Сторона");
                        TrianglerbFormulaEditText2.setHint("Основание");
                        TrianglerbFormulaEditText3.setHint("Угол");
                        TrianglerbFormulaView.setVisibility(View.VISIBLE);
                        TrianglerbFormulaView.setText("S =  1/2 ∙ a ∙ b ∙ sin(α), где a — боковая сторона треугольника, b — основание треугольника, α — угол между основанием и стороной.");
                    break;


                    case R.id.radioButton_triangle_rb_visota:
                        TrianglerbFormulaEditText.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText2.setVisibility(View.VISIBLE);
                        image_triangle_ravnobedr.setImageResource(R.drawable.triangle_ravnobedr_visota);
                        TrianglerbFormulaEditText.setHint("Основание");
                        TrianglerbFormulaEditText2.setHint("Высота");
                        TrianglerbFormulaView.setVisibility(View.VISIBLE);
                        TrianglerbFormulaView.setText("S =   1/2 ∙ b ∙ h , где b — основание треугольника, h — высота, проведенная к основанию");
                        break;


                    case R.id.radioButton_triangle_rb_ugol_mezhdu_bok:
                        TrianglerbFormulaEditText.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText2.setVisibility(View.VISIBLE);
                        image_triangle_ravnobedr.setImageResource(R.drawable.triangle_ravnobedr_ugol_bok);
                        TrianglerbFormulaEditText.setHint("Сторона");
                        TrianglerbFormulaEditText2.setHint("Угол");
                        TrianglerbFormulaView.setVisibility(View.VISIBLE);
                        TrianglerbFormulaView.setText("S =  1/2 ∙ a² ∙ sin(α)  , где a — боковая сторона треугольника, α — угол между боковыми сторонами");
                        break;


                    case R.id.radioButton_triangle_rb_ugol_mezhdu_osn:
                        image_triangle_ravnobedr.setImageResource(R.drawable.triangle_ravnobedr_ugol_osn);
                        TrianglerbFormulaEditText.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText2.setVisibility(View.VISIBLE);
                        TrianglerbFormulaEditText.setHint("Основание");
                        TrianglerbFormulaEditText2.setHint("Угол");
                        TrianglerbFormulaView.setVisibility(View.VISIBLE);
                        TrianglerbFormulaView.setText("S = b²/ 4∙tg(α/2) , где b — основание треугольника, α — угол между боковыми сторонами");
                        break;

                }

            }
        });

        button_back_triangle_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), FormulaTriangleActivity.class));
            }
        });

        button_solve_triangle_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Double result = 0.0;
                String formula = TrianglerbFormulaView.getText().toString();
                if (formula.contains("b/4")){
                    String value = TrianglerbFormulaEditText.getText().toString();
                    String value2 = TrianglerbFormulaEditText2.getText().toString();
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);
                    result = int_value2 / 4 * Math.sqrt(4 * int_value * int_value - int_value2 * int_value2);
                }
                if (formula.contains("угол между основанием и стороной")){
                    String value = TrianglerbFormulaEditText.getText().toString();
                    String value2 = TrianglerbFormulaEditText2.getText().toString();
                    String value3 = TrianglerbFormulaEditText3.getText().toString();
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);
                    Double int_value3 = Double.valueOf(value3);
                    result = 0.5 * int_value * int_value2 * Math.sin(Math.toRadians(int_value3));
                }
                if (formula.contains("высота")){
                    String value = TrianglerbFormulaEditText.getText().toString();
                    String value2 = TrianglerbFormulaEditText2.getText().toString();
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = 0.5 * int_value * int_value2;
                }
                if (formula.contains("угол между боковыми сторонами")){
                    String value = TrianglerbFormulaEditText.getText().toString();
                    String value2 = TrianglerbFormulaEditText2.getText().toString();
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = 0.5 * int_value * int_value * Math.sin(Math.toRadians(int_value2));

                }
                if (formula.contains("tg")){
                    String value = TrianglerbFormulaEditText.getText().toString();
                    String value2 = TrianglerbFormulaEditText2.getText().toString();
                    Double int_value = Double.valueOf(value);
                    Double int_value2 = Double.valueOf(value2);


                    result = (int_value * int_value) / 4 * Math.tan(Math.toRadians(int_value2 / 2)) ;
                }

                String itog_Trianglerb = String.valueOf(String.format("%.3f",result));
                TrianglerbResult.setText(itog_Trianglerb);}
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
