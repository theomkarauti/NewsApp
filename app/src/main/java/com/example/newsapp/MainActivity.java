package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,mscience,mhealth,mentertainment,msports;
    PageAdapter pageAdapter;
    Toolbar mtoolbar;

    String api = "d25e964aa06f42fd8346d33465ef16f7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);

        mscience = findViewById(R.id.science);

        mhealth= findViewById(R.id.health);

        mentertainment= findViewById(R.id.science);

        msports= findViewById(R.id.sport);


        //Pager for display data........

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);

        pageAdapter = new PageAdapter(getSupportFragmentManager(),6);

        viewPager.setAdapter(pageAdapter);



        tabLayout=findViewById(R.id.included);





        // fraGment manager....

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5 )
                {
                    pageAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}