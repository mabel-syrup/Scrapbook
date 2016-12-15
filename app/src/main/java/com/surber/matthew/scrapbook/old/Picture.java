package com.surber.matthew.scrapbook.old;

import android.net.Uri;

/**
 * Created by wo1624bu on 10/25/16.
 */
public class Picture extends SQLIdea {

    //URI for the image in the Picture
    Uri mImageURI;

    public Picture(Uri ImageUri, String[] Tags){
        mImageURI = ImageUri;
        mTags = Tags;
    }

    public Picture(Uri ImageUri, String tagString){
        mImageURI = ImageUri;
        mTags = getTagsFromString(tagString);
    }

}
