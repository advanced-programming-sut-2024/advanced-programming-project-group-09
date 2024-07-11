package Sample;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import Sample.Model.User;
import Sample.View.LoginMenu;

public class Main {
    public static void main(String[] args) {
        User.loadUsers();

        if (User.getUsers().isEmpty()) {
            User user = new User("tom", "123", "", "");
            user.setFactionSelected(Faction.Skellige);
            user.setFactionLeader(Leader.KingBran);
            user.getCommonCardsInDeck().add(CommonCard.Botchling);
            user.getCommonCardsInDeck().add(CommonCard.Draug);
            user.getCommonCardsInDeck().add(CommonCard.Leshen);
            user.getCommonCardsInDeck().add(CommonCard.Kayran);
            user.getCommonCardsInDeck().add(CommonCard.Toad);
            user.getCommonCardsInDeck().add(CommonCard.ArachasBehemoth);
            user.getCommonCardsInDeck().add(CommonCard.CroneWeavess);
            user.getCommonCardsInDeck().add(CommonCard.CroneWhispess);
            user.getCommonCardsInDeck().add(CommonCard.EarthElemental);
            user.getCommonCardsInDeck().add(CommonCard.Fiend);
            user.getCommonCardsInDeck().add(CommonCard.FireElemental);
            user.getCommonCardsInDeck().add(CommonCard.Forktail);
            user.getCommonCardsInDeck().add(CommonCard.GraveHag);
            user.getCommonCardsInDeck().add(CommonCard.Griffin);
            user.getCommonCardsInDeck().add(CommonCard.IceGiant);
            user.getCommonCardsInDeck().add(CommonCard.PlagueMaiden);
            user.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
            user.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
            user.getSpecialCardsInDeck().add(SpecialCard.Decoy);
            user.getSpecialCardsInDeck().add(SpecialCard.Decoy);
            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);

            User user2 = new User("alex", "123", "", "");
            user2.setFactionSelected(Faction.Monsters);
            user2.setFactionLeader(Leader.DestroyerOfWorlds);
            user2.getCommonCardsInDeck().add(CommonCard.Ghoul);
            user2.getCommonCardsInDeck().add(CommonCard.Imlerith);
            user2.getCommonCardsInDeck().add(CommonCard.Harpy);
            user2.getCommonCardsInDeck().add(CommonCard.Frightener);
            user2.getCommonCardsInDeck().add(CommonCard.CroneBrewess);
            user2.getCommonCardsInDeck().add(CommonCard.ArachasBehemoth);
            user2.getCommonCardsInDeck().add(CommonCard.CroneWeavess);
            user2.getCommonCardsInDeck().add(CommonCard.CroneWhispess);
            user2.getCommonCardsInDeck().add(CommonCard.EarthElemental);
            user2.getCommonCardsInDeck().add(CommonCard.Fiend);
            user2.getCommonCardsInDeck().add(CommonCard.FireElemental);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
            user2.getCommonCardsInDeck().add(CommonCard.IceGiant);
            user2.getCommonCardsInDeck().add(CommonCard.MysteriousElf);
            user2.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
            user2.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getSpecialCardsInDeck().add(SpecialCard.BitingFrost);
            user2.getSpecialCardsInDeck().add(SpecialCard.ImpenetrableFog);
            user2.getSpecialCardsInDeck().add(SpecialCard.ClearWeather);
            user2.getSpecialCardsInDeck().add(SpecialCard.TorrentialRain);
            user2.getSpecialCardsInDeck().add(SpecialCard.SkelligeStorm);
            user2.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user2.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user2.getSpecialCardsInDeck().add(SpecialCard.Scorch);

            User.saveUsers();
        }

        LoginMenu.main(args);
    }
}
