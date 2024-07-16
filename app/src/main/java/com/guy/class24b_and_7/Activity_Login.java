package com.guy.class24b_and_7;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Activity_Login extends AppCompatActivity {

    private AppCompatImageView login_IMG_back;
    private MaterialButton login_BTN_login;
    private MaterialTextView login_LBL_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_IMG_back = findViewById(R.id.login_IMG_back);
        login_BTN_login = findViewById(R.id.login_BTN_login);
        login_LBL_info = findViewById(R.id.login_LBL_info);
        login_BTN_login.setOnClickListener(v -> {
            checkForNewUser();
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            login_IMG_back.setRenderEffect(RenderEffect.createBlurEffect(100f, 100f, Shader.TileMode.CLAMP));
        }



        validateLogin();

    }

    private void login() {
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.TwitterBuilder().build(),
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.PhoneBuilder().build()
                ))
                .build();

        signInLauncher.launch(signInIntent);
    }

    private void validateLogin() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName("Guy")
//                .build();
//        user.updateProfile(profileUpdates);

        if (user != null) {
            login_LBL_info.setText(
                    user.getDisplayName() + "\n" +
                    user.getUid() + "\n" +
                    user.getProviderId() + "\n" +
                    user.getEmail() + "\n" +
                    user.getPhoneNumber()
            );
        } else {
            login_LBL_info.setText("No User");
        }
    }

    private ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            (result) -> {
                checkForNewUser();
                validateLogin();
            });

    private void checkForNewUser() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");
        usersRef.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if (user == null) {
                    updateUserData();
                }
                int x = 9;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void updateUserData() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");


        User user = new User();
        user.setId(firebaseUser.getUid())
                        .setName("Roi");
        usersRef.child(firebaseUser.getUid()).setValue(user);
    }

    public static void addFavoriteGameToUser(String gameId) {
        String userUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");

        usersRef.child(userUid).child("favorites").setValue()

    }
}
