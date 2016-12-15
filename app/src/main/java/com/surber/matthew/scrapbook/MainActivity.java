package com.surber.matthew.scrapbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String ADAPTER_TAG = "Adapter";
    RecyclerView sbList;
    ArrayList<Idea> myScraps = new ArrayList<>();

    Button addNoteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final IdeaAdapter sbAdapter =
                new IdeaAdapter(myScraps);
        sbList = (RecyclerView) findViewById(R.id.scrapbook_list);
        sbList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        sbList.setAdapter(sbAdapter);
        addNoteButton = (Button) findViewById(R.id.add_note_button);
        for(int i = 0; i < 16; i++){
            myScraps.add(new Idea("Number " + i));
            Log.d(ADAPTER_TAG,"Adding idea.");
        }
        sbAdapter.notifyDataSetChanged();
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newNoteIntent = NoteActivity.newIntent(MainActivity.this,"","");
                startActivity(newNoteIntent);
            }
        });
    }


    private class IdeaHolder extends RecyclerView.ViewHolder/* implements View.OnClickListener*/ {

        private Idea mIdea;

        private TextView mPreview;
        private ImageView mThumb;

        public IdeaHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(this);*/
            mPreview = (TextView) itemView.findViewById(R.id.text_preview);
            mThumb = (ImageView) itemView.findViewById(R.id.thumbnail);
        }

        public void bindIdea(Idea idea) {
            mIdea = idea;
            mPreview.setText(mIdea.getText());
            if(mIdea.getImage() != null) {
                mThumb.setImageBitmap(mIdea.getImage());
            }
        }

        /*@Override
        public void onClick(View v) {
            Intent intent =  CrimeActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
        }*/
    }

    private class IdeaAdapter extends RecyclerView.Adapter<IdeaHolder> {

        private List<Idea> mIdeas;

        public IdeaAdapter(List<Idea> ideas) {
            mIdeas = ideas;
        }

        @Override
        public IdeaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater
                    .inflate(R.layout.idea_list_item,parent,false);
            return new IdeaHolder(view);
        }

        @Override
        public void onBindViewHolder(IdeaHolder holder, int position) {
            Idea idea = mIdeas.get(position);
            holder.bindIdea(idea);
            System.out.println("DEBUG:: Adapter:" + mIdeas.size());
        }

        @Override
        public int getItemCount() {
            return mIdeas.size();
        }
    }

}
