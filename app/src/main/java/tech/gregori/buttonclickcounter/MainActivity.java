package tech.gregori.buttonclickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // variáveis representando os componentes que utilizaremos
    private EditText editText;
    private Button button;
    private TextView textView;
    private int numTimesClicked = 0; // quantas vezes o botão foi clicado?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atrela (faz bind) o componente no xml com a variável declarada na classe
        editText = findViewById(R.id.editText);  // getelementbyid
        editText.setText(""); // limpa o campo texto
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        // limpa o conteúdo do textview
        textView.setText("");
        // permite fazer um "scroll" no text view
        textView.setMovementMethod(new ScrollingMovementMethod());

        // cria um objeto do tipo evento para "escutar cliques" (onClickListener)
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();
                if (!result.equals("")) { // se o campo estiver preenchido
                    result += "\n";
                    textView.append(result);
                    editText.setText("");  // depois de inserir o texto, limpa o input
                }

            }
        };

        // atribui o "listener" criado ao botão
        button.setOnClickListener(onClickListener);
    }
}