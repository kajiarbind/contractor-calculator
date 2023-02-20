package com.example.contractorcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ContractorCalculatorClass {

    CalcHepler myhelper;
    public ContractorCalculatorClass(Context context)
    {
        myhelper = new CalcHepler(context);
    }

    public long insertData(String name, String dish, String rating)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CalcHepler.RESTUARANT, name);
        contentValues.put(CalcHepler.DISH, dish);
        contentValues.put(CalcHepler.RATING,rating);
        long id = dbb.insert(CalcHepler.TABLE_NAME, null , contentValues);
        return id;
    }



    static class CalcHepler extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myRestuarantDatabase";
        private static final String TABLE_NAME = "myRestuarantTable";
        private static final int DATABASE_VERSION = 1;
        private static final String DISH_ID="_dishID";
        private static final String RESTUARANT = "RestuarentName";
        private static final String DISH= "DishName";
        private static final String RATING ="Ratings";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+DISH_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+RESTUARANT+" VARCHAR(255) ,"+ DISH+" VARCHAR(225),"+RATING+"  VARCHAR(50));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public CalcHepler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context,"Upgrade of Database",Toast.LENGTH_LONG).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Toast.makeText(context,""+e,Toast.LENGTH_LONG).show();
            }
        }


    }
}
