package com.surber.matthew.scrapbook;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class SQLIdea {

    String mText;
    String[] mTags;
    Uri mImageURI;

    public SQLIdea(String text, String[] tags, Uri imageURI) {
        mText = text;
        mTags = tags;
        mImageURI = imageURI;
    }

}
