package pe.edu.upeu.upeuasistenciaqr;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pe.edu.upeu.dao.AsistenciaDAO;
import pe.edu.upeu.dao.EventoDAO;
import pe.edu.upeu.modelo.AsistenciaTO;
import pe.edu.upeu.servis.AsisteciaServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import pe.edu.upeu.dao.AsistenciaDao;
//import pe.edu.upeu.dao.EventoDao;

/**
 * Created by Docente on 5/02/2018.
 */

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {

    private static final String TAG = "SimpleScannerActivity";
    private ZXingScannerView mScannerView;
    EventoDAO eve;
    AsistenciaDAO asis;
    int idUsuario=0;
    Context cotex;

    Retrofit retrofit;
    AsisteciaServices asisteciaServices;
    String urlBase="http://172.22.90.54:7171/";

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
        Bundle bu=getIntent().getExtras();
        idUsuario=bu.getInt("idUsuario");
        this.cotex=this;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        //setContentView(R.layout.activity_main_qr);
        //Vistaescaner.stopCamera();
        // TextView resultado = (TextView) findViewById(R.id.idResultado);

        String dato = rawResult.getText();
        eve=new EventoDAO(cotex);
        asis=new AsistenciaDAO(cotex);
        int idEvento=eve.eventoActivo();
        String[] datosVcard = dato.split("\n");
        AsistenciaTO to=new AsistenciaTO();
        to.setIdEvento(idEvento);
        to.setIdPersona(2);
        to.setIdUsuario(idUsuario);

        to.setCodigo(datosVcard[2]);
        to.setNombres(datosVcard[3]);
        to.setCompanhia(datosVcard[3]);

        asis.registrarAsistencia(to);

        retrofit=new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create()).build();
        asisteciaServices=retrofit.create(AsisteciaServices.class);
        /*AsistenciaTO asitTO=new AsistenciaTO();
        asitTO.setIdEvento(idEvento);
        asitTO.setIdPersona(1);
        asitTO.setIdUsuario(idUsuario);*/
        registrarAsistencia(asisteciaServices,to,idEvento,idUsuario,2);





        //resultado.setText(dato);
        // Do something with the result here
        Log.v("Informacion: ","Lllego Aqui.....!");
        Log.v("Datos: ",dato);
        Log.v(TAG, rawResult.getText()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Toast.makeText(getApplicationContext(),
                dato, Toast.LENGTH_SHORT).show();
        // If you would like to resume scanning, call this method below:
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();*/
        mScannerView.resumeCameraPreview(this);
    }

    private void registrarAsistencia(AsisteciaServices asisteciaServices, AsistenciaTO to, int idEvento,int idUsuario,int idPersona){
                //to.setIdEvento(idEvento);
        Call<AsistenciaTO> call=asisteciaServices.guardarAsistencia(to,idEvento, idUsuario, idPersona);
        call.enqueue(new Callback<AsistenciaTO>() {
            @Override
            public void onResponse(Call<AsistenciaTO> call, Response<AsistenciaTO> response) {

            }
            @Override
            public void onFailure(Call<AsistenciaTO> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "No se Pudo Registrar la Asistencia "+t.getMessage(), Toast.LENGTH_LONG).show();
                //Log.e("ERROR","Error : "+t.getMessage());
            }
        });
    }

}