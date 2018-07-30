package com.example.zhangxian.databasetestDao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhangxian.databasetestBase.DatabaseConnect;
import com.example.zhangxian.databasetestEntity.Persion;

public class PersionDao {

    private DatabaseConnect db;

    public PersionDao(DatabaseConnect db) {
        this.db = db;
    }

    public boolean add(Persion persion)
    {
        SQLiteDatabase sdb = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",persion.getId());
        contentValues.put("name",persion.getName());
        long i = sdb.insert("persion2",null,contentValues);
        sdb.close();
        if(i==-1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public boolean del(Persion persion)
    {
        SQLiteDatabase sdb = db.getWritableDatabase();
        long i = sdb.delete("persion2","ID=?",new String[]{persion.getId()});
        sdb.close();
        if(i==-1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public boolean modify(Persion persion)
    {
        SQLiteDatabase sdb = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",persion.getName());

        long i = sdb.update("persion2",contentValues,"id=?",new String[]{persion.getId()});
        sdb.close();
        if(i==-1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public void query(Persion persion)
    {
        SQLiteDatabase sdb = db.getReadableDatabase();
        Cursor cursor = sdb.query("persion2",new String[]{"id","name"},"id=?",new String[]{persion.getId()},null,null,null);
        while(cursor.moveToNext())
        {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            System.out.println("ID:"+id+",name:"+name);
        }
    }

}
