package com.example.weatherapp.formula_activities.triangle_formulas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.R;
import com.example.weatherapp.formula_activities.FormulaTriangleActivity;

public class TriangleTr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_solve);
        int result = 0;
        TextView TriangletrFormulaView = findViewById(R.id.textView_triangletr);
        RadioGroup radioGroup_triangletr = findViewById(R.id.radioGroup_triangle_solve);
        EditText TriangletrFormulaEditText = findViewById(R.id.editText_triangletr_formula);
        EditText TriangletrFormulaEditText2 = findViewById(R.id.editText_triangletr_formula2);
        EditText TriangletrFormulaEditText3 = findViewById(R.id.editText_triangletr_formula3);
        EditText TriangletrFormulaEditText4 = findViewById(R.id.editText_triangletr_formula4);
        TextView TriangletrResult = findViewById(R.id.textView_triangletr_result);
        Button button_back_triangletr = findViewById(R.id.button_back_triangletr);
        Button button_solve_triangletr = findViewById(R.id.button_solve_triangletr);
        radioGroup_triangletr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle_2sides_angle:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText3.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText4.setVisibility(View.INVISIBLE);
                        TriangletrFormulaEditText.setHint("1 ??????????????");
                        TriangletrFormulaEditText2.setHint("2 ??????????????");
                        TriangletrFormulaEditText3.setHint("???????? ?????????? ????????");

                        TriangletrFormulaView.setVisibility(View.VISIBLE);
                        TriangletrFormulaView.setText("S =  1/2 ??? a ??? b ??? sin(??) - a, b ??????????????, ?? - ???????? ?????????? ????????");
                        break;


                    case R.id.radioButton_triangle_osnivis:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText.setHint("??????????????");
                        TriangletrFormulaEditText2.setHint("????????????");
                        TriangletrFormulaEditText3.setVisibility(View.INVISIBLE);

                        TriangletrFormulaView.setVisibility(View.INVISIBLE);
                        TriangletrFormulaView.setText("S =  1/2 ??? a ??? h - a ??????????????, h - ????????????");
                        break;


                    case R.id.radioButton_triangle_3sidesopis:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText3.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText4.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText.setHint("1 ??????????????");
                        TriangletrFormulaEditText2.setHint("2 ??????????????");
                        TriangletrFormulaEditText3.setHint("3 ??????????????");
                        TriangletrFormulaEditText4.setHint("???????????? ?????????????????? ????????????????????");
                        TriangletrFormulaView.setVisibility(View.VISIBLE);
                        TriangletrFormulaView.setText("S =  a???b???c/4R - a, b, c ??????????????, R - ???????????? ?????????????????? ????????????????????");
                        break;


                    case R.id.radioButton_triangle_3sidesvpis:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText3.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText4.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText.setHint("1 ??????????????");
                        TriangletrFormulaEditText2.setHint("2 ??????????????");
                        TriangletrFormulaEditText3.setHint("3 ??????????????");
                        TriangletrFormulaEditText4.setHint("???????????? ?????????????????? ????????????????????");
                        TriangletrFormulaView.setVisibility(View.VISIBLE);
                        TriangletrFormulaView.setText("S =  (r ??? (a + b + c))/2 - a, b, c ??????????????, r - ???????????? ?????????????????? ????????????????????");
                        break;


                    case R.id.radioButton_triangle_side_2angle:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText3.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText4.setVisibility(View.INVISIBLE);
                        TriangletrFormulaEditText.setHint("??????????????");
                        TriangletrFormulaEditText2.setHint("1 ???????????????????? ????????");
                        TriangletrFormulaEditText3.setHint("2 ???????????????????? ????????");
                        TriangletrFormulaView.setVisibility(View.VISIBLE);
                        TriangletrFormulaView.setText("S =  a??/2 ??? (sin(??)???sin(??)/sin(??)) , ?????? a ??? ?????????????? ????????????????????????,\n" +
                                " ?? ?? ?? ??? ???????????????????? ????????, ?? ??? ???????????????????????????? ????????");
                        break;
                    case R.id.radioButton_triangle_Geron:
                        TriangletrFormulaEditText.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText2.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText3.setVisibility(View.VISIBLE);
                        TriangletrFormulaEditText4.setVisibility(View.INVISIBLE);
                        TriangletrFormulaEditText.setHint("1 ??????????????");
                        TriangletrFormulaEditText2.setHint("2 ??????????????");
                        TriangletrFormulaEditText3.setHint("3 ??????????????");
                        TriangletrFormulaView.setVisibility(View.VISIBLE);
                        TriangletrFormulaView.setText("S = ???p???(p???a)???(p???b)???(p???c), ?????? a, b, c ??? ?????????????? ????????????????????????,\n" +
                                " p ??? ???????????????????????? ????????????????????????");
                        break;
                }

            }
        });

        button_back_triangletr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), FormulaTriangleActivity.class));
            }
        });

        button_solve_triangletr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Double result = 0.0;
                    String value = TriangletrFormulaEditText.getText().toString();
                    String value2 = TriangletrFormulaEditText2.getText().toString();
                    String value3 = TriangletrFormulaEditText3.getText().toString();
                    String value4 = TriangletrFormulaEditText4.getText().toString();
                    String formula = TriangletrFormulaView.getText().toString();
                    if (formula.contains("????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);
                        Double int_value3 = Double.valueOf(value3);
                        result = 0.5 * int_value * int_value2 * Math.sin(Math.toRadians(int_value3));
                    }
                    if (formula.contains("????????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);
                        result = (int_value * int_value2) / 2;
                    }
                    if (formula.contains("??????????????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);

                        Double int_value3 = Double.valueOf(value3);
                        Double int_value4 = Double.valueOf(value4);
                        result = (int_value * int_value2 * int_value3) / (4 * int_value4);
                    }
                    if (formula.contains("??????????????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);

                        Double int_value3 = Double.valueOf(value3);
                        Double int_value4 = Double.valueOf(value4);
                        result = (int_value4 * (int_value + int_value2 + int_value3))/2;

                    }
                    if (formula.contains("????????????????????????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);

                        Double int_value3 = Double.valueOf(value3);
                        Double ugol = 180 - (int_value2 + int_value3);
                        result = (int_value * int_value)/2 * (Math.sin(Math.toRadians(int_value2))
                                * Math.sin(Math.toRadians(int_value3))) / Math.sin(Math.toRadians(ugol));
                    }
                    if (formula.contains("????????????????????????")){
                        Double int_value = Double.valueOf(value);
                        Double int_value2 = Double.valueOf(value2);

                        Double int_value3 = Double.valueOf(value3);

                        Double poluperimetr = (int_value + int_value2 + int_value3) / 2;
                        result = Math.sqrt(poluperimetr * (poluperimetr - int_value) * (poluperimetr - int_value2)
                                        * (poluperimetr - int_value3));
                    }
                    String itog_triangletr = String.valueOf(String.format("%.3f",result));
                    TriangletrResult.setText(itog_triangletr); }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
