package com.example.zhangxian.databasetestBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnect extends SQLiteOpenHelper {

    public DatabaseConnect(Context context) {
        super(context, "db_test", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("创建数据库");
        sqLiteDatabase.execSQL("create table persion2 (id varchar(20) PRIMARY KEY,name char(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        System.out.println("数据库更新");
        sqLiteDatabase.execSQL("alter table persion2 add sex char(10);");
    }
}
