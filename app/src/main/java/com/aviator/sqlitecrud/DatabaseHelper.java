package com.aviator.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aviator on 11/19/2017. Tranq
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static  final  String DATABASE_NAME="Crud.db";
    public  static  final  String TABLE_NAME="Crud_table";

    //DEFINE COLUMNS
    public  static  final  String COL_1="ID";
    public  static  final  String COL_2="NAME";
    public  static  final  String COL_3="ENG";
    public  static  final  String COL_4="MATH";
    public  static  final  String COL_5="KIS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,ENG INTEGER,MATH INTEGER,KIS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public  boolean INSERT_DATA(String name,String eng,String math,String kis){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,eng);
        contentValues.put(COL_4,math);
        contentValues.put(COL_5,kis);

        long result=database.insert(TABLE_NAME,null,contentValues);
        database.close();

        if(result==-1){
            return  false;
        }else{
            return true;
        }

    }


    public Cursor READ_DATA(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor res=database.rawQuery("select * from "+TABLE_NAME,null);
        return  res;
    }


    public  boolean UPDATE_DATA(String id,String name,String eng,String math,String kis){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,eng);
        contentValues.put(COL_4,math);
        contentValues.put(COL_5,kis);

        int result=database.update(TABLE_NAME,contentValues,"ID =?",new String[]{id});

        if(result>0){
            return  true;
        }else{
            return false;
        }

    }

    public Integer DELETE_DATA(String id){
        SQLiteDatabase database=this.getWritableDatabase();

        int result=database.delete(TABLE_NAME,"ID =?",new String[]{id});
        return result;
    }

    private void Login(){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       // sqLiteDatabase.q
    }

}
