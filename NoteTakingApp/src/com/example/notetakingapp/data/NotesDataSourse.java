package com.example.notetakingapp.data;

import java.util.ArrayList;
import java.util.List;

import com.example.notetakingapp.MainActivity;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesDataSourse {

	private static final String PREFKEY = "notes";
	private SharedPreferences notePrefs;

	public NotesDataSourse(Context context) {
		notePrefs = context.getSharedPreferences(PREFKEY,Context.MODE_PRIVATE);
	}

	public NotesDataSourse(MainActivity context) {
		// TODO Auto-generated constructor stub
	}

	public List<NoteItem> findAll(){

		List<NoteItem> noteList = new ArrayList<NoteItem>();	
		NoteItem note = NoteItem.getNew();
		noteList.add(note);

		return noteList;


	}

	public boolean update(NoteItem note) {
		
		SharedPreferences.Editor editor	= notePrefs.edit();
		editor.putString(note.getKey(), note.getText());
		editor.commit();


		return true;
	}
	public boolean remove(NoteItem note) {

		if(notePrefs.contains(note.getKey())){
			SharedPreferences.Editor editor	= notePrefs.edit();
			editor.remove(note.getKey());
			editor.commit();

		}

			return true;
		}



	};

