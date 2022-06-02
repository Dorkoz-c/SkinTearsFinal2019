package cl.ccu.skintears.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.base.AbstractDrawerActivity;
import cl.ccu.skintears.tflitecamera.CameraActivity;

public class ReconocimientoActivity extends AbstractDrawerActivity {

    private Button activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        activityButton = (Button) findViewById(R.id.btn_compartir);

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ReconocimientoActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_reconocimiento;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
