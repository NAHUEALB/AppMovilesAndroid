package com.example.ageofempires;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ageofempires.Utilities.Utilities;

public class ConnectionSQL extends SQLiteOpenHelper {



    //Constructor de esta clase heredada del SQLiteOpenHelper
    public ConnectionSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodos propios de la clase SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilities.TABLE_CREATE);

    }

    //Se fija si se tiene que actualizar o no la BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilities.TABLA_CIVILIZATION);
        onCreate(db);
    }
}
