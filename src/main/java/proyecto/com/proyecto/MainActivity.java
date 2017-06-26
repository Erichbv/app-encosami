package proyecto.com.proyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import database.Basedatos.*;

import database.Basedatos;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,password;
    private Button btnAceptar;
    private SQLiteDatabase db;
    private Basedatos ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText) findViewById(R.id.et_usuario);
        password=(EditText) findViewById(R.id.et_password);
        btnAceptar=(Button) findViewById(R.id.btn_aceptar);

        abrirDB();
        Cursor c= db.rawQuery("select * from "+Basedatos.TABLE_USER,null);
        if(!c.moveToFirst()){
            insertar();
        }


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDB();


               String usu = usuario.getText().toString();
                String pass = password.getText().toString();
                Cursor c = db.rawQuery("select tipo from " + Basedatos.TABLE_USER + " where user='" + usu + "' and password='" + pass + "'", null);
                if (c.moveToFirst()) {
                    int tipo = c.getInt(0);
                    if (tipo == 1) {
                        Intent menu=new Intent(getApplicationContext(),MainActivity_menu_admin.class);
                        startActivity(menu);
                    } else if (tipo == 0) {
                        Intent user=new Intent(getApplicationContext(),Main2ActivityUsuario.class);
                        startActivity(user);
                    }
                }else{
                    msg("INGRESE USUARIO | CONTRASEÑA CORRECTA");
                }
            }

        });


}

    public void msg(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    public void abrirDB(){
        ad=new Basedatos(getApplicationContext(),Basedatos.DATABASE,null,1);
        db=ad.getWritableDatabase();
    }


    public void insertar(){
        msg("insertando....");
        abrirDB();
        ContentValues data= new ContentValues();
        data.put("user","admin");
        data.put("password","admin");
        data.put("tipo",1);
        int id=(int)db.insert(Basedatos.TABLE_USER,null,data);
        if(id!=-1){
            msg("usuario insertado "+id);
        }else {
            msg("error");
        }

        msg("insertando....");
        abrirDB();
        ContentValues data2= new ContentValues();
        data2.put("user","user");
        data2.put("password","user");
        data2.put("tipo",0);
        int id2=(int)db.insert(Basedatos.TABLE_USER,null,data2);
        if(id2!=-1){
            msg("usuario insertado "+id2);
        }else {
            msg("error");
        }

    }
    public void eliminar(){
        msg("eliminando...");
        int cod=db.delete("usuario","id_user="+3,null);
        msg("DROP "+cod);
    }

}
