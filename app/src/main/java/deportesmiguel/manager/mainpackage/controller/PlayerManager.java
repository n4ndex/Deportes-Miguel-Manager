package deportesmiguel.manager.mainpackage.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import deportesmiguel.manager.mainpackage.R;
import deportesmiguel.manager.mainpackage.model.Match;
import deportesmiguel.manager.mainpackage.model.Player;
import deportesmiguel.manager.mainpackage.model.Team;

public class PlayerManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_manager_view);
        // recieve bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        // get data from bundle
        List<Team> teams = (List<Team>) bundle.getSerializable("teams");
        List<Match> matches = (List<Match>) bundle.getSerializable("matches");
        Player player = (Player) bundle.getSerializable("player");
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

    }
}
