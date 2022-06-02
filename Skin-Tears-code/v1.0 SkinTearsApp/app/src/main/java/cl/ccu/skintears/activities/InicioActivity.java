package cl.ccu.skintears.activities;

import android.os.Bundle;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.base.AbstractDrawerActivity;

public class InicioActivity extends AbstractDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_inicio;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
