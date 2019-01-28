package com.example.mac.attractie_nl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> adapter = new ArrayList<>();
    ImageAdapter imageAdapter;
    ListView gridView;
    String Json;
    String logoLocation;
    String NaamPark;
    String Plaats;
    String Lat;
    String Lng;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView gridView;
        gridView = (ListView) findViewById(R.id.gridview);

        imageAdapter = new ImageAdapter(this, R.layout.row_layout);
        gridView.setAdapter(imageAdapter);

        Button button = findViewById(R.id.button);
try {

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Goaway(view);

        }
    });

}catch (Exception e){
    e.getMessage();
        }

        //parsing json
        try {
            InputStream inputStream_is = getAssets().open("output_v2.json");
            int size = inputStream_is.available();
            byte[] buffer = new byte[size];

            inputStream_is.read(buffer);
            inputStream_is.close();

            Json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(Json);

            for (int i = 0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                NaamPark = obj.getString("NaamPark");
                Plaats = obj.getString("Plaats");
                Lat = obj.getString("Lat");
                Lng = obj.getString("Lng");
                logoLocation = obj.getString("Img");

                Images images = new Images(NaamPark,Plaats,Lat,Lng,logoLocation);
                imageAdapter.add(images);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void Goaway(View view){


        Intent intent;
        intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);

    }

}

