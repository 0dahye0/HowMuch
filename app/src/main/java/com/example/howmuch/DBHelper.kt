package com.example.howmuch

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context?) :
    SQLiteOpenHelper(context,"Login.db",null,1) {
    override fun onCreate(MyDB: SQLiteDatabase) {
        MyDB.execSQL("create Table users(useremail TEXT primary key,password TEXT)")
    }

    override fun onUpgrade(Mydb: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Mydb.execSQL("drop Table if exists users")
    }

    fun insertData(useremail:String?,password:String?,nickname:String?):Boolean{
        val MyDB=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put("useremail",useremail)
        contentValues.put("password",password)
        contentValues.put("nickname",nickname)
        val result=MyDB.insert("users",null,contentValues)
        return if (result==-1L) false else true
    }

    fun checkUseremail(useremail: String):Boolean{
        val MyDB=this.writableDatabase
        var res=true
        val cursor=MyDB.rawQuery("Select * from users where useremail=?", arrayOf(useremail))
        if (cursor.count<=0) res=false
        return res
    }
    fun checkUserpass(useremail: String,password: String):Boolean{
        val MyDB=this.writableDatabase
        var res=true
        val cursor=MyDB.rawQuery(
            "Select * from users where useremail=? and password=?", arrayOf(useremail,password)
        )
        if (cursor.count<=0)res=false
        return res
    }
    companion object{
        const val DBNAME ="Login.db"
    }
}
