package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    String text;
    EditText editText;
    String mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ed1);

        Button button = findViewById(R.id.bt1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                String url = "https://notify-api.line.me/api/notify";    ///API line///
                String token ="";    /// line Token///
                text = editText.getText().toString();    ///get message to text variable ///
                RequestBody requestBody = new MultipartBody.Builder() /// Create object requestBody ////
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("message", text)
                        .build();


                final Request request = new Request.Builder() //// set header for request
                        .url(url)
                        .post(requestBody)
                        .header("Content-Type", "multipart/form-data")
                        .header("Authorization","Bearer "+token)
                        .build();

                client.newCall(request).enqueue(new Callback() {   //// Call API
                    @Override
                    public void onFailure(Call call, IOException e) {
                        String mMessage = e.getMessage().toString();
                        Log.d("ERROR", mMessage);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        mMessage = response.body().string();
                        Log.d("PASS", mMessage);

                    }


                });

            }
        });

        Button button1 =findViewById(R.id.bt2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}

