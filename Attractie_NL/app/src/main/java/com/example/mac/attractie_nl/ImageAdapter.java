package com.example.mac.attractie_nl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.mac.attractie_nl.R.id.logoLocation;

public class ImageAdapter extends ArrayAdapter {


    List list = new ArrayList();


    public ImageAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Images object){
        list.add(object);
    }

    public int getCount() {
//        return mThumbIds.length;
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }


    // create a new ImageView for each item referenced by the Adapter
    @SuppressLint("ResourceType")
    public View getView(int position, @Nullable  View convertView, @NonNull ViewGroup parent) {

        InputStream inputStream;
        int counter = 0;
        Drawable[] drawables = new Drawable[0];
        String[] fotos;

        View row;
        row = convertView;
        ImageHolder imageHolder;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, null, true);

            imageHolder = new ImageHolder();

            imageHolder.NaamPark = (TextView) row.findViewById(R.id.NaamPark);
            imageHolder.logoLocation = (ImageView) row.findViewById(logoLocation);
            row.setTag(imageHolder);

        } else {
            imageHolder = (ImageHolder) row.getTag();
        }

            Images images = (Images) this.getItem(position);

            imageHolder.NaamPark.setText(images.getNaam());

            try {
                AssetManager assetManager = getContext().getAssets();
                fotos = assetManager.list("imagination");

                    drawables = new Drawable[fotos.length];

                    for (int i = 0; i < fotos.length; i++) {
                        inputStream = getContext().getAssets().open("imagination/" + fotos[i]);
//                        Log.d(TAG, fotos[i]);
                        Drawable drawable = Drawable.createFromStream(inputStream, null);
                        drawables[i] = drawable;
                        imageHolder.logoLocation.setImageDrawable(drawables[i]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        return row;
    }




    static class ImageHolder{
        TextView NaamPark;
        ImageView logoLocation;
    }


}
