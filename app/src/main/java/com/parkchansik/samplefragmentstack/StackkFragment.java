package com.parkchansik.samplefragmentstack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StackkFragment extends Fragment {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_NAME = "name";
//    private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String name;
    public static StackkFragment newInstance(String name){
        StackkFragment fragment=new StackkFragment();
        Bundle args=new Bundle();
        args.putString(ARG_NAME, name);;
        fragment.setArguments(args);
        return fragment;
    }
    public StackkFragment() {
        // Required empty public constructor
    }
TextView nameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            name=getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_stack,container,false);
        nameView=(TextView)v.findViewById(R.id.text_name);
        nameView.setText(name);
        return v;
        // Inflate the layout for this fragment

    }


}
