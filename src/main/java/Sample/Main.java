package Sample;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import Sample.Model.User;
import Sample.View.LoginMenu;
import org.springframework.boot.SpringApplication;

import static Sample.CodeByEmail.sendVerificationEmail;
import static Sample.LinkByEmail.sendAuthenticationEmail;

public class Main {
    public static void main(String[] args) {
        // Start Spring Boot application
        new Thread(() -> SpringApplication.run(Application.class, args)).start();

        // Allow some time for the Spring Boot application to start
        try {
            Thread.sleep(5000); // Sleep for 5 seconds to ensure the application is up
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Send authentication email
        String testEmail = "parhamashford@gmail.com";
        String testToken = "abc123"; // Replace with actual token generation logic
        LinkByEmail.sendAuthenticationEmail(testEmail, testToken);
        String testCode = "123456";
        CodeByEmail.sendVerificationEmail(testEmail, testCode);
//        User.loadUsers();
//
//        if (User.getUsers().isEmpty()) {
//            User user = new User("tom", "123", "", "");
//            user.setFactionSelected(Faction.Monsters);
//            user.setFactionLeader(Leader.BringerOfDeath);
//            user.getCommonCardsInDeck().add(CommonCard.Botchling);
//            user.getCommonCardsInDeck().add(CommonCard.Draug);
//            user.getCommonCardsInDeck().add(CommonCard.Leshen);
//            user.getCommonCardsInDeck().add(CommonCard.Kayran);
//            user.getCommonCardsInDeck().add(CommonCard.Toad);
//            user.getCommonCardsInDeck().add(CommonCard.ArachasBehemoth);
//            user.getCommonCardsInDeck().add(CommonCard.CroneWeavess);
//            user.getCommonCardsInDeck().add(CommonCard.CroneWhispess);
//            user.getCommonCardsInDeck().add(CommonCard.EarthElemental);
//            user.getCommonCardsInDeck().add(CommonCard.Fiend);
//            user.getCommonCardsInDeck().add(CommonCard.FireElemental);
//            user.getCommonCardsInDeck().add(CommonCard.Forktail);
//            user.getCommonCardsInDeck().add(CommonCard.GraveHag);
//            user.getCommonCardsInDeck().add(CommonCard.Griffin);
//            user.getCommonCardsInDeck().add(CommonCard.IceGiant);
//            user.getCommonCardsInDeck().add(CommonCard.PlagueMaiden);
//            user.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
//            user.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
//            user.getSpecialCardsInDeck().add(SpecialCard.Decoy);
//            user.getSpecialCardsInDeck().add(SpecialCard.Decoy);
//            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
//            user.getSpecialCardsInDeck().add(SpecialCard.Scorch);
//            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
//            user.getSpecialCardsInDeck().add(SpecialCard.Mardroeme);
//            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
//            user.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
//
//            User user2 = new User("alex", "123", "", "");
//            user2.setFactionSelected(Faction.Monsters);
//            user2.setFactionLeader(Leader.DestroyerOfWorlds);
//            user2.getCommonCardsInDeck().add(CommonCard.Ghoul);
//            user2.getCommonCardsInDeck().add(CommonCard.Imlerith);
//            user2.getCommonCardsInDeck().add(CommonCard.Harpy);
//            user2.getCommonCardsInDeck().add(CommonCard.Frightener);
//            user2.getCommonCardsInDeck().add(CommonCard.CroneBrewess);
//            user2.getCommonCardsInDeck().add(CommonCard.ArachasBehemoth);
//            user2.getCommonCardsInDeck().add(CommonCard.CroneWeavess);
//            user2.getCommonCardsInDeck().add(CommonCard.CroneWhispess);
//            user2.getCommonCardsInDeck().add(CommonCard.EarthElemental);
//            user2.getCommonCardsInDeck().add(CommonCard.Fiend);
//            user2.getCommonCardsInDeck().add(CommonCard.FireElemental);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimm);
//            user2.getCommonCardsInDeck().add(CommonCard.IceGiant);
//            user2.getCommonCardsInDeck().add(CommonCard.MysteriousElf);
//            user2.getCommonCardsInDeck().add(CommonCard.YenneferOfVengerberg);
//            user2.getCommonCardsInDeck().add(CommonCard.Villentretenmerth);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
//            user2.getCommonCardsInDeck().add(CommonCard.GaunterODimmDarkness);
//            user2.getSpecialCardsInDeck().add(SpecialCard.BitingFrost);
//            user2.getSpecialCardsInDeck().add(SpecialCard.ImpenetrableFog);
//            user2.getSpecialCardsInDeck().add(SpecialCard.ClearWeather);
//            user2.getSpecialCardsInDeck().add(SpecialCard.TorrentialRain);
//            user2.getSpecialCardsInDeck().add(SpecialCard.SkelligeStorm);
//            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
//            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
//            user2.getSpecialCardsInDeck().add(SpecialCard.CommandersHorn);
//
//            User.saveUsers();
//        }
//
//        LoginMenu.main(args);
    }
}
