package cl.ccu.skintears.activities.evaluaciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.ccu.skintears.R;


public class MenuEvaluacion extends Activity implements View.OnClickListener {

    private Button vbtnJugar, btnResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluaciones);

        this.vbtnJugar = this.findViewById(R.id.btnJugarEval);
        this.btnResultados = this.findViewById(R.id.btnResultadosEval);
        //
        this.vbtnJugar.setOnClickListener(this);
        this.btnResultados.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnJugarEval) {
            this.startActivity(new Intent(MenuEvaluacion.this, PreguntasEvaluacion.class));
        } else if (view.getId() == R.id.btnResultadosEval) {
            this.startActivity(new Intent(MenuEvaluacion.this, Resultados.class));
        }
    }
}
