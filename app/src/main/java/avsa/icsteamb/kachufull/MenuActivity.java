package avsa.icsteamb.kachufull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.*;

public class MenuActivity extends AppCompatActivity {

    private Button instructions;
    private Button playGame;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        instructions = (Button) findViewById(R.id.btnRules);

        instructions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(MenuActivity.this, InstructionsActivity.class);
                startActivity(i);

            }

        });

        playGame = (Button) findViewById(R.id.btnPlay);

        playGame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(MenuActivity.this, PlayActivity.class);
                startActivity(i);

            }

        });

        exit = (Button) findViewById(R.id.btnExit);

        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                System.exit(0);
            }

        });

    }

}