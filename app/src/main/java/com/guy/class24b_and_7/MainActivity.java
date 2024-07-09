package com.guy.class24b_and_7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game()
                .setId("G01")
                .setTitle("Sid Meier’s Civilization")
                .setGenre(Game.GENRE.STRATEGY)
                .setDownloads(10_000_000)
                .setReviews(456_000)
                .setRating(4.6)
                .setSafe(true)
        );
        games.add(new Game()
                .setId("G02")
                .setTitle("Jurassic World Evolution")
                .setGenre(Game.GENRE.ARCADE)
                .setDownloads(45_000_000)
                .setReviews(34_000)
                .setRating(3.0)
                .setSafe(false)
        );
        games.add(new Game()
                .setId("G03")
                .setTitle("Planet Zoo")
                .setGenre(Game.GENRE.ACTION)
                .setDownloads(6_000_000)
                .setReviews(5_600)
                .setRating(4.6)
                .setSafe(true)
        );
        games.add(new Game()
                .setId("G04")
                .setTitle("Batman™: Arkham Knight")
                .setGenre(Game.GENRE.ACTION)
                .setDownloads(66_000_000)
                .setReviews(54_600)
                .setRating(42.4)
                .setSafe(false)
        );
        games.add(new Game()
                .setId("G05")
                .setTitle("Hogwarts Legacy")
                .setGenre(Game.GENRE.ARCADE)
                .setDownloads(66_000_000)
                .setReviews(54_600)
                .setRating(4.2)
                .setSafe(true)
        );


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gamesRef = database.getReference("games");
        DatabaseReference usersRef = database.getReference("users");


        for (Game game : games) {
            //gamesRef.child(game.getId()).setValue(game);
        }

        User guy = new User("123456789")
                .setName("Guy")
                .setEmail("guyi3@mail.afeka.ac.il");

        guy.addFavorite(games.get(0).getId());
        guy.addFavorite(games.get(3).getId());
        guy.addPurchase(games.get(0).getId());
        guy.addPurchase(games.get(1).getId());

        usersRef.child(guy.getId()).setValue(guy);


        updateGameRating("G01", 4.7);
    }

    private void updateGameRating(String gameId, double newRating) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gamesRef = database.getReference("games");
        gamesRef.child(gameId).child("rating").setValue(newRating);
    }
}