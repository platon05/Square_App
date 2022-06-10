package com.example.weatherapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapp.Globals;
import com.example.weatherapp.R;
import com.example.weatherapp.activities.ChoosingFigureActivity;
import com.example.weatherapp.services.AuthService;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

@RequiresApi(api = Build.VERSION_CODES.O)
public class LogInActivity extends AppCompatActivity {
    Button buttonCreateUser;
    Button buttonLogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Button buttonLogInBack = findViewById(R.id.buttonlogInBack);
        Button buttonLogIn = findViewById(R.id.buttonlogInLOG_IN);
        EditText edit_text_login_email = findViewById(R.id.EditTextEmailLOG_IN);
        EditText edit_text_login_password = findViewById(R.id.EditTextPasswordLOG_IN);

        buttonLogInBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_login = edit_text_login_email.getText().toString();
                String password_login = edit_text_login_password.getText().toString();
                if (email_login.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!email_login.contains("@") || email_login.length() < 3) {
                    Toast.makeText(getBaseContext(), "Email must be correct", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password_login.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password_login.length() < 6) {
                    Toast.makeText(getBaseContext(), "Password must be correct", Toast.LENGTH_SHORT).show();
                    return;
                }
                AuthService.logIn(email_login, password_login)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Globals isRegistered = (Globals) getApplicationContext();
                                isRegistered.setISREGISTERED(true);
                                startActivity(new Intent(getBaseContext(), ChoosingFigureActivityUnlocked.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getBaseContext(), "Cant log in", Toast.LENGTH_SHORT).show();
                    }
                });
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
