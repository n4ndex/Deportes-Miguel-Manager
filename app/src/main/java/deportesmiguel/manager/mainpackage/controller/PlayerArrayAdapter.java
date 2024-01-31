package deportesmiguel.manager.mainpackage.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import deportesmiguel.manager.mainpackage.R;
import deportesmiguel.manager.mainpackage.model.Player;

public class PlayerArrayAdapter extends ArrayAdapter<Player> {
    private Context context;
    private int resource;
    private List<Player> players;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public PlayerArrayAdapter(@NonNull Context context, int resource, @NonNull List<Player> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.players = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
        }
        Player player = players.get(position);
        ImageView playerImageView = convertView.findViewById(R.id.playerAvatarImageView);
//        playerImageView.setImageResource(player.getImage());
        playerImageView.setImageResource(R.drawable.avatar_image);
        TextView playerNameTextView = convertView.findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(player.getName());
        TextView playerDorsalTextView = convertView.findViewById(R.id.playerDorsalTextView);
        playerDorsalTextView.setText(String.valueOf(player.getDorsal()));
        TextView playerBirthDateTextView = convertView.findViewById(R.id.playerBirthDateTextView);
        playerBirthDateTextView.setText(player.getBirthDate().toString());
        return convertView;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
