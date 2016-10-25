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

        //Set noteText to use a formatted "preview" of the text.
        noteText.setText(
                previewText(cursor.getString(TEXT_COL))
        );
        //Display the tags
        tagText.setText(cursor.getString(TAGS_COL));
        //Display thumbnail of the image.
        thumbnail.setImageBitmap(findImage(cursor.getString(IMAGE_COL)));
    }

    private Bitmap findImage (String uri) {

        //TODO: locate file and use thumbnail
        return null;
    }

    //Returns text formatted to be used as a preview.
    private String previewText(String inText) {
        if(inText.length() < 100) {
            //It's less than 100 characters, so it can just be displayed as-is.
            return inText;
        } else {
            //Preview text is always <= 100 characters.
            //If it goes over, it cuts it off at 97 characters and adds "..." to the end.
            return inText.substring(0,96) + "...";
        }
    }
}