package com.surber.matthew.scrapbook;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class SQLIdea {

    //Tags for ideas
    String[] mTags;

    public String getTagString () {
        String outString = "";
        for (String tag: mTags) {

            outString = outString + "|" + tag;

        }
        return outString;
    }

    public String[] getTagsFromString (String tagString) {
        return tagString.split("|");
    }

}