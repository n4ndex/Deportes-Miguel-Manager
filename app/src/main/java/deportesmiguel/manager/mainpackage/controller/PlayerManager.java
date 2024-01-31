package deportesmiguel.manager.mainpackage.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import deportesmiguel.manager.mainpackage.R;
import deportesmiguel.manager.mainpackage.model.Match;
import deportesmiguel.manager.mainpackage.model.Player;
import deportesmiguel.manager.mainpackage.model.Team;

public class PlayerManager extends AppCompatActivity {
    private TextView titleTextView;
    private List<Team> teams;
    private List<Match> matches;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_manager_view);
        titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setOnClickListener(v -> {
            Bundle returnBundle = new Bundle();
            returnBundle.putSerializable("teams", (Serializable) teams);
            returnBundle.putSerializable("matches", (Serializable) matches);
            Intent returnIntent = new Intent(this, PlayersManager.class);
            returnIntent.putExtras(returnBundle);
            setResult(RESULT_OK, returnIntent);
            finish();
        });
        // recieve bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        // get data from bundle
        teams = (List<Team>) bundle.getSerializable("teams");
        matches = (List<Match>) bundle.getSerializable("matches");
        player = (Player) bundle.getSerializable("player");
        for (Match match : matches) {
            if (match.getLocalTeamPlayers() != null) {
                boolean played = false;
                int i = 0;
                while (!played && i < match.getLocalTeamPlayers().size()) {
                    if (match.getLocalTeamPlayers().get(i).equals(player)) {
                        played = true;
                    }
                    i++;
                }
                if (played) {
                    System.out.println("El jugador " + player.getName() + " ha jugado el partido " + match);
                } else {
                    System.out.println("El jugador " + player.getName() + " no ha jugado el partido " + match);
                }
            }
        }
        int option = 0;
        do {
            System.out.println("Que quieres hacer con el jugador " + player);
            System.out.println("1. Cambiar nombre");
            System.out.println("2. Cambiar apellidos");
            System.out.println("3. Cambiar posición");
            System.out.println("4. Cambiar fecha de nacimiento");
            System.out.println("5. Cambiar imagen");
            System.out.println("6. Salir");
        } while (option != 0);
        teams.get(0).getPlayers()[0].setName("Miguel Ángel");

    }
}
