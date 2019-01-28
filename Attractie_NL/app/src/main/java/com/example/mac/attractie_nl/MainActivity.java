package com.example.mac.attractie_nl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView gridView = (ListView) findViewById(R.id.gridview);

        imageAdapter = new ImageAdapter(this, R.layout.row_layout);
        gridView.setAdapter(imageAdapter);

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
                logoLocation = obj.getString("Img");

                Images images = new Images(NaamPark, logoLocation);
                imageAdapter.add(images);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }

