package com.surber.matthew.scrapbook;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class IdeasListAdapter extends CursorAdapter {

    Context context;

    private static int IMAGE_COL = 1;
    private static int TEXT_COL = 2;
    private static int TAGS_COL = 3;

    public IdeasListAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.idea_list_item, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView noteText = (TextView) view.findViewById(R.id.note_text);
        TextView tagText = (TextView) view.findViewById(R.id.tag_text);
        ImageView thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        noteText.setText(previewText(cursor.getString(TEXT_COL)));
        tagText.setText(cursor.getString(TAGS_COL));
        thumbnail.setImageBitmap(findImage(cursor.getString(IMAGE_COL)));
    }

    private Bitmap findImage (String path) {


        BitmapFactory.Options bOptions = new BitmapFactory.Options();
        bOptions.inJustDecodeBounds = true;
        try {
            return BitmapFactory.decodeFile(path);
        } catch (Exception e) {
            return null;
        }
    }

    private String previewText(String inText) {
        if(inText.length() < 100) {
            return inText;
        } else {
            return inText.substring(0,96) + "...";
        }
    }
}