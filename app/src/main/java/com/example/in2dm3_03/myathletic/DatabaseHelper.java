package com.example.in2dm3_03.myathletic;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final int VERSION_BASEDATOS = 1;
    static final String NOMBRE_BASEDATOS = "socios";
    static final String NOMBRE_TABLA = "socios";
    static final String KEY_ROWID = "id";
    static final String KEY_NAME = "nombre";
    static final String KEY_UNAME = "uname";
    static final String KEY_PASS = "pass";
    SQLiteDatabase db;
    private static final String CREAR_TABLA="create table socios (id integer primary key not null , " +
            "nombre text not null , uname text not null, pass text not null);";

    public DatabaseHelper(Context context)
    {
        super(context,NOMBRE_BASEDATOS,null,VERSION_BASEDATOS);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREAR_TABLA);
        this.db =db;
    }

    public void insertContact(Contacto c){
        db=this.getWritableDatabase();
        ContentValues valores=new ContentValues();

        String query ="select * from socios";
        Cursor cursor = db.rawQuery(query,null);
        int count =cursor.getCount();

        valores.put(KEY_ROWID,count);
        valores.put(KEY_NAME,c.getNombre());
        valores.put(KEY_UNAME,c.getUname());
        valores.put(KEY_PASS,c.getPass());

        db.insert(NOMBRE_TABLA,null,valores);
        db.close();
    }

    public String searchPass(String uname ){

        db=this.getReadableDatabase();
        String query = "select uname, pass from "+NOMBRE_TABLA;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="no encontrado";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        String query ="DROP TABLE IF EXISTS "+NOMBRE_TABLA;
        db.execSQL(query);
        this.onCreate(db);
    }

}
