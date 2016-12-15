package com.surber.matthew.scrapbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Me on 12/14/2016.
 */

public class IdeasListAdapter extends ArrayAdapter {

    private ArrayList<Idea> ideaList;

    private Context context;
    private int layoutResourceID;
    private static LayoutInflater inflater;

    public IdeasListAdapter(Context context, int resource, ArrayList<Idea> guesses) {
        super(context, resource);
        this.layoutResourceID = resource;
        this.context = context;
        this.ideaList = guesses;
        //This solution brought to you by: http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        System.out.println("Adapter online.");
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(vi == null){
            vi = inflater.inflate(R.layout.idea_list_item, null);
        }
        TextView preview = (TextView) vi.findViewById(R.id.text_preview);
        ImageView thumb = (ImageView) vi.findViewById(R.id.thumbnail);
        preview.setText(ideaList.get(position).getText());
        if(ideaList.get(position).getImage() != null) {
            thumb.setImageBitmap(ideaList.get(position).getImage());
        }
        return vi;

    }
}
