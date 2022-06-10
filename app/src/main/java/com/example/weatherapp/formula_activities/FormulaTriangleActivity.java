package com.example.weatherapp.formula_activities;

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

import com.example.weatherapp.Globals;
import com.example.weatherapp.activities.ChoosingFigureActivity;
import com.example.weatherapp.activities.ChoosingFigureActivityUnlocked;
import com.example.weatherapp.activities.MainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.formula_activities.triangle_formulas.TriangleRavnobedr;
import com.example.weatherapp.formula_activities.triangle_formulas.TriangleRavnostor;
import com.example.weatherapp.formula_activities.triangle_formulas.TriangleSquare;
import com.example.weatherapp.formula_activities.triangle_formulas.TriangleTr;

public class FormulaTriangleActivity extends AppCompatActivity {
    TextView logo_formula_triangle;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_triangle_activity);
        Button button_back_triangle = findViewById(R.id.button_back_triangle);
        TextView TriangleFormulaView = findViewById(R.id.textView_triangle_formulas);
        RadioButton radioButtonTriangleSquare = findViewById(R.id.radioButton_triangle_square);
        RadioButton radioButtonTriangleRavnobedr= findViewById(R.id.radioButton_triangle_ravnobedr);
        RadioButton radioButtonTriangletr = findViewById(R.id.radioButton_triangle_tr);
        RadioButton radioButtonTriangleRavnostor = findViewById(R.id.radioButton_triangle_ravnostor);
        RadioGroup radioGroup_triangle = findViewById(R.id.radioGroup_triangle);
       // EditText SquareFormulaEditText = findViewById(R.id.editText_square_formula);
        //TextView SquareResult = findViewById(R.id.textView_square_result);
        Button button_solve_triangle = findViewById(R.id.button_solve_triangle);
        radioGroup_triangle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle_tr:
                        TriangleFormulaView.setVisibility(View.VISIBLE);
                        TriangleFormulaView.setText("Доступные формулы:\n " +
                                "1. через две стороны и угол между ними\n" +
                                "2. через основание и высоту \n" +
                                "3. через радиус описанной окружности и 3 стороны\n" +
                                "4. через радиус вписанной окружности и 3 стороны\n " +
                                "5. через сторону и два прилежащих угла \n" +
                                "6. по формуле Герона");
                        break;
                    case R.id.radioButton_triangle_square:
                        TriangleFormulaView.setVisibility(View.VISIBLE);
                        TriangleFormulaView.setText("Доступные формулы:\n 1.через 2 стороны\n" +
                                "2. через гипотенузу и острый угол\n" +
                                "3. через катет и прилежащий угол\n" +
                                "4. через радиус вписанной окружности и гипотенузу\n" +
                                "5. через вписанную окружность");
                        break;
                    case R.id.radioButton_triangle_ravnobedr:
                        TriangleFormulaView.setVisibility(View.VISIBLE);
                        TriangleFormulaView.setText("Доступные формулы:\n 1. через основание и сторону\n" +
                                "2. через основание и угол\n" +
                                "3. через основание и высоту\n" +
                                "4. через боковые стороны и угол между ними\n" +
                                "5. через основание и угол между боковыми сторонами");
                        break;
                    case R.id.radioButton_triangle_ravnostor:
                        TriangleFormulaView.setVisibility(View.VISIBLE);
                        TriangleFormulaView.setText("Доступные формулы:\n 1. через радиус описанной окружности\n" +
                                "2. через радиус вписанной окружности\n" +
                                "3. через сторону\n" +
                                "4. через высоту");
                        break;


                }
            }
        });
        button_solve_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonTriangletr.isChecked()){
                    startActivity(new Intent(getBaseContext(), TriangleTr.class));
                }
                if (radioButtonTriangleSquare.isChecked()){
                    startActivity(new Intent(getBaseContext(), TriangleSquare.class));
                }
                if (radioButtonTriangleRavnobedr.isChecked()){
                    startActivity(new Intent(getBaseContext(), TriangleRavnobedr.class));
                }
                if (radioButtonTriangleRavnostor.isChecked()){
                    startActivity(new Intent(getBaseContext(), TriangleRavnostor.class));
                }
            }
        });



        button_back_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isRegistered = Globals.ISREGISTERED;
                if (isRegistered) {
                    startActivity(new Intent(getBaseContext(), ChoosingFigureActivityUnlocked.class));
                }else{
                    startActivity(new Intent(getBaseContext(), ChoosingFigureActivity.class));
                }
            }
        });
    }



}
