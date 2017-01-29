package com.example.marti.practicafinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProducteSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Productes
    String sqlCreate = "CREATE TABLE Productes (id INTEGER, tipo TEXT, marca TEXT, nom TEXT, preu INTEGER)";

    public ProducteSQLiteHelper(Context contexto, String nom,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nom, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Productes");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}
