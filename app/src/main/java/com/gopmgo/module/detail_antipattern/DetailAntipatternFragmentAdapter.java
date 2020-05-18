package com.gopmgo.module.detail_antipattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aflah on 28/04/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */


public class DetailAntipatternFragmentAdapter extends FragmentPagerAdapter implements IFragmentAdapter {

    private static List<Fragment> fragmentList = new ArrayList<>();
    private static List<String> fragmentTitleList = new ArrayList<>();

    private static ISolutionConnector bandAidConnector;
    private static ISolutionConnector refactoringConnector;
    private static ISolutionConnector selfRepairConnector;

    public DetailAntipatternFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public static void injectBandAidConnector(ISolutionConnector _bandAidConnector) {
        bandAidConnector = _bandAidConnector;
    }

    public static void injectRefactoringConnector(ISolutionConnector _refactoringConnector) {
        refactoringConnector = _refactoringConnector;
    }

    public static void injectSelfRepairConnector(ISolutionConnector _selfRepairConnector) {
        selfRepairConnector = _selfRepairConnector;
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

    public static void addFragment(Fragment fragment, String fragmentTitle) {
        fragmentList.add(fragment);
        fragmentTitleList.add(fragmentTitle);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    @Override
    public void setViewPagerAdapter(ViewPager viewPager) {
        viewPager.setAdapter(this);
    }

    @Override
    public void setIdAntiPattern(int idAntiPattern) {
        bandAidConnector.setIdAntiPattern(idAntiPattern);
        selfRepairConnector.setIdAntiPattern(idAntiPattern);
        refactoringConnector.setIdAntiPattern(idAntiPattern);
    }
}
