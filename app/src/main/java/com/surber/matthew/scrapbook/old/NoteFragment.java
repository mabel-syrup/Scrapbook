package com.surber.matthew.scrapbook.old;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.surber.matthew.scrapbook.R;

/**
 * Created by wo1624bu on 10/18/16.
 */
public class NoteFragment extends Fragment {

    private EditText mNoteText;
    private EditText mTags;
    private Button mOkButton;

    private Note note;

    private String mText;
    private String mTagText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Notes do not have images.  The Note fragment used to create a note gives no option for setting an image.

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
                mText = charSequence.toString();
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
                mTagText = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Blank
            }
        });
        mOkButton = (Button) v.findViewById(R.id.accept_button);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Finalize the note when the user clicks ok.
                //TODO: add in warning prompt?
                compileNote();
            }
        });
        return v;
    }

    private void compileNote () {
        //Replace all spaces with | before storing the tags.  (Clears up any ambiguity)
        //Like in other websites/programs, tags with spaces get split up.
        //Underscores can be used to combine words
        String mFormattedTags = mTagText.replaceAll(" ","|");
        //Construct the note.
        note = new Note(mText,mFormattedTags);
        //TODO: return note as the result.
    }


}