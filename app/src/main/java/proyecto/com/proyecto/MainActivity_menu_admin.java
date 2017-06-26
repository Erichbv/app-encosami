package proyecto.com.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity_menu_admin extends Activity {
    private Button btnAgregarTarea,btnCalcularCpi,btnAgregarProy,btnListaproyecto,btnListaTarea,btnCerrar,btnCrearUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_admin);
        btnAgregarTarea=(Button)findViewById(R.id.btn_addTarea);
        btnCalcularCpi=(Button)findViewById(R.id.btn_calcular);
        btnAgregarProy=(Button)findViewById(R.id.btn_addProy);
        btnListaproyecto=(Button)findViewById(R.id.btn_listProy);
        btnListaTarea=(Button)findViewById(R.id.btn_listTareas) ;
        btnCerrar=(Button)findViewById(R.id.btn_cerrar);
        btnCrearUser=(Button)findViewById(R.id.btnUser);

        btnAgregarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tarea= new Intent(getApplicationContext(),Main2Activity_Agregar_Tarea.class);
                startActivity(tarea);
            }
        });
        btnCalcularCpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calcular= new Intent(getApplicationContext(),Main2Activity_calcular_CPI_SPI.class);
                startActivity(calcular);
            }
        });
        btnAgregarProy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proy=new Intent(getApplicationContext(),Main2Activity_agregar_proyecto.class);
                startActivity(proy);
            }
        });
        btnListaproyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listarP= new Intent(getApplicationContext(),Main2Activity_listar_proyecto.class);
                startActivity(listarP);
            }
        });
        btnListaTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent listarP= new Intent(getApplicationContext(),Main2Activity_listar_tarea.class);
                    startActivity(listarP);
                }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg("SESION FINALIZADA...");
                Intent login= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(login);
                finish();
            }
        });
        btnCrearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear_user= new Intent(getApplicationContext(),Main2Activity_crear_user.class);
                startActivity(crear_user);
            }
        });

    }
    public void msg(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
