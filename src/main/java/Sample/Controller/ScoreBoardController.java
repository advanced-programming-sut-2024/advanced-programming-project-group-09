package Sample.Controller;

import Sample.Model.User;
import javafx.scene.control.Label;

public class ScoreBoardController {


    public Label maxScore;
    public Label maxrangedScore;
    public Label maxsiegeScore;
    public Label maxcloseCombatScore;

    public void run() {
        maxScore.setText(maxScore.getText() + " " + User.getUserLoginIn().getMaxScore());
        maxsiegeScore.setText(maxScore.getText() + " " + User.getUserLoginIn().getMaxSiegeScore());
        maxrangedScore.setText(maxScore.getText() + " " + User.getUserLoginIn().getMaxRangedScore());
        maxcloseCombatScore.setText(maxScore.getText() + " " + User.getUserLoginIn().getMaxCloseCombatScore());
    }
}
