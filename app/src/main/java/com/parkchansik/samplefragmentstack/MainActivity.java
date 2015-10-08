package com.parkchansik.samplefragmentstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment[] list = {StackkFragment.newInstance("one"),//프래그먼트를 만든다 .
            StackkFragment.newInstance("two"),
            StackkFragment.newInstance("three")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {//정상작동된다면
            getSupportFragmentManager().beginTransaction()//매니저를 통해서 트랜잭션을 통해서 추가한다.
                    .add(R.id.container, StackkFragment.newInstance("base")).commit();
        }

        Button btn = (Button)findViewById(R.id.btn_prev);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        });

        btn = (Button)findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count < list.length) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, list[count])//replace는 안에 있는것을 빼버리고 생성하는데 add는 그냥 겹쳐서 생성한다. 그러니까 안되는거
                            .addToBackStack(null)
                            .commit();
                } else {
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });
    }
}
