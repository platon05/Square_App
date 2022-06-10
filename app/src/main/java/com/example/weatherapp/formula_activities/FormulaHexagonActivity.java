package com.example.weatherapp.formula_activities;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
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

public class FormulaHexagonActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_hexagon_activity);
        int result = 0;
        TextView HexagonFormulaView = findViewById(R.id.textView_hexagon_formula);
        RadioGroup radioGroup_hexagon = findViewById(R.id.radioGroup_hexagon);
        EditText HexagonFormulaEditText = findViewById(R.id.editText_hexagon_formula);
        TextView HexagonResult = findViewById(R.id.textView_hexagon_result);
        ImageView image_hexagon = findViewById(R.id.image_hexagon);
        Button button_back_hexagon = findViewById(R.id.button_back_hexagon);
        Button button_solve_hexagon = findViewById(R.id.button_solve_hexagon);
        radioGroup_hexagon.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was chosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_hexagon_storona:
                        HexagonFormulaEditText.setVisibility(View.VISIBLE);
                        image_hexagon.setImageResource(R.drawable.hexagon_storona);
                        HexagonFormulaView.setVisibility(View.VISIBLE);
                        HexagonFormulaView.setText("S = 3√3 ∙ a²/2, где а - сторона");
                        break;




                    case R.id.radioButton_hexagon_radiusVpisannoy:
                        HexagonFormulaEditText.setVisibility(View.VISIBLE);
                        HexagonFormulaView.setVisibility(View.VISIBLE);
                        image_hexagon.setImageResource(R.drawable.hexagon_vpis);

                        HexagonFormulaView.setText("S = 2√3r², где r - радиус вписанной");
                        break;



                    case R.id.radioButton_hexagon_radiusOpisannoy:
                        HexagonFormulaEditText.setVisibility(View.VISIBLE);
                        image_hexagon.setImageResource(R.drawable.hexagon_opis);

                        HexagonFormulaView.setVisibility(View.VISIBLE);
                        HexagonFormulaView.setText("S = 3√3 ∙ R²/2, где R - радиус описанной");
                        break;





                }


            }
        });


        button_back_hexagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button_solve_hexagon.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try{
                    int result = 0;
                    String value = HexagonFormulaEditText.getText().toString();
                    String formula = HexagonFormulaView.getText().toString();
                    int int_value = Integer.parseInt(value);
                    if (formula.contains("сторона")){
                        result = (int) (3 * Math.sqrt(3) * int_value * int_value) / 2;
                    }

                    if (formula.contains("вписанной")){
                        result = (int) (2 * Math.sqrt(3) * int_value * int_value);
                    }
                    if (formula.contains("описанной")){
                        result = (int) (3 * Math.sqrt(3) * int_value * int_value) / 2;

                    }

                    String itog_hexagon = String.valueOf(String.format("%.3f",result));
                    HexagonResult.setText(itog_hexagon);}
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}