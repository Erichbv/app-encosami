package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ERICH on 23/06/2017.
 */

public class Basedatos extends SQLiteOpenHelper {

   public static String DATABASE = "encosani_db";
   public static String TABLE_USER = "usuario";
   public static String TABLE_PROJECT = "proyecto";
   public static String TABLE_WORK = "tarea";

    private String sql_user = "create table " + TABLE_USER + "( id_user INTEGER primary key autoincrement, " +
            "user text not null, password text not null ,\n" +
            "tipo integer not null)";
    private String sql_project = "create table " + TABLE_PROJECT + "(id_proy integer primary key autoincrement,\n" +
            "nom_Empresa text not null,\n" +
            "nom_proy text not null,\n" +
            "encargado text not null,\n" +
            "tipo text not null,\n" +
            "presupuesto real not null,\n" +
            "fech_inicio date not null,\n" +
            "fech_fin date not null\n" +
            ")";
    private String sql_work = "create table " + TABLE_WORK + "( id_tarea integer primary key autoincrement,\n" +
            "nom_tarea text not null,\n" +
            "nom_encargado text not null,\n" +
            "id_proy integer,\n" +
            "fech_inicio date not null,\n" +
            "fech_fin date not null,\n" +
            "foreign key (id_proy) references proyecto(id_proy)\n" +
            ")";

    public Basedatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql_user);
        db.execSQL(sql_project);
        db.execSQL(sql_work);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP table if exists " + TABLE_USER);
        db.execSQL(sql_user);
    }

}