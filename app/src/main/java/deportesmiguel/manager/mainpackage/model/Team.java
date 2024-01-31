package deportesmiguel.manager.mainpackage.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.StringJoiner;

public class Team implements Serializable {
    private String name;
    private final Player[] players = new Player[10];

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("players=" + Arrays.toString(players))
                .toString();
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }
}
