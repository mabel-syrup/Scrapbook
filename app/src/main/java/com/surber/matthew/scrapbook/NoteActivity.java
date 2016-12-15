package com.surber.matthew.scrapbook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

/**
 * Created by Me on 12/14/2016.
 */

public class NoteActivity extends SingleFragmentActivity implements NoteFragment.OnFragmentInteractionListener{

    private static final String EXTRA_NOTE_TEXT = "com.surber.m.scrapbook.note_text";
    private static final String EXTRA_NOTE_TAGS = "com.surber.m.scrapbook.note_tags";


    public static Intent newIntent(Context packageContext, String text, String tags) {
        Intent intent = new Intent(packageContext,NoteActivity.class);
        intent.putExtra(EXTRA_NOTE_TEXT, text);
        intent.putExtra(EXTRA_NOTE_TAGS, tags);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String noteText = (String) getIntent()
                .getSerializableExtra(EXTRA_NOTE_TEXT);
        String noteTags = (String) getIntent()
                .getSerializableExtra(EXTRA_NOTE_TAGS);
        return NoteFragment.newInstance(noteText,noteTags);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}