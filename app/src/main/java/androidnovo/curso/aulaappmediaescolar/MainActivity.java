package androidnovo.curso.aulaappmediaescolar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText editMateria;
    EditText editnotaProva;
    EditText editnotaTrabalho;
    TextView txtResultado;
    TextView txtSitacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    String resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Lincando as variáveis com os ids do formulário.
        editMateria = findViewById(R.id.editMateria);
        editnotaProva = findViewById(R.id.editNotaProva);
        editnotaTrabalho = findViewById(R.id.editNotaTrabalho);
        txtResultado = findViewById(R.id.txtResultado);
        txtSitacaoFinal = findViewById(R.id.txtSituacaoFinal);

        btnCalcular = findViewById(R.id.btnCalcular);


        //Programando o botão calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aqui é necessário fazer um parse de String p/ Double.
                notaProva = Double.parseDouble(editnotaProva.getText().toString());
                notaTrabalho = Double.parseDouble(editnotaTrabalho.getText().toString());

                media = (notaProva + notaTrabalho)/2; //calculando a média
                txtResultado.setText(String.valueOf(media));//atenção ao cast de Double p/ String

                if(media>=7) txtSitacaoFinal.setText("Aprovado");
                else txtSitacaoFinal.setText("Reprovado");
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App Média Escolar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
