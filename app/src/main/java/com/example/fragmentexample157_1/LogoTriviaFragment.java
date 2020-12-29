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
import android.widget.RadioGroup;

import com.example.fragmentexample157_1.databinding.FragmentLogoTriviaBinding;


public class LogoTriviaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String name;
    private  int choice; // opcion selecionada

    private FragmentLogoTriviaBinding binding;

    public LogoTriviaFragment() {
        // Required empty public constructor
    }
    public static LogoTriviaFragment newInstance2() {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        return fragment;
    }

    public static LogoTriviaFragment newInstance(String mName) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mName);
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
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String greeting = getString(R.string.greeting, name);
        binding.tvName.setText(greeting);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiobutton = binding.radioGroup.findViewById(checkedId);
                int index = binding.radioGroup.indexOfChild(radiobutton);
                switch (index){
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                    case 3:
                        choice = 3;
                        break;
                    case 4:
                        choice = 4;
                        break;
                    default:
                        choice = 5;
                        break;
                }

            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( choice == 2){
                    //TODO poner el metodo de fragmento ganador
                    addWinnerFragment(name);
                } else {
                    addLoserFragment(name);

                }
            }
        });

    }

    //Todo crear metodo para ir al fragmento ganador
    private void addWinnerFragment(String name){
        WinnerFragment winnerFragment = WinnerFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, winnerFragment,
                        LogoTriviaFragment.class.getSimpleName())
                .addToBackStack(null);
        fragmentTransaction.commit();
    }


    //Todo crear el metodo para ir al fragmento perdedor.
    private void addLoserFragment(String name){
        LoserFragment loserFragment = LoserFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, loserFragment,
                        LogoTriviaFragment.class.getSimpleName())
                .addToBackStack(null);
        fragmentTransaction.commit();
    }

    //TODO no olvidar pasar como argumento el nombre del jugador.


}