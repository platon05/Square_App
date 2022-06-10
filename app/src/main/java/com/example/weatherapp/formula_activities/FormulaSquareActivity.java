package com.example.weatherapp.formula_activities;

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

public class FormulaSquareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_square_activity);
        int result = 0;
        ImageView image_square = findViewById(R.id.image_square);
        TextView SquareFormulaView = findViewById(R.id.textView_square_formula);
        RadioGroup radioGroup_square = findViewById(R.id.radioGroup_square);
        EditText SquareFormulaEditText = findViewById(R.id.editText_square_formula);
        TextView SquareResult = findViewById(R.id.textView_square_result);
        Button button_back_square = findViewById(R.id.button_back_square);
        Button button_solve_square = findViewById(R.id.button_solve_square);
        radioGroup_square.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_square_storona:
                        SquareFormulaEditText.setVisibility(View.VISIBLE);
                        image_square.setImageResource(R.drawable.square_storona);
                        SquareFormulaView.setVisibility(View.VISIBLE);
                        SquareFormulaView.setText("S = a ∙ a = a², где а - сторона");
                        break;

                    case R.id.radioButton_square_diagonal:
                        SquareFormulaView.setVisibility(View.VISIBLE);
                        image_square.setImageResource(R.drawable.square_diagonal);

                        SquareFormulaEditText.setVisibility(View.VISIBLE);
                        SquareFormulaView.setText("S = d²/2, где d - диагональ");

                        break;


                    case R.id.radioButton_square_radiusVpisannoy:
                        SquareFormulaView.setVisibility(View.VISIBLE);
                        image_square.setImageResource(R.drawable.square_vpis);

                        SquareFormulaEditText.setVisibility(View.VISIBLE);
                        SquareFormulaView.setText("S = 4r², где r - радиус вписанной");
                        break;



                    case R.id.radioButton_square_radiusOpisannoy:
                        SquareFormulaView.setVisibility(View.VISIBLE);
                        image_square.setImageResource(R.drawable.square_opis);

                        SquareFormulaEditText.setVisibility(View.VISIBLE);
                        SquareFormulaView.setText("S = 2R², где R - радиус описанной");
                        break;



                    case R.id.radioButton_square_perimetr:
                        SquareFormulaView.setVisibility(View.VISIBLE);
                        image_square.setImageResource(R.drawable.square_perimetr);

                        SquareFormulaEditText.setVisibility(View.VISIBLE);
                        SquareFormulaView.setText("S = P²/16, где P - периметр");
                        break;




                }


            }
        });


        button_back_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button_solve_square.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try{
                int result = 0;
                String value = SquareFormulaEditText.getText().toString();
                String formula = SquareFormulaView.getText().toString();
                int int_value = Integer.parseInt(value);
                if (formula.contains("сторона")){
                    result = int_value * int_value;
                }
                if (formula.contains("диагональ")){
                    result = (int_value * int_value) / 2;
                }
                if (formula.contains("вписанной")){
                    result = 4 * (int_value * int_value);
                }
                if (formula.contains("описанной")){
                    result = 2 * (int_value * int_value);

                }
                if (formula.contains("периметр")){
                    result = (int_value * int_value) / 16;
                }
                String itog_square = String.valueOf(String.format("%.3f",result));
                SquareResult.setText(itog_square);}
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}

