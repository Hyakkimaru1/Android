package com.example.dulich;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class user extends Fragment {
    ImageView imageView;
    TextView textView;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false) ;
        Bundle bundle = getArguments();
        if (bundle!=null)
        {
            textView = view.findViewById( R.id.name );
            imageView=view.findViewById(R.id.avatar);
           textView.setText( bundle.getString( "Email" ) );
            Toast.makeText(getContext(),bundle.getString( "avatar" ),Toast.LENGTH_SHORT).show();
           Picasso.get().load( bundle.getString( "avatar" ) ).into( imageView );
        }
        return view;
    }
}
