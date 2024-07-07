package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.utils.Pair;

import java.util.ArrayList;

public class EndGameController {
    ArrayList<Pair> players;

    public EndGameController(ArrayList<Pair> players) {
        this.players = players;
    }

    public String showInfo(String username) {
        Pair pair = getPlayerByName(username);
        if (pair == null) return "player does not exist";
        return pair.z;
    }

    private void sortPlayers() {
        players.sort(((o1, o2) -> Integer.parseInt(o2.y) - Integer.parseInt(o1.y)));
    }

    private Pair getPlayerByName(String name) {
        for (Pair pair : players) {
            if (pair.x.equals(name)) return pair;
        }
        return null;
    }

    public String showPlayers() {
        StringBuilder result = new StringBuilder();
        result.append("winner: ").append(players.get(0).x).append("\n");
        int index = 1;
        for (Pair player : players) {
            result.append(index).append(".").append(player.x).append("\t\t").append(player.y).append("\n");
            index++;
        }
        return result.toString();
    }

    private void updateScores() {
        User currentUser;
        for (Pair player : players) {
            currentUser = Gwent.getInstance().getUser(player.x);
            if (currentUser.getMaxScore() < Integer.parseInt(player.y))
                currentUser.setMaxScore(Integer.parseInt(player.y));
        }
    }
}
