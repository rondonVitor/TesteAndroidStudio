package com.example.cliente.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class TerceiraActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText gravacao1;
    EditText correio1;
    EditText mesa1;
    EditText disa1;
    Switch tarifacao;
    int gravacao;
    int correio;
    int mesa;
    int disa;
    Conteudo conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gravacao1 = findViewById(R.id.gravacaoEditText);
        correio1 = findViewById(R.id.correioEditText);
        mesa1 = findViewById(R.id.mesaEditText);
        disa1 = findViewById(R.id.disaEditText);
        tarifacao = findViewById(R.id.tarifacao);

        Bundle params = getIntent().getExtras();
        conteudo = (Conteudo) params.getSerializable("conteudo");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.terceira, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.simular) {
            Intent it = new Intent(this, PrimeiraActivity.class);
            it.putExtra("conteudo", conteudo);
            startActivity(it);
            finish();
        } else if (id == R.id.simulacoesSalvas) {

        } else if (id == R.id.produtos) {
            Intent it = new Intent(this, ProdutoActivity.class);
            it.putExtra("conteudo", conteudo);
            startActivity(it);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void finalizar (View v){

        String igravacao = gravacao1.getText().toString();
        String icorreio = correio1.getText().toString();
        String imesa = mesa1.getText().toString();
        String idisa = disa1.getText().toString();

        String erro = "ERRO!! \n";

        if (igravacao.trim().isEmpty()){
            igravacao = "0";
        }
        if (icorreio.trim().isEmpty()){
            icorreio = "0";
        }
        if (imesa.trim().isEmpty()){
            imesa = "0";
        }
        if (idisa.trim().isEmpty()){
            idisa = "0";
        }

        if (!igravacao.trim().isEmpty()) {
            gravacao = Integer.parseInt(igravacao);

            if(gravacao <0 || gravacao >8){
                erro += "Digite um valor de 0 a 8 na Gravação de Chamadas\n";
            }
        }
        if (!icorreio.trim().isEmpty()) {
            correio = Integer.parseInt(icorreio);

            if(correio <0 || correio >160){
                erro += "Digite um valor de 0 a 160 no Correio de Voz\n";
            }

        }
        if (!imesa.trim().isEmpty()) {
            mesa = Integer.parseInt(imesa);

            if(mesa <0 || mesa >10 ){
                erro += "Digite um valor de 0 a 10 no Mesa Virtual\n";
            }
        }
        if (!idisa.trim().isEmpty()) {
            disa = Integer.parseInt(idisa);

            if(disa <0 || disa >20){
                erro += "Digite um valor de 0 a 20 no DISA\n";
            }
        }

        conteudo.gravacao = gravacao;
        conteudo.correio = correio;
        conteudo.mesa = mesa;
        conteudo.disa = disa;

        Intent it = new Intent(this, ResultadoActivity.class);

        it.putExtra("conteudo", conteudo);
        if (gravacao < 0 || gravacao > 8 || correio < 0 || correio > 160 || mesa < 0 || mesa > 10 || disa < 0 || disa > 20) {
            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
        } else {
            startActivity(it);
            finish();
        }
    }
}
