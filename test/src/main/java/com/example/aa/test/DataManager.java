package com.example.aa.test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Timestamp;

/**
 * Created by 101 on 2016/4/12.
 */
public class DataManager {
    private Context mContext;
    private String DB_NAME="user.db";
    private Helper helper;
    private static String CREAT_USER=
            "CREATE TABLE user_inf (" +
            "username text," +
                    "id integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "pwd text, " +
                    "token text, " +
                    "last_time timestamp );";

    public DataManager(Context context){
        helper =new Helper(context,DB_NAME,null,1);
        helper.getWritableDatabase();
    }

    public class Helper extends SQLiteOpenHelper{

        public Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //创建，只能执行一次
            db.execSQL(CREAT_USER);
            Toast.makeText(mContext,"create succeeded",Toast.LENGTH_LONG);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public boolean upadtaUserData(UserData userData){
        SQLiteDatabase db=helper.getWritableDatabase();
        Timestamp now=new Timestamp(System.currentTimeMillis());
        db.execSQL("update  user_inf set pws=?,token=?,last_time=? where username=?",
                new String[]{

                        userData.getPwd(),
                        userData.getToken(),
                        now.getTime()+"",
                        userData.getUsername()
                });
        return true;
    }
    public UserData getUserData(String userName){
        UserData userData=new UserData();
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor;
        cursor=db.rawQuery("select * from user_inf where username=?",new String[]{userName});
        if(cursor==null || cursor.getCount()!=1)
            return null;
        cursor.moveToFirst();
        userData.setPwd(cursor.getString(cursor.getColumnIndex("pwd")));
        userData.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        userData.setToken(cursor.getString(cursor.getColumnIndex("token")));
        return userData;
    }
    public boolean addUserData(UserData userData){
        //用户名唯一性
        if(isUserExist(userData.getUsername()))
            return false;
        SQLiteDatabase db=helper.getWritableDatabase();
        Timestamp now=new Timestamp(System.currentTimeMillis());
        db.execSQL("insert into user_inf (username,pwd,token,last_time)values(?,?,?,?)",
                new String[]{
                        userData.getUsername(),
                        userData.getPwd(),
                        userData.getToken(),
                        now.getTime()+""
                });
        return true;
    }
    public boolean isUserExist(String userName){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor;
        cursor=db.rawQuery("select * from user_inf where username=?",new String[]{userName});
        if(cursor.getCount()==1)
            return true;
        else
            return false;
    }
    public boolean updateToken(String userName,String token){
        SQLiteDatabase db=helper.getWritableDatabase();
        //判断用户是否存在
        Cursor cursor;
        cursor=db.rawQuery("select * from user_inf where username=?",new String[]{userName});
        if(cursor.getCount()!=1)
            return false;
//        Timestamp now=new Timestamp(System.currentTimeMillis());
        //存在就写入token
        db.execSQL("update user_inf set token=? where username=?",new String[]{token,userName,});
        return true;
    }
    public String getToken(String userName){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor;
        cursor=db.rawQuery("select * from user_inf where username=?",new String[]{userName});
        if(cursor.getCount()!=0 && cursor!=null){
            cursor.moveToFirst();
            String token=cursor.getString(cursor.getColumnIndex("token"));
            return token;
        }
        return null;
    }
}


/**
 * 思路：
 *
 * 存储用户登录信息，包含用户名密码token。
 * 密码不能以明文方式存储。
 *
 * 最重要的是token
 * 为已经登陆过的用户提供token。
 *
 * 注册时候用明文发送到数据库，登陆时候使用密码的md5.
 *
 * 本地存储md5
 *
 *
 */
