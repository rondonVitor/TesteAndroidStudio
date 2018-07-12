package com.example.cliente.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
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

public class SegundaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText analogico;
    EditText digitais;
    EditText ip;
    EditText semDisplay;
    EditText comDisplay;
    EditText comVideo;
    EditText softphone;
    int Ranalogico;
    int Rdigitais;
    int Rip;
    int RsemDisplay;
    int RcomDisplay;
    int RcomVideo;
    int Rsoftphone;
    Conteudo conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        analogico = findViewById(R.id.analogicoEditText);
        digitais = findViewById(R.id.digitaisEditText);
        ip = findViewById(R.id.ipEditText);
        semDisplay = findViewById(R.id.semDisplay);
        comDisplay = findViewById(R.id.comDisplay);
        comVideo = findViewById(R.id.videoEditText);
        softphone = findViewById(R.id.softphoneEditText);

        Bundle params = getIntent().getExtras();
        conteudo = (Conteudo) params.getSerializable("conteudo");

        semDisplay.setEnabled(false);
        comDisplay.setEnabled(false);
        comVideo.setEnabled(false);
        softphone.setEnabled(false);

        ip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String Rip1 = s.toString();
                if (!Rip1.trim().isEmpty()) {
                    int checagem = Integer.parseInt(Rip1);
                    if (checagem > 0) {
                        semDisplay.setEnabled(true);
                        comDisplay.setEnabled(true);
                        comVideo.setEnabled(true);
                        softphone.setEnabled(true);
                        semDisplay.setHint("0 - "+Rip1);
                        comDisplay.setHint("0 - "+Rip1);
                        comVideo.setHint("0 - "+Rip1);
                        softphone.setHint("0 - "+Rip1);
                    } else {
                        semDisplay.setEnabled(false);
                        comDisplay.setEnabled(false);
                        comVideo.setEnabled(false);
                        softphone.setEnabled(false);
                    }
                } else {
                    semDisplay.setEnabled(false);
                    comDisplay.setEnabled(false);
                    comVideo.setEnabled(false);
                    softphone.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
        getMenuInflater().inflate(R.menu.segunda, menu);
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

    public void continuar2 (View v) {
        String iRanalogico = analogico.getText().toString();
        String iRdigitais = digitais.getText().toString();
        String iRip = ip.getText().toString();
        String iRsemDisplay = semDisplay.getText().toString();
        String iRcomDisplay = comDisplay.getText().toString();
        String iRcomVideo = comVideo.getText().toString();
        String iRsoftphone = softphone.getText().toString();

        String erro = "ERRO!! \n";

        if (iRanalogico.trim().isEmpty()) {
            iRanalogico = "0";
        }
        if (iRdigitais.trim().isEmpty()) {
            iRdigitais = "0";
        }
        if (iRip.trim().isEmpty()) {
            iRip = "0";
        }
        if (iRsemDisplay.trim().isEmpty()) {
            iRsemDisplay = "0";
        }
        if (iRcomDisplay.trim().isEmpty()) {
            iRcomDisplay = "0";
        }
        if (iRcomVideo.trim().isEmpty()) {
            iRcomVideo = "0";
        }
        if (iRsoftphone.trim().isEmpty()) {
            iRsoftphone = "0";
        }

        if (!iRanalogico.trim().isEmpty()) {
            Ranalogico = Integer.parseInt(iRanalogico);

            if (Ranalogico < 0 || Ranalogico > 160) {
                erro += "Digite um valor de 0 a 160 no Ramal Analogico\n";
            }
        }
        if (!iRdigitais.trim().isEmpty()) {
            Rdigitais = Integer.parseInt(iRdigitais);

            if (Rdigitais < 0 || Rdigitais > 48) {
                erro += "Digite um valor de 0 a 48 no Ramal Digital\n";
            }
        }
        if (!iRip.trim().isEmpty()) {
            Rip = Integer.parseInt(iRip);

            if (Rip < 0 || Rip > 120) {
                erro += "Digite um valor de 0 a 120 no Ramal IP\n";
            }
        }
        if (!iRsemDisplay.trim().isEmpty()) {
            RsemDisplay = Integer.parseInt(iRsemDisplay);

        }
        if (!iRcomDisplay.trim().isEmpty()) {
            RcomDisplay = Integer.parseInt(iRcomDisplay);

        }
        if (!iRcomVideo.trim().isEmpty()) {
            RcomVideo = Integer.parseInt(iRcomVideo);

        }
        if (!iRsoftphone.trim().isEmpty()) {
            Rsoftphone = Integer.parseInt(iRsoftphone);

        }
        int sum1 = (Ranalogico+Rdigitais+Rip);

        if (sum1 == 0){
            erro+= "Pelo menos um dos campos de ramais deve ser maior que 1";
        }
        int sum = (RsemDisplay+RcomDisplay+RcomVideo+Rsoftphone);
        if (Rip > sum && Rip <= 120){
            erro += "O total de Ramais IP deve ser distribuido em sua totalidade\n";
        } else if (Rip < sum && Rip <=120) {
            erro += "O total de Ramais IP está menor que as distribuídas\n";
        }

        conteudo.Ranalogico = Ranalogico;
        conteudo.Rdigital = Rdigitais;
        conteudo.Rip = Rip;
        conteudo.RsemDisplay = RsemDisplay;
        conteudo.RcomDisplay = RcomDisplay;
        conteudo.RcomVideo = RcomVideo;
        conteudo.Rsoftphone = Rsoftphone;

        Intent it = new Intent(this, TerceiraActivity.class);

        it.putExtra("conteudo", conteudo);

        if (Ranalogico < 0 || Ranalogico > 160 || Rdigitais < 0 || Rdigitais > 48 || Rip < 0 || Rip > 120 || Rip > sum || Rip < sum || sum1 ==0) {
            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
        } else {
            startActivity(it);
            finish();
        }
    }
}
