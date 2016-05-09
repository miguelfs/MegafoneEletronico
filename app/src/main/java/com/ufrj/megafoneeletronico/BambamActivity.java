package com.ufrj.megafoneeletronico;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BambamActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    Button mButtonBambamShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bambam);

        //sugestão do Miguel: declare a variável mButtonBambamDoente junto da declaração
        //de mMediaPlayer e mButtonBambamShow. É a melhor prática de programação, visto que
        //poderemos reutilizar essas variáveis em métodos auxiliares fora do método onCreate.
        //Essa reutilização de variáveis fica claro no método que criei abaixo chamado setAudioFile

        Button mButtonBambamDoente  = (Button) findViewById(R.id.buttonBambamAjuda);
        mButtonBambamShow = (Button) findViewById(R.id.buttonBambamBodybuilder);


        //sugestão do Miguel: colocar o método setOnClickListener dentro de um laço if,
        //que verifique se a variável mButtonBambamDoente é null ou não.
        //Caso a variável NÃO SEJA null, podemos chamar o método "setOnClickListener.
        //Isso resolve o warning abaixo.


        mButtonBambamDoente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null){
                    mMediaPlayer.stop();
                }
                mMediaPlayer =  MediaPlayer.create(getApplicationContext(),
                        R.raw.bambam_ajuda_doente);
                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(), "CLICOU!", Toast.LENGTH_LONG).show();

            }
        });

        //sugestão do Miguel: Como há um padrão de repetição dentro das funções onClick dentro de
        //cada OnClickListener, criei uma função auxiliar para deixar o código mais sucinto.
        if (mButtonBambamShow!=null){
            mButtonBambamShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAudioFile(R.raw.bambam_aqui_bodybuilder);
                }
            });
        }

    }


    private void setAudioFile(int audioFileName) {
        if (mMediaPlayer != null){
            mMediaPlayer.stop();
        }
        mMediaPlayer =  MediaPlayer.create(getApplicationContext(),
                audioFileName);
        mMediaPlayer.start();
    }

}
