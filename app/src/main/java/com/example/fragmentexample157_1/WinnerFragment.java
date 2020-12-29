package com.example.fragmentexample157_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentexample157_1.databinding.FragmentLoserBinding;
import com.example.fragmentexample157_1.databinding.FragmentWinnerBinding;

public class WinnerFragment extends Fragment {
    private String name;
    FragmentWinnerBinding binding;

    public WinnerFragment() {
        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";

    public static WinnerFragment newInstance(String param1) {
        WinnerFragment fragment = new WinnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWinnerBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
        binding.buttonWinner.setOnClickListener(new View.OnClickListener() {
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

}