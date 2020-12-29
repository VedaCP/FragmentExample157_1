package com.example.fragmentexample157_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentexample157_1.databinding.FragmentLoserBinding;

public class LoserFragment extends Fragment {
   private String name;
   FragmentLoserBinding binding;


   public LoserFragment() {
       // Required empty public constructor
   }
       private static final String ARG_PARAM1 = "param1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btLoser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLogoTriviaFragment();
            }
        });
    }



    private void addLogoTriviaFragment() {
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance2();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, logoTriviaFragment,
                        LogoTriviaFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
    public static LoserFragment newInstance(String mName) {
        LoserFragment fragment = new LoserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


}