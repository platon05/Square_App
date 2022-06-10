package com.example.weatherapp.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.Globals;
import com.example.weatherapp.R;
import com.example.weatherapp.activities.ChoosingFigureActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    Button welcome_button_create_user;
    Button welcome_button_login;
    EditText PasswordText;
    EditText EmailText;
    public boolean isRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView withoutRegistration = findViewById(R.id.without_registration);
        Button welcome_button_create_user = findViewById(R.id.button_welcome_create_user);
        Button welcome_button_login= findViewById(R.id.button_welcome_login);
        welcome_button_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), CreateUserActivity.class));

            }
        });
        welcome_button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LogInActivity.class));

            }
        });
        withoutRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals isRegistered = (Globals) getApplicationContext();
                isRegistered.setISREGISTERED(false);
                startActivity(new Intent(getBaseContext(), ChoosingFigureActivity.class));
            }
        });

    }
}










































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
