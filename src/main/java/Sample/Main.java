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
            user.getCommonCardsInDeck().add(CommonCard.Cerys);
            user.getCommonCardsInDeck().add(CommonCard.ClanDrummondShieldmaiden);
            user.getCommonCardsInDeck().add(CommonCard.ClanDrummondShieldmaiden);
            user.getCommonCardsInDeck().add(CommonCard.ClanDrummondShieldmaiden);
            user.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user.getCommonCardsInDeck().add(CommonCard.Berserker);
            user.getCommonCardsInDeck().add(CommonCard.YoungBerserker);
            user.getCommonCardsInDeck().add(CommonCard.YoungBerserker);
            user.getCommonCardsInDeck().add(CommonCard.FireElemental);
            user.getCommonCardsInDeck().add(CommonCard.Forktail);
            user.getCommonCardsInDeck().add(CommonCard.GraveHag);
            user.getCommonCardsInDeck().add(CommonCard.Griffin);
            user.getCommonCardsInDeck().add(CommonCard.IceGiant);
            user.getCommonCardsInDeck().add(CommonCard.PlagueMaiden);
            user.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
            user.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
            user.getCommonCardsInDeck().add(CommonCard.ClanAnCraiteWarrior);
            user.getCommonCardsInDeck().add(CommonCard.ClanAnCraiteWarrior);
            user.getCommonCardsInDeck().add(CommonCard.ClanAnCraiteWarrior);
            user.getCommonCardsInDeck().add(CommonCard.Ermion);
            user.getCommonCardsInDeck().add(CommonCard.Olaf);
            user.getSpecialCardsInDeck().add(SpecialCard.BitingFrost);
            user.getSpecialCardsInDeck().add(SpecialCard.BitingFrost);
            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);

            User user2 = new User("alex", "123", "", "");
            user2.setFactionSelected(Faction.NorthernRealms);
            user2.setFactionLeader(Leader.KingOfTemeria);
            user2.getCommonCardsInDeck().add(CommonCard.Thaler);
            user2.getCommonCardsInDeck().add(CommonCard.Thaler);
            user2.getCommonCardsInDeck().add(CommonCard.PoorFuckingInfantry);
            user2.getCommonCardsInDeck().add(CommonCard.PoorFuckingInfantry);
            user2.getCommonCardsInDeck().add(CommonCard.PoorFuckingInfantry);
            user2.getCommonCardsInDeck().add(CommonCard.PoorFuckingInfantry);
            user2.getCommonCardsInDeck().add(CommonCard.Dandelion);
            user2.getCommonCardsInDeck().add(CommonCard.CrinfridReaversDragonHunter);
            user2.getCommonCardsInDeck().add(CommonCard.CrinfridReaversDragonHunter);
            user2.getCommonCardsInDeck().add(CommonCard.CrinfridReaversDragonHunter);
            user2.getCommonCardsInDeck().add(CommonCard.FireElemental);
            user2.getCommonCardsInDeck().add(CommonCard.Catapult);
            user2.getCommonCardsInDeck().add(CommonCard.Catapult);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
            user2.getCommonCardsInDeck().add(CommonCard.IceGiant);
            user2.getCommonCardsInDeck().add(CommonCard.MysteriousElf);
            user2.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
            user2.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
            user2.getCommonCardsInDeck().add(CommonCard.OlgierdVonEverc);
            user2.getSpecialCardsInDeck().add(SpecialCard.BitingFrost);
            user2.getSpecialCardsInDeck().add(SpecialCard.ImpenetrableFog);
            user2.getSpecialCardsInDeck().add(SpecialCard.ClearWeather);
            user2.getSpecialCardsInDeck().add(SpecialCard.TorrentialRain);
            user2.getSpecialCardsInDeck().add(SpecialCard.SkelligeStorm);
            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);

            User.saveUsers();
        }

        LoginMenu.main(args);
    }
}
