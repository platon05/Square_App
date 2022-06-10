package com.example.weatherapp.activities;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.formula_activities.FormulaHexagonActivity;
import com.example.weatherapp.formula_activities.FormulaParallelogramActivity;
import com.example.weatherapp.formula_activities.FormulaRectangleActivity;
import com.example.weatherapp.formula_activities.FormulaSquareActivity;
import com.example.weatherapp.formula_activities.FormulaTriangleActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ChoosingFigureActivityUnlocked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.choosing_figure_activity_unlocked);
        Button buttonNextPage_unlocked = findViewById(R.id.buttonNextPage_unlocked);
        TextView textBack2 = findViewById(R.id.textBack2);
        RadioGroup radioGroup_unlocked = findViewById(R.id.radioGroup_unlocked);
        radioGroup_unlocked.setBackgroundResource(R.drawable.shape);
        RadioButton radioButtonTriangle_unlocked = findViewById(R.id.radioButton_triangle_unlocked);
        RadioButton radioButtonSquare_unlocked = findViewById(R.id.radioButton_square_unlocked);
        RadioButton radioButtonRectangle_unlocked = findViewById(R.id.radioButton_rectangle_unlocked);
        RadioButton radioButtonHexagon_unlocked = findViewById(R.id.radioButton_hexagon_unlocked);
        RadioButton radioButtonParallelogram_unlocked = findViewById(R.id.radioButton_parallelogram_unlocked);


        radioGroup_unlocked.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle_unlocked:
                        Toast.makeText(getApplicationContext(), "Triangle was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_square_unlocked:
                        Toast.makeText(getApplicationContext(), "Square was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_rectangle_unlocked:
                        Toast.makeText(getApplicationContext(), "Rectangle was choosen",
                                Toast.LENGTH_SHORT).show();

                    case R.id.radioButton_parallelogram_unlocked:
                        Toast.makeText(getApplicationContext(), "Parallelogram was choosen",
                                Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;
                }
            }
        });


        buttonNextPage_unlocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonTriangle_unlocked.isChecked()){
                    startActivity(new Intent(getBaseContext(), FormulaTriangleActivity.class));
                }else if (radioButtonRectangle_unlocked.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivityUnlocked.this, FormulaRectangleActivity.class);
                    startActivity(intent);
                }else if (radioButtonSquare_unlocked.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivityUnlocked.this, FormulaSquareActivity.class);
                    startActivity(intent);
                }else if (radioButtonParallelogram_unlocked.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivityUnlocked.this, FormulaParallelogramActivity.class);
                    startActivity(intent);
                }else if (radioButtonHexagon_unlocked.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivityUnlocked.this, FormulaHexagonActivity.class);
                    startActivity(intent);

                }
            }
        });
        textBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

    }}







