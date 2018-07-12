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
import android.widget.Toast;

public class PrimeiraActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText digital;
    EditText analogico;
    EditText gsm;
    EditText ip;
    int Tdigital;
    int Tanalogico;
    int Tgsm;
    int Tip;

    Conteudo c = new Conteudo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        digital = findViewById(R.id.digitalEditText);
        analogico = findViewById(R.id.analEditText);
        gsm = findViewById(R.id.gsmEditText);
        ip = findViewById(R.id.ipEditText);

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
        getMenuInflater().inflate(R.menu.primeira, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.simular) {
            Intent it = new Intent(this, PrimeiraActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.simulacoesSalvas) {

        } else if (id == R.id.produtos) {
            Intent it = new Intent(this, ProdutoActivity.class);
            it.putExtra("conteudo", c);
            startActivity(it);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void continuar(View v) {

        String Tdigital1 = digital.getText().toString();
        String Tanalogico1 = analogico.getText().toString();
        String Tgsm1 = gsm.getText().toString();
        String Tip1 = ip.getText().toString();

        String erro = "ERRO!! \n";

        if (Tdigital1.trim().isEmpty()) {
            Tdigital1 = "0";
        }

        if (Tanalogico1.trim().isEmpty()) {
            Tanalogico1 = "0";
        }

        if (Tgsm1.trim().isEmpty()) {
            Tgsm1 = "0";
        }

        if (Tip1.trim().isEmpty()) {
            Tip1 = "0";
        }

        if (!Tdigital1.trim().isEmpty()) {
            Tdigital = Integer.parseInt(Tdigital1);

            if (Tdigital < 0 || Tdigital > 60) {
                erro += "Digite um valor de 0 e 60 no Tronco Digital\n";
            }
        }
        if (!Tanalogico1.trim().isEmpty()) {
            Tanalogico = Integer.parseInt(Tanalogico1);

            if (Tanalogico < 0 || Tanalogico > 24) {
                erro += "Digite um valor de 0 e 24 no Tronco Analogico\n";
            }
        }
        if (!Tgsm1.trim().isEmpty()) {
            Tgsm = Integer.parseInt(Tgsm1);

            if (Tgsm < 0 || Tgsm > 24) {
                erro += "Digite um valor de 0 e 24 no Tronco GSM\n";
            }
        }
        if (!Tip1.trim().isEmpty()) {
            Tip = Integer.parseInt(Tip1);

            if (Tip < 0 || Tip > 60) {
                erro += "Digite um valor de 0 e 60 no Tronco IP\n";
            }
        }


        c.Tdigital = Tdigital;
        c.Tanalogico = Tanalogico;
        c.Tgsm = Tgsm;
        c.Tip = Tip;

        Intent it = new Intent(this, SegundaActivity.class);

        it.putExtra("conteudo", c);

        if (Tdigital < 0 || Tdigital > 60 || Tanalogico < 0 || Tanalogico > 24 || Tgsm < 0 || Tgsm > 24 || Tip < 0 || Tip > 60) {
            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
        } else {
            startActivity(it);
            finish();
        }
    }
}
