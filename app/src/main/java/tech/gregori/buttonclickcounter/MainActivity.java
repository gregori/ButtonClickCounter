package tech.gregori.buttonclickcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // variáveis representando os componentes que utilizaremos
    private EditText editText;
    private Button button;
    private TextView textView;
    private static final String TEXT_CONTENTS = "TextContents"; // constante "chave"
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
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
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        // buscar valor contido na chave TEXT_CONTENTS do armazenamento local do celular
        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
        textView.setText(savedString); // insere a string no textview
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        // armazena o conteúdo da textview no armazenamento local do celular, na chave TEXT_CONTENTS
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }
}