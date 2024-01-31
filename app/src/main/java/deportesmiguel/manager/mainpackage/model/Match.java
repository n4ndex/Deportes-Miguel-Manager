package deportesmiguel.manager.mainpackage.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class Match implements Serializable {
    private Team localTeam;
    private List<Player> localTeamPlayers;
    private Team awayTeam;
    private List<Player> awayTeamPlayers;
    private String result;

    public Match(Team localTeam, List<Player> localTeamPlayers, String result) {
        this.localTeam = localTeam;
        this.localTeamPlayers = localTeamPlayers;
        this.result = result;
    }

    public Match(Team localTeam, List<Player> localTeamPlayers) {
        this.localTeam = localTeam;
        this.localTeamPlayers = localTeamPlayers;
    }

    public Match(Team localTeam) {
        this.localTeam = localTeam;
    }

    @NonNull
    @Override
    public String toString() {
        return new StringJoiner(", ", Match.class.getSimpleName() + "[", "]")
                .add("localTeam=" + localTeam)
                .add("localTeamPlayers=" + localTeamPlayers)
                .add("awayTeam=" + awayTeam)
                .add("awayTeamPlayers=" + awayTeamPlayers)
                .add("result='" + result + "'")
                .toString();
    }

    public Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(Team localTeam) {
        this.localTeam = localTeam;
    }

    public List<Player> getLocalTeamPlayers() {
        return localTeamPlayers;
    }

    public void setLocalTeamPlayers(List<Player> localTeamPlayers) {
        this.localTeamPlayers = localTeamPlayers;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Player> getAwayTeamPlayers() {
        return awayTeamPlayers;
    }

    public void setAwayTeamPlayers(List<Player> awayTeamPlayers) {
        this.awayTeamPlayers = awayTeamPlayers;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
