package com.example.ian.innovo2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ian.innovo2.filtros.AllFragment;
import com.example.ian.innovo2.filtros.FiremanFragment;
import com.example.ian.innovo2.filtros.HealthCenterFragment;
import com.example.ian.innovo2.filtros.PoliceFragment;

/**
 * Created by ian on 14-11-17.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new AllFragment();
            case 1:
                return new FiremanFragment();
            case 2:
                return new HealthCenterFragment();
            case 3:
                return new PoliceFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
