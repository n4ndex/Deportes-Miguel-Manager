package deportesmiguel.manager.mainpackage.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import deportesmiguel.manager.mainpackage.R;
import deportesmiguel.manager.mainpackage.controller.listeners.PlayersManagerListeners;
import deportesmiguel.manager.mainpackage.model.Match;
import deportesmiguel.manager.mainpackage.model.Player;
import deportesmiguel.manager.mainpackage.model.Team;

public class PlayersManager extends AppCompatActivity {
    private List<Team> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();
    private ListView playersListView;
    private PlayerArrayAdapter playerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_manager_view);
        generateData();
        findViews();
        playersListView.setOnItemClickListener(new PlayersManagerListeners(this));
        playerArrayAdapter = new PlayerArrayAdapter(this, R.layout.players_listview_row, Arrays.asList(teams.get(0).getPlayers()));
        playersListView.setAdapter(playerArrayAdapter);
    }

    private void findViews() {
        playersListView = findViewById(R.id.playersListView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                List<Team> recTeams = (List<Team>) bundle.getSerializable("teams");
                this.teams = recTeams;
                List<Match> recMatches = (List<Match>) bundle.getSerializable("matches");
                this.matches = recMatches;
                playerArrayAdapter.setPlayers(Arrays.asList(teams.get(0).getPlayers()));
                playerArrayAdapter.notifyDataSetChanged();
            }
        }
    }

    private void generateData() {
        Calendar calendar = Calendar.getInstance();
        teams.add(new Team("Deportes Miguel FC"));
        calendar.set(1996, 3, 30);
        teams.get(0).getPlayers()[0] = new Player("Miguel", "García", 1, calendar.getTime(), getResources().getString(R.string.goalkeeper));
        calendar.set(2005, 3, 25);
        teams.get(0).getPlayers()[1] = new Player("Jorge", "Fernández", 2, calendar.getTime(), getResources().getString(R.string.defender));
        calendar.set(1999, 3, 20);
        teams.get(0).getPlayers()[2] = new Player("Javier", "Gasol", 3, calendar.getTime(), getResources().getString(R.string.defender), R.drawable.ic_launcher_foreground);
        calendar.set(1998, 3, 15);
        teams.get(0).getPlayers()[3] = new Player("Jose", "Pérez", 4, calendar.getTime(), getResources().getString(R.string.defender));
        calendar.set(1997, 3, 10);
        teams.get(0).getPlayers()[4] = new Player("Juan", "Jiménez", 5, calendar.getTime(), getResources().getString(R.string.defender));
        calendar.set(1996, 3, 5);
        teams.get(0).getPlayers()[5] = new Player("Alex", "Velasco", 6, calendar.getTime(), getResources().getString(R.string.midfielder));
        calendar.set(1995, 3, 30);
        teams.get(0).getPlayers()[6] = new Player("Ilia", "Mingo", 7, calendar.getTime(), getResources().getString(R.string.midfielder));
        calendar.set(1994, 3, 25);
        teams.get(0).getPlayers()[7] = new Player("Hutch", "Páez", 8, calendar.getTime(), getResources().getString(R.string.midfielder));
        calendar.set(1993, 3, 20);
        teams.get(0).getPlayers()[8] = new Player("Rafa", "Maldonado", 9, calendar.getTime(), getResources().getString(R.string.forward));
        calendar.set(1992, 3, 15);
        teams.get(0).getPlayers()[9] = new Player("Ángel", "Martínez", 10, calendar.getTime(), getResources().getString(R.string.forward));

        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()), "2-1"));
        matches.add(new Match(teams.get(0)));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers())));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[0], teams.get(0).getPlayers()[5]), "2-1"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[0], teams.get(0).getPlayers()[7], teams.get(0).getPlayers()[6]), "0-1"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[9], teams.get(0).getPlayers()[8]), "1-1"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[9], teams.get(0).getPlayers()[8])));
        matches.add(new Match(teams.get(0), Collections.singletonList(teams.get(0).getPlayers()[9])));
        matches.add(new Match(teams.get(0)));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[0], teams.get(0).getPlayers()[1]), "1-0"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[2], teams.get(0).getPlayers()[3]), "0-0"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[4], teams.get(0).getPlayers()[5]), "2-2"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[6], teams.get(0).getPlayers()[7]), "3-1"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[8], teams.get(0).getPlayers()[9]), "0-1"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[1], teams.get(0).getPlayers()[3]), "1-2"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[5], teams.get(0).getPlayers()[7]), "2-3"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[9], teams.get(0).getPlayers()[0]), "3-0"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[2], teams.get(0).getPlayers()[4]), "0-2"));
        matches.add(new Match(teams.get(0), Arrays.asList(teams.get(0).getPlayers()[6], teams.get(0).getPlayers()[8]), "2-1"));
        matches.add(new Match(teams.get(0)));
        System.out.println(teams);
        System.out.println(matches);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public ListView getPlayersListView() {
        return playersListView;
    }

    public void setPlayersListView(ListView playersListView) {
        this.playersListView = playersListView;
    }

    public PlayerArrayAdapter getPlayerArrayAdapter() {
        return playerArrayAdapter;
    }

    public void setPlayerArrayAdapter(PlayerArrayAdapter playerArrayAdapter) {
        this.playerArrayAdapter = playerArrayAdapter;
    }
}
