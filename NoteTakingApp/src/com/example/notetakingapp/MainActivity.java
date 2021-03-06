package com.example.notetakingapp;

import java.util.List;

import com.example.notetakingapp.data.NoteItem;
import com.example.notetakingapp.data.NotesDataSourse;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private NotesDataSourse datasourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datasourse = new NotesDataSourse(MainActivity.this);
        List<NoteItem> notes = datasourse.findAll();
        NoteItem note = notes.get(0);
        
        datasourse.update(note);
        Log.d("Notes",note.getKey());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
