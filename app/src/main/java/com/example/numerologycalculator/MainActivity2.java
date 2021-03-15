package com.example.numerologycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

//Extract the data.
        String name_number = bundle.getString("name_number");
        String life_path = intent.getStringExtra("life_path");
        String soul_urge = intent.getStringExtra("soul_urge");

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Life Path");
        arrayList.add("Expression");
        arrayList.add("Soul urge");

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Your Life Path is " +life_path );
        arrayList1.add("Your Expression number is  " + name_number);
        arrayList1.add("Your soul urge number is "  + soul_urge);

        prepareViewPager(viewPager,arrayList,arrayList1);

        tabLayout.setupWithViewPager(viewPager);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList, ArrayList<String> arrayList1) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        MainFragment fragment = new MainFragment();

        for (int i=0; i<arrayList.size();i++){
            Bundle bundle = new Bundle();
            // The text under the tabs is this
            bundle.putString("title",arrayList1.get(i));
            fragment.setArguments(bundle);
            // All the text is ignored if the following line is cmnted.
            adapter.addFragment(fragment,arrayList.get(i));
            fragment = new MainFragment();
            viewPager.setAdapter(adapter);

        }
    }

    private static class MainAdapter extends FragmentPagerAdapter {

        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {

            arrayList.add(title);
            fragmentList.add(fragment);


        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {

            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}
