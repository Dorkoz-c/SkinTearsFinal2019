package cl.ccu.skintears.activities.evaluaciones;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.EvaluacionesActivity;


public class Despedida extends Activity implements View.OnClickListener {
    private Utilidad utilidad;
    private MediaPlayer sonGanador;
    private TextView txtDespedida;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion_despedida);

        this.btnVolver = (Button) this.findViewById(R.id.btnVolver_);
        this.utilidad = (Utilidad) getApplicationContext();
        this.txtDespedida = (TextView) this.findViewById(R.id.txtDespedida);
        this.txtDespedida.setText("Lograste " + this.utilidad.getPuntuacion() +
                " puntos. \n\nPuedes jugar nuevamente");
        this.sonGanador = MediaPlayer.create(this, R.raw.son_ganador);
        this.sonGanador.start();
        this.btnVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnVolver_) {
            this.startActivity(new Intent(Despedida.this, EvaluacionesActivity.class));
        }
    }
}
