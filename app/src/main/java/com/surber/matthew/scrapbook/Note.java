package com.surber.matthew.scrapbook;

/**
 * Created by wo1624bu on 10/25/16.
 */
public class Note extends SQLIdea {

    //Text for the Note
    String mText;

    public Note (String Text, String[] Tags) {
        mText = Text;
        mTags = Tags;
    }

    public Note (String Text, String tagString) {
        mText = Text;
        mTags = getTagsFromString(tagString);
    }

}
