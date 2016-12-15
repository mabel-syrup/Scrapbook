package com.surber.matthew.scrapbook;

import android.graphics.Bitmap;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class Idea {

    private String text;
    private Bitmap image;
    private String[] tags;


    public Idea (String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text.toString();
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String[] getTags() {
        return tags;
    }

    public void interperateTags(String rawTags) {
        this.tags = rawTags.split(" ");
    }

    public void interperateTags(CharSequence rawTags) {
        this.tags = rawTags.toString().split(" ");
    }
}
