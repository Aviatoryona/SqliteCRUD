package com.aviator.sqlitecrud.com.aviator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aviator.sqlitecrud.MainActivity;

import java.util.ArrayList;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentArrayList=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return fragmentArrayList.get(position).toString();
    }

    public void AddFrag(Fragment fragment){
        fragmentArrayList.add(fragment);
    }
}