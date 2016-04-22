package com.example.joanes.calculadorabasica;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.prefs.Preferences;

public class CalculadoraBasica extends AppCompatActivity implements View.OnClickListener{

    //Objetos utilizados no projeto.
    private EditText edTPrimeiro;
    private EditText edTSegundo;
    private TextView tVSaida;
    private RadioButton rBSoma;
    private RadioButton rBDividir;
    private RadioButton rBMultiplicar;
    private RadioButton rBSubtrair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_basica);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //pega os valores dos componestes
        edTPrimeiro = (EditText)findViewById(R.id.edTprimeiro);
        edTSegundo = (EditText)findViewById(R.id.edTSegundo);
        tVSaida = (TextView) findViewById(R.id.tVSaida);
        rBSoma = (RadioButton) findViewById(R.id.rBSoma);
        rBDividir = (RadioButton) findViewById(R.id.rBDividir);
        rBMultiplicar = (RadioButton) findViewById(R.id.rBMultiplicar);
        rBSubtrair = (RadioButton) findViewById(R.id.rBSubtrair);
    }

    public void onClick(View view){

        try{
            double valor1 = Double.parseDouble(edTPrimeiro.getText().toString());
            double valor2 = Double.parseDouble(edTSegundo.getText().toString());

            if(rBSoma.isChecked()){;
                tVSaida.setText(valor1 + valor2+"");
            }else{
                if(rBDividir.isChecked()){
                    tVSaida.setText(valor1 / valor2+"");
                }else{
                    if(rBMultiplicar.isChecked()){
                        tVSaida.setText(valor1 * valor2+"");
                    }else{
                        if(rBSubtrair.isChecked()){
                            tVSaida.setText(valor1 - valor2+"");
                        }else{
                            Toast.makeText(this, "Selecione uma Operação", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Digite valores nos campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpar(View view){
        edTPrimeiro.setText("");
        edTSegundo.setText("");
        tVSaida.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_basica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
