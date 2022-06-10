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
import com.example.weatherapp.formula_activities.FormulaParallelogramActivity;
import com.example.weatherapp.formula_activities.FormulaRectangleActivity;
import com.example.weatherapp.formula_activities.FormulaSquareActivity;
import com.example.weatherapp.formula_activities.FormulaTriangleActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ChoosingFigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.choosing_figure_activity);
        Button buttonNextPage = findViewById(R.id.buttonNextPage);

        TextView textBack = findViewById(R.id.textBack);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setBackgroundResource(R.drawable.shape);
        RadioButton radioButtonTriangle = findViewById(R.id.radioButton_triangle);
        RadioButton radioButtonSquare = findViewById(R.id.radioButton_square);
        RadioButton radioButtonRectangle = findViewById(R.id.radioButton_rectangle);
        RadioButton radioButtonParallelogram = findViewById(R.id.radioButton_parallelogram);
        RadioButton radioButtonHexagon = findViewById(R.id.radioButton_hexagon);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Nothing was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_triangle:
                        Toast.makeText(getApplicationContext(), "Triangle was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_square:
                        Toast.makeText(getApplicationContext(), "Square was choosen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_rectangle:
                        Toast.makeText(getApplicationContext(), "Rectangle was choosen",
                                Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButton_parallelogram:
                        Toast.makeText(getApplicationContext(), "Parallelogram was choosen",
                                Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;
                }
            }
        });
        radioButtonHexagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Log into the system to unlock this figure", Toast.LENGTH_SHORT).show();
            }
        });


        buttonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonTriangle.isChecked()){
                    startActivity(new Intent(getBaseContext(), FormulaTriangleActivity.class));
                }else if (radioButtonRectangle.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivity.this, FormulaRectangleActivity.class);
                    startActivity(intent);
                }else if (radioButtonSquare.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivity.this, FormulaSquareActivity.class);
                    startActivity(intent);
                }else if (radioButtonParallelogram.isChecked()){
                    Intent intent = new Intent(ChoosingFigureActivity.this, FormulaParallelogramActivity.class);
                    startActivity(intent);

                } else{
                    Toast.makeText(getApplicationContext(), "Nothing was choosen", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

    }}










































//        user_field = findViewById(R.id.user_field);
//        main_button = findViewById(R.id.main_button);
//        result_field = findViewById(R.id.result_view);
//        element_field = findViewById((R.id.element_field));
//        number_field = findViewById((R.id.number_field));
//        main_button.setOnClickListener(new View.OnClickListener() {
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
//            }
//        });
//    }
//    public static class area_metods {
//
//        //Функция вычисления площади квадрата
//        double area(double x) {
//
//            return (Math.pow(x, 2));
//        }
//        //Функция вычисления площади прямоугольника
//
//        double area(double x, double y) {
//            return x * y;
//        }
//        //Функция вычисления площади круга
//
//        double area(double pi, double r, double r1) {
//            return (pi * (r * r1));
//        }
//        //Функция вычисления площади треугольника
//
//        double area(double p, double x, double y, double z) {
//            return (Math.sqrt(p * (p - x) * (p - y) * (p - z)));
//        }
//    }
//}
//
//
//
//


             /*   if(user_field.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
                else {
                if
                    String city = user_field.getText().toString();
                    String key = "921393a85954952b8d4507dc7509cc7c";
                    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+ key +"&units=metric&lang=ru";

                    new GetURLData().execute(url);
                }
            }
        });*/






//    private class GetURLData extends AsyncTask<String, String, String> {
//        protected void onPreExecute() {
//            super.onPreExecute();
//            result.setText("Ожидайте...");
//
//
//        }
//        @Override
//        protected String doInBackground(String... strings) {
//            HttpURLConnection connection = null;
//            BufferedReader reader = null;
//            try {
//                URL url = new URL(strings[0]);
//                connection =(HttpURLConnection) url.openConnection();
//                connection.connect();
//
//                InputStream stream = connection.getInputStream();
//                reader = new BufferedReader(new InputStreamReader(stream));
//                StringBuffer buffer = new StringBuffer();
//                String line = "";
//                while ((line = reader.readLine()) != null)
//                    buffer.append(line).append("\n");
//
//                return buffer.toString();
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                if (connection != null)
//                    connection.disconnect();
//
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//
//            return null;
//        }
//        @SuppressLint("SetTextI18n")
//        @Override
//        protected void onPostExecute(String results) {
//            super.onPostExecute(results);
//
//            try {
//                JSONObject jsonObject = new JSONObject(results);
//                result.setText("Температура: " + jsonObject.getJSONObject("main").getDouble("temp"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }

