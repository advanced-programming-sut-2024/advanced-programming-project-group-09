package Sample.Model;

import Sample.CardEnums.SpecialCard;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameBattleField {
    private final User user1;
    private final User user2;
    private final ArrayList<SpecialCard> weatherCards = new ArrayList<>();

    public GameBattleField(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public void saveGameState(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameBattleField loadGameState(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameBattleField.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}