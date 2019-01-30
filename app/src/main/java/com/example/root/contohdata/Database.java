package com.example.root.contohdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Database extends SQLiteOpenHelper {

    private static final String TAG = Database.class.getSimpleName();
    private static final String DATABASE_NAME = "Coba.db";
    private static final int VERSI_DB = 1  ;
    private static final String TABLE_NAME = "table_coba";
    public static final String COLOM_1 = "id_team";
    public static final String COLOM_2 = "team";
    public static final String COLOM_3 = "altername";
    public static final String COLOM_4 = "manager";
    public static final String COLOM_5 = "stadium";
    public static final String COLOM_6 = "keyword";

    public Database(Context context) {
        super(context, DATABASE_NAME, null , VERSI_DB);
           SQLiteDatabase db =  this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table "+TABLE_NAME+"(id_team Text PRIMARY KEY , team TEXT , altername TEXT , manager TEXT , stadium TEXT , keyword TEXT )");
        Log.i(TAG, "Succesfully create Database!!! ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("Drop table if exists "+TABLE_NAME);
    onCreate(db);
    }

    public void insertToDB(ModelData data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLOM_1, data.getIdTeam());
        contentValues.put(COLOM_2, data.getStrTeam());
        contentValues.put(COLOM_3, data.getStrAlternate());
        contentValues.put(COLOM_4, data.getStrManager());
        contentValues.put(COLOM_5, data.getStrStadium());
        contentValues.put(COLOM_6, data.getStrKeywords());

        db.insert(TABLE_NAME,null,contentValues);
    }

    public List<ModelData> getAlldata(){

        List<ModelData> list = new LinkedList<ModelData>();
        String query = "Select * from "+TABLE_NAME ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        ModelData modelData = null ;

        if(cursor.moveToFirst()){
            do{
                modelData = new ModelData();
                modelData.setIdTeam(cursor.getString(0));
                modelData.setStrTeam(cursor.getString(1));
                modelData.setStrAlternate(cursor.getString(2));
                modelData.setStrManager(cursor.getString(3));
                modelData.setStrStadium(cursor.getString(4));
                modelData.setStrKeywords(cursor.getString(5));
                list.add(modelData);
            }while (cursor.moveToNext());
        }
        return list ;
    }
}
