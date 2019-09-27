package cl.ccu.skintears.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.base.AbstractDrawerActivity;
import cl.ccu.skintears.activities.evaluaciones.PreguntasEvaluacion;
import cl.ccu.skintears.activities.evaluaciones.Resultados;


public class EvaluacionesActivity extends AbstractDrawerActivity {


    private Button activityButton1; // YO LO AGREGUE
    private Button activityButton2; // YO LO AGREGUE


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // YO LO AGREGUE

        activityButton1 = (Button) findViewById(R.id.btnJugarEval);

        activityButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EvaluacionesActivity.this, PreguntasEvaluacion.class);
                startActivity(intent);
            }
        });


        // YO LO AGREGUE

        activityButton2 = (Button) findViewById(R.id.btnResultadosEval);

        activityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EvaluacionesActivity.this, Resultados.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_evaluaciones;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
