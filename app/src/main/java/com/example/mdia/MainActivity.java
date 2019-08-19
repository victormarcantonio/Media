package com.example.mdia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editM1;
    private EditText editNI;
    private EditText editND;
    private EditText editMedia;
    private TextView textResultado;
    private TextView textMedia;
    //private double m1;
    //private double nD;
    //private double nI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editM1 = findViewById(R.id.editM1);
        editNI = findViewById(R.id.editNI);
        editND = findViewById(R.id.editND);
        textMedia = findViewById(R.id.textMedia);
        textResultado = findViewById(R.id.textResultado);


        }

     public void calculoMediaFinal(View view){

        double m1 = Double.parseDouble(editM1.getText().toString());
        double nD = Double.parseDouble(editND.getText().toString());
        double nI = Double.parseDouble(editNI.getText().toString());

         Boolean camposValidados = this.validarCampos(m1,nD,nI);
         if(camposValidados){
             this.calculoMedias(m1,nD,nI);

         }else{
             textResultado.setText("Preencha os campos corretamente!");
         }


     }

     public void calculoMedias(double m1, double nD, double nI){

         double m2 = (nD*0.7+nI*0.3);
         double mediaFinal =((m1+(m2*2))/3);
         if(mediaFinal<5){
             textMedia.setText("Média "+String.format("%.01f",mediaFinal));
             textResultado.setText("Você está reprovado");
         }
         else{
             textMedia.setText("Média "+String.format("%.01f",mediaFinal));
             textResultado.setText("Você está aprovado");
         }

     }
    public Boolean validarCampos(double m1, double nI, double nD){
        Boolean camposValidados = true;

        //Validar campos
        if((m1< 0 || m1 > 10) ) {
            camposValidados = false;
        }
        else if((nD<0 || nD>10) )  {
            camposValidados = false;
        }
        else if((nI<0 || nI>10) ) {
            camposValidados = false;
        }

        return camposValidados;
    }

}
