package cl.ccu.skintears.activities.evaluaciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.EvaluacionesActivity;


//public class Resultados extends AbstractDrawerActivity {



/*RESULTADOS AL FINALIZAR LA EVALUACION*/

public class Resultados extends Activity implements View.OnClickListener {
    private Utilidad utilidad;
    private TextView txtResultados;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion_resultados);

        this.btnVolver = (Button) this.findViewById(R.id.btnVolverActResGuardados);
        this.utilidad = (Utilidad) getApplicationContext();
        this.txtResultados = (TextView) this.findViewById(R.id.txtResultados);
        this.txtResultados.setText(this.txtResultados.getText() + " \n\n" + Integer.toString(this.utilidad.getPuntuacion()) + " puntos.");
        this.btnVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnVolverActResGuardados) {
            this.startActivity(new Intent(Resultados.this, EvaluacionesActivity.class));
        }
    }
}






