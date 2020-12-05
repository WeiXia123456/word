package com.laioffer.vicabulary.ui.notebook;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;

import com.laioffer.vicabulary.R;
import com.laioffer.vicabulary.model.Word;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;


@Layout(R.layout.wordcard)
public  class WordCard {
    @View(R.id.word)
    private TextView w;

    @View(R.id.explanation)
    private  TextView explanation;

    private final OnSwipeListener onSwipeListener;

    @View(R.id.navigateButton)
    public  Button navi ;

    private final Word wd;
    private  NotebookFragment notebookFragment;

    public WordCard(Word word, OnSwipeListener onSwipeListener, NotebookFragment notebookFragment) {
        this.wd = word;
        this.onSwipeListener = onSwipeListener;
        this.notebookFragment = notebookFragment;
    }

    public Button getButton(){
        return navi;
    }

    @Resolve
    private void onResolved() {

        w.setText(wd.getWord());
        explanation.setText(wd.getExplanation());
        navi.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                // NavHostFragment.findNavController(NotebookFragment.this).navigate(R.id.action_title_note_to_play);
                Bundle bundle = new Bundle();
                bundle.putLong("time", wd.getTime());
                bundle.putString("videoPath",wd.getVideoPath());
                bundle.putString("srtPath",wd.getSrtPath());

                NavHostFragment.findNavController(notebookFragment).navigate(R.id.action_title_note_to_play,bundle);
            }
        });
       // NotebookFragment notebookFragment = new NotebookFragment();
      //  NavHostFragment.findNavController(notebookFragment).navigate(R.id.action_title_note_to_play);

//        w.setText(wd.getWord());
//        explanation.setText(wd.getExplanation());
    }

    @SwipeOut
    private void onSwipedOut() {
        Log.d("EVENT", "onSwipedOut");
        onSwipeListener.unSave(wd);
    }

    @SwipeIn
    private void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    interface OnSwipeListener {
        void unSave(Word word);
    }
}



