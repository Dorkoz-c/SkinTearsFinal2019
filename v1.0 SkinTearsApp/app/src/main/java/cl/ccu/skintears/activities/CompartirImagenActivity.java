package cl.ccu.skintears.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import cl.ccu.skintears.BuildConfig;
import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.base.AbstractDrawerActivity;
import cl.ccu.skintears.activities.reconocimiento.SubirImagenActivity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class CompartirImagenActivity<networkInfo> extends AbstractDrawerActivity {
    private static final int TAKE_PICTURE = 0;
    Uri mUri;
    Bitmap mPhoto;

    private Button activityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        activityButton = (Button) findViewById(R.id.btn_subir_foto_rec);

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CompartirImagenActivity.this, SubirImagenActivity.class);
                startActivity(intent);
            }
        });
    }


    public void sacarFoto(View view) {
        if (view.getId() == R.id.btn_foto_rec &&
                getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

            // Desde Android 5.1 el método recomendado para acceder a los archivos es utilizando
            // un FileProvider (que es una subclase de ContentProvider)
            // antiguamente se accedía directamente a través de la uri file:// pero ahora es
            // a través de content://
            Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
            // Antes era File f = new File(Environment.getExternalStorageDirectory(),  "foto.jpg");
            File f = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "foto.jpg");

            // Antes era mUri = Uri.fromFile(f); // Ej: file://sdcard/foto.jpg
            mUri = FileProvider.getUriForFile(CompartirImagenActivity.this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    f);

            i.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
            startActivityForResult(i, TAKE_PICTURE);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        //Cargamos la imagen guardada en la memoria SD en nuestro ImageView
                        mPhoto = android.provider.MediaStore.Images.Media.getBitmap(
                                getContentResolver(), mUri);
                        ((ImageView) findViewById(R.id.img_foto)).setImageBitmap(mPhoto);
                    } catch (Exception e) {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("HolaCamara", e.getMessage());
                    }
                }
        }
    }
























    @Override
    public int getLayoutId() {
        return R.layout.activity_compartir_imagen;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}

