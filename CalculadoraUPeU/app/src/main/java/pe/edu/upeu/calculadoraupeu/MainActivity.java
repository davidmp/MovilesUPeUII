package pe.edu.upeu.calculadoraupeu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String valorA="";
    String valorB="";
    char operador=' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtResultado=(EditText)findViewById(R.id.textResult);
        Button btnBorrar=(Button)findViewById(R.id.btnBorrar);
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);
        Button btn5=(Button)findViewById(R.id.btn5);
        Button btn6=(Button)findViewById(R.id.btn6);
        Button btn7=(Button)findViewById(R.id.btn7);
        Button btn8=(Button)findViewById(R.id.btn8);
        Button btn9=(Button)findViewById(R.id.btn9);
        Button btn0=(Button)findViewById(R.id.btn0);
        Button btnPunto=(Button)findViewById(R.id.btnPunto);
        Button btnSuma=(Button)findViewById(R.id.btnSuma);
        Button btnResta=(Button)findViewById(R.id.btnResta);
        Button btnDivision=(Button)findViewById(R.id.btnDivision);
        Button btnMultiplicacion=(Button)findViewById(R.id.btnMulti);
        Button btnIgual=(Button)findViewById(R.id.btnIgual);

        View.OnClickListener onclik=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button accion=(Button)v;
                valorA+=accion.getText().toString();
                txtResultado.setText(valorA);
            }
        };

        btn1.setOnClickListener(onclik);
        btn2.setOnClickListener(onclik);
        btn3.setOnClickListener(onclik);
        btn4.setOnClickListener(onclik);
        btn5.setOnClickListener(onclik);
        btn6.setOnClickListener(onclik);
        btn7.setOnClickListener(onclik);
        btn8.setOnClickListener(onclik);
        btn9.setOnClickListener(onclik);
        btn0.setOnClickListener(onclik);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorA="";
                valorB="";
                operador=' ';
                txtResultado.setText("");
            }
        });

        View.OnClickListener onclikOperador= new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button oper=(Button)v;
                operador=oper.getText().charAt(0);
                valorB=valorA;
                valorA="";
                txtResultado.setText("");
            }
        };

        btnDivision.setOnClickListener(onclikOperador);
        btnMultiplicacion.setOnClickListener(onclikOperador);
        btnResta.setOnClickListener(onclikOperador);
        btnSuma.setOnClickListener(onclikOperador);

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double operadorResultado=0.0;
                switch (operador){
                    case '+': operadorResultado=Double.parseDouble(valorB)+ Double.parseDouble(valorA);break;
                    case '-': operadorResultado=Double.parseDouble(valorB)- Double.parseDouble(valorA);break;
                    case '/': operadorResultado=Double.parseDouble(valorB)/ Double.parseDouble(valorA);break;
                    case '*': operadorResultado=Double.parseDouble(valorB)* Double.parseDouble(valorA);break;
                    default:break;
                }
                txtResultado.setText(String.valueOf(operadorResultado));
                valorA="";
                valorB="";
                operador=' ';
            }
        });

    }
}
