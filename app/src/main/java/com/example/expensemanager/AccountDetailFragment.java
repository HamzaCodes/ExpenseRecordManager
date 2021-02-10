package com.example.expensemanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AccountDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,


                             Bundle savedInstanceState) {

        // Inflating the layout of account detail fragment

        View myView= inflater.inflate(R.layout.fragment_account_detail, container, false);


        EditText emailUser = myView.findViewById(R.id.email_account);
        EditText dateofCreation = myView.findViewById(R.id.dateofCreation);
        EditText timeOfCreation = myView.findViewById(R.id.timeOfCreation);
        EditText signInAt = myView.findViewById(R.id.lastSignInAt);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        emailUser.setText(user.getEmail());

        Long timestampCreate=user.getMetadata().getCreationTimestamp();

        Date dateObj = new Date(timestampCreate);

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd MMM yyyy");
        String dateAccCreated = dayFormat.format(dateObj);

        SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm:ss z");
        String TimeAccCreated = TimeFormat.format(dateObj);

        dateofCreation.setText(dateAccCreated);
        timeOfCreation.setText(TimeAccCreated);

        Long lastSingInDeatil=user.getMetadata().getLastSignInTimestamp();

        Date dateObj2 = new Date(lastSingInDeatil);
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd MMM yyyy        HH:mm:ss z");
        String SignInAt = dateTimeFormat.format(dateObj2);

        signInAt.setText(SignInAt);

        return myView;
    }
}