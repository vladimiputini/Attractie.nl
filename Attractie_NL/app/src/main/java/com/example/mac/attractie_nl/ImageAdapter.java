package com.example.mac.attractie_nl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        Bitmap bitmap = null;

        View row;
        row = convertView;
        ImageHolder imageHolder;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, null, true);

            imageHolder = new ImageHolder();

            imageHolder.NaamPark = (TextView) row.findViewById(R.id.NaamPark);
            imageHolder.Plaats = (TextView) row.findViewById(R.id.Plaats);
            imageHolder.logoLocation = (ImageView) row.findViewById(logoLocation);
            row.setTag(imageHolder);

        } else {
            imageHolder = (ImageHolder) row.getTag();
        }

            Images images = (Images) this.getItem(position);

        if (images != null) {
            imageHolder.NaamPark.setText(images.getNaamPark());
        }
        if (images != null) {
            imageHolder.Plaats.setText(images.getPlaats());
        }

        try {
            AssetManager assetManager = getContext().getAssets();
            fotos = assetManager.list("imagination");

            Bitmap[] bitmapL;
            bitmapL = new Bitmap[fotos.length];

//            Drawable drawable = null;
            for (int i = 0; i < fotos.length; i++) {
                inputStream = getContext().getAssets().open("imagination/" + fotos[i]);
//                        Log.d(TAG, fotos[i]);
                bitmap = BitmapFactory.decodeStream(inputStream);
                bitmapL[i] = bitmap;

                imageHolder.logoLocation.setImageBitmap(bitmapL[i]);
            }



        } catch (IOException e) {
                e.printStackTrace();
            }


        return row;
    }



    static class ImageHolder{
        TextView Plaats;
        TextView NaamPark;
        ImageView logoLocation;

    }


}
