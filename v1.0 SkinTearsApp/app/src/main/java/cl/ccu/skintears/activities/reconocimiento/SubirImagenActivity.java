package cl.ccu.skintears.activities.reconocimiento;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import cl.ccu.skintears.R;
import cl.ccu.skintears.activities.CompartirImagenActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class SubirImagenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBuscar;
    private Button btnSubir;

    private ImageView imageView;

    private EditText editTextName;

    private Bitmap bitmap;

    private int PICK_IMAGE_REQUEST = 1;

    private String UPLOAD_URL = "https://skintears.000webhostapp.com/upload.php";

    private String KEY_IMAGEN = "foto";
    private String KEY_NOMBRE = "nombre";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_imagen);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnSubir = (Button) findViewById(R.id.btnSubir);

        editTextName = (EditText) findViewById(R.id.editText);

        imageView = (ImageView) findViewById(R.id.imageView);

        btnBuscar.setOnClickListener(this);
        btnSubir.setOnClickListener(this);
    }


    public static boolean compruebaConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }



    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage() {
        //Mostrar el diálogo de progreso
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo Imagen", "Espere por favor . . .", false, false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();
                        //Mostrando el mensaje de la respuesta
                        Toast.makeText(SubirImagenActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();

                        //Showing toast
                        //Toast.makeText(SubirImagenActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(getBaseContext(),"ERROR DE CONEXION", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Convertir bits a cadena
                String imagen = getStringImagen(bitmap);

                //Obtener el nombre de la imagen
                String nombre = editTextName.getText().toString().trim();

                //Creación de parámetros
                Map<String, String> params = new Hashtable<String, String>();

                //Agregando de parámetros
                params.put(KEY_IMAGEN, imagen);
                params.put(KEY_NOMBRE, nombre);

                //Parámetros de retorno
                return params;
            }
        };

        //Creación de una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Agregar solicitud a la cola
        requestQueue.add(stringRequest);
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Configuración del mapa de bits en ImageView
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {

        if (v == btnBuscar) {
            showFileChooser();
        }

        if (v == btnSubir) {



            if (!compruebaConexion(this)) {
                Toast.makeText(getBaseContext(),"CONÉCTESE A INTERNET", Toast.LENGTH_LONG).show();
            }


            //INDICO QUE DEBE SELECCIONAR UNA IMAGEN PARA SUBIR
            if (bitmap == null){
                //Image doesn´t exist.
                Toast avisoSubaImagen = Toast.makeText(SubirImagenActivity.this, "SELECCIONE UNA IMAGEN", Toast.LENGTH_LONG);
                avisoSubaImagen.show();
            }else{
                uploadImage();

                //imageView.setImageDrawable(null);
                //imageView.setImageBitmap(null);
                //imageView.destroyDrawingCache();
                //imageView.setImageResource(0);
                //imageView.setImageResource(-1);
                //imageView.setBackground(null);
                //ImageView imageView = findViewById(R.id.imageView);
                //imageView.setImageResource(0);
/*
                    //Declaramos un Handler que hace de unión entre el hilo principal y el secundario
                    Handler handler = new Handler();
                    //Llamamos al método postDelayed
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            imageView.setImageResource(0);
                            bitmap = null;
                        }
                    }, 10000); // 10 segundos de "delay"

*/
            }
            //uploadImage();
            //bitmap = null;


        }
    }
}