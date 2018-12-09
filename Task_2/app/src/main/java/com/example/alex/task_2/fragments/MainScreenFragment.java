package com.example.irisha.task_2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.irisha.task_2.R;
import com.example.irisha.task_2.interfaces.ExitDialogHandler;

/**
 * Created by irisha on 27.10.2017.
 */

public class MainScreenFragment extends Fragment {

    // вызывается при начальной инициализации
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    // вызывается для создания представления
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View v =  inflater.inflate(R.layout.fragment_main, container, false);

        Button b = (Button) v.findViewById(R.id.exit_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ExitDialogHandler)getActivity()).onExit();
            }
        });
        return v;
    }

    // вызывается при приостановке - фрагмент еще видим
    @Override
    public void onPause(){
        super.onPause();
    }

    // вызывается при отсановке - когда он стал невидимым
    @Override
    public void onStop(){
        super.onStop();
    }

    // вызывается при уничтожении
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}

