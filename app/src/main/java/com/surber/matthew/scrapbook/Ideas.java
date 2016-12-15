package com.surber.matthew.scrapbook;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Me on 12/14/2016.
 */
public class Ideas {

    public ArrayList<Idea> mIdeas = new ArrayList<>();


    private static Ideas ourInstance = new Ideas();

    public static Ideas getInstance() {
        return ourInstance;
    }

    private Ideas() {
    }

    public UUID newIdea (){
        return null;
    }
}
