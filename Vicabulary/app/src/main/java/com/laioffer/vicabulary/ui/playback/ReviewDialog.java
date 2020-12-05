package com.laioffer.vicabulary.ui.playback;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.laioffer.vicabulary.R;

public class ReviewDialog extends DialogFragment {
    PlayListener playListener;

    interface PlayListener {
        void seekTo(int position);
    }

    public void setPlayListener(PlayListener playListener) {
        this.playListener = playListener;
    }

    public ReviewDialog newInstance() {
        ReviewDialog fd = new ReviewDialog();
        Bundle args = new Bundle();
        fd.setArguments(args);
        return fd;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //int vwId = getArguments().getInt("video_view_id");
        //simpleExoPlayerView = getActivity().findViewById(R.id.simpleExoPlayerView);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        builder.setTitle("Review");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Starting from last savepoint.")
                .setTitle("Let's review!");
        builder.setPositiveButton("To savepoint", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if (playListener != null) {
                    playListener.seekTo(0);
                }

            }
        });
        builder.setNegativeButton("New Start", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if(id == -1) {
                    getDialog().dismiss();
                }
            }
        });
        final AlertDialog dialog = builder.create();
        return dialog;
    }


}
