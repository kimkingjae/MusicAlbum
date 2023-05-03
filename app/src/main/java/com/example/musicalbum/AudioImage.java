package com.example.musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);
        Intent it = getIntent();
        String tag = it.getStringExtra("it.tag");

        TextView title = findViewById(R.id.title);
        TextView lyrics = findViewById(R.id.lyrics);
        ImageView song_image = findViewById(R.id.song_image);

        Resources res = getResources();

        int stringId;
        String mkKey;

        stringId = res.getIdentifier("title"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        title.setText(mkKey);

        stringId = res.getIdentifier("lyrics"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        lyrics.setText(mkKey);

        stringId = res.getIdentifier("song.image"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        int  imageId = res.getIdentifier(mkKey,"drawble",getPackageName());
        song_image.setImageResource(imageId);

        stringId =res.getIdentifier("audio"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey,"raw",getPackageName());
        mp = MediaPlayer.create(this,audioId);
        mp.setLooping(false);
        mp.start();
    }
    public  void  goBack(View view){
        if (mp.isPlaying()){
            mp.start();
            mp.release();
        }
        finish();

    }
}
