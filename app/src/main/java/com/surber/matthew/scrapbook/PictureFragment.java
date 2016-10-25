package com.surber.matthew.scrapbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.UUID;

/**
 * Created by wo1624bu on 10/25/16.
 */
public class PictureFragment extends Fragment {

    static final int TAKE_PICTURE = 0;

    ImageView mImage;
    EditText mTags;

    private Picture picture;

    Uri mImageUri;
    String mTagText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Pictures have no text.  Picture view gives no way to set any text.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.picture_view, container, false);

        mImage = (ImageView) v.findViewById(R.id.picture);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If there's no image, user only needs to click to set one instead of long click.
                //TODO:  Check if there's an image yet, and enter "take picture" method if not.
            }
        });
        mImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Use long click here to avoid accidental image changes while viewing.
                //TODO: Add take picture functionality
                return false;
            }
        });
        mTags = (EditText) v.findViewById(R.id.tag_text);
        mTags.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Empty
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTagText = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Empty
            }
        });

        return v;
    }

    public void refreshImage() {

    }

    public void takePicture() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Check to see if there's a camera pp we can use.
        if(pictureIntent.resolveActivity(getContext().getPackageManager()) != null) {

            //Image gets a unique id as its name.
            File imageFile = new File(Environment.getExternalStorageDirectory(), UUID.randomUUID().toString());
            //Set the Uri for the picture.
            mImageUri = Uri.fromFile(imageFile);

            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);

            startActivityForResult(pictureIntent, TAKE_PICTURE);
        } else {
            Toast.makeText(getContext(),"No valid camera found.",Toast.LENGTH_LONG).show();
        }
    }

}
