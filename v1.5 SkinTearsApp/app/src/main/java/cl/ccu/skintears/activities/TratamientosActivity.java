package cl.ccu.skintears.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.base.AbstractDrawerActivity;
import com.pdftron.pdf.controls.DocumentActivity;

public class TratamientosActivity extends AbstractDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


// ACCION DE BOTON AGREGADO POR MI
        Button openWithPDFTron1 = findViewById(R.id.open_pdf_pdftron1);
        openWithPDFTron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfWithPDFTron1();
            }
        });

// ACCION DE BOTON AGREGADO POR MI
        Button openWithPDFTron2 = findViewById(R.id.open_pdf_pdftron2);
        openWithPDFTron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfWithPDFTron2();
            }
        });


    }


    // VA ASOCIADO AL BOTON
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void openPdfWithPDFTron1() {
        DocumentActivity.openDocument(this, R.raw.guideline);
    }


    // VA ASOCIADO AL BOTON
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void openPdfWithPDFTron2() {
        DocumentActivity.openDocument(this, R.raw.classificationsystem);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_tratamientos;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
