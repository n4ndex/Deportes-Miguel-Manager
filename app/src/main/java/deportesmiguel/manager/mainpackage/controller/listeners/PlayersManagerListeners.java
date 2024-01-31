package deportesmiguel.manager.mainpackage.controller.listeners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.Serializable;

import deportesmiguel.manager.mainpackage.MainMenu;
import deportesmiguel.manager.mainpackage.controller.PlayerManager;
import deportesmiguel.manager.mainpackage.controller.PlayersManager;

public class PlayersManagerListeners implements AdapterView.OnItemClickListener {
    PlayersManager playersManager;

    public PlayersManagerListeners(PlayersManager playersManager) {
        this.playersManager = playersManager;
    }


    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.playersManager, "Has pulsado el elemento " + position, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putSerializable("teams", (Serializable) this.playersManager.getTeams());
        bundle.putSerializable("matches", (Serializable) this.playersManager.getMatches());
        bundle.putSerializable("player", this.playersManager.getTeams().get(0).getPlayers()[position]);
        Intent intent = new Intent(this.playersManager, PlayerManager.class);
        intent.putExtras(bundle);
        this.playersManager.startActivityForResult(intent, 1);
    }
}
