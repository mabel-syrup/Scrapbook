package com.surber.matthew.scrapbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class NoteFragment extends Fragment {

    private EditText mNoteText;
    private EditText mTags;

    private Idea note;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.note_view, container, false);
        mNoteText = (EditText) v.findViewById(R.id.note_text);
        mNoteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //Blank
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                note.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Blank
            }
        });

        mTags = (EditText) v.findViewById(R.id.tag_text);
        mTags.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //Blank
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                note.interperateTags(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Blank
            }
        });

        return v;
    }
}
