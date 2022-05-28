package programacao.mobile.aplicacaoeleicoesnovo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Candidato[] candidatos = new Candidato[4];
    int maior = -1;
    int segundoMaior = -1;
    int indiceMaior = 0;
    int indiceSegundoMaior = 0;

    class Candidato{
        String nome;
        short quantidadeVotos;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public short getQuantidadeVotos() {
            return quantidadeVotos;
        }

        public void setQuantidadeVotos(short quantidadeVotos) {
            this.quantidadeVotos = quantidadeVotos;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity activity = this;
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int[] idViewNomes = {R.id.candidato1,R.id.candidato2,R.id.candidato3,R.id.candidato4};
                int[] idViewVotos = {R.id.votos1,R.id.votos2,R.id.votos3,R.id.votos4};
                for (int i = 0; i < idViewNomes.length; i++){
                    EditText editText = view.findViewById(idViewNomes[i]);
                    String nome = editText.getText().toString();
                    if (nome.equals("")) continue;
                    editText = view.findViewById(idViewVotos[i]);
                    try {
                        short quantidade = Short.parseShort(editText.getText().toString());
                        if (maior == -1 || maior < quantidade){
                            segundoMaior = maior;
                            indiceSegundoMaior = indiceMaior;
                            maior = quantidade;
                            indiceMaior = i;
                        }

                        candidatos[i] = new Candidato();
                        candidatos[i].setNome(nome);
                        candidatos[i].setQuantidadeVotos(quantidade);
                    }catch (Exception e){
                        Log.e("formatação", e.getMessage());
                        e.printStackTrace();
                        continue;
                    }
                }
                ((EditText)findViewById(idViewNomes[indiceMaior])).setTextColor(122);
                ((EditText)findViewById(idViewNomes[indiceMaior])).setTextColor(255);
            }
        });
    }
}