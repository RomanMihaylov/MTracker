package com.example.roma.mtracker_v3.vieww;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.roma.mtracker_v3.R;

import java.util.Date;

import com.example.roma.mtracker_v3.model.Item;
import com.example.roma.mtracker_v3.model.Singleton;
import io.codetail.widget.RevealLinearLayout;


public class FragmentInsert extends Fragment {

    private Window mWindow;
    private Point revealCenter;
    private AppBarLayout mAppBarLayout2;
    private RevealLinearLayout circleLayout;
    private Toolbar mToolbar;
    private TextView incomeText;
    private TextView outcomeText;
    private TextView value;
    private TextView n1;
    private TextView n2;
    private TextView n3;
    private TextView n4;
    private TextView n5;
    private TextView n6;
    private TextView n7;
    private TextView n8;
    private TextView n9;
    private TextView n0;
    private int xC;
    private int yC;
    public int pl_mn = 1;
    private TextView minus;
    Singleton mSingleton;

    private int toolbarColors[];

    private OnFragmentInssertListener mListener;

    public interface OnFragmentInssertListener {
        public void onFragmentInteraction(int i);
    }


    public FragmentInsert() {
        // Required empty public constructor
    }

    public static FragmentInsert newInstance() {
        FragmentInsert fragment = new FragmentInsert();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInssertListener) {
            mListener = (OnFragmentInssertListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInssertListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_in, container, false);

        mSingleton = Singleton.get();
        initColors();
        initAllViews(view);
        initAllListeners(view);
        return view;
    }

    private void updateColors(int i) {
        revealToolbar();
        mAppBarLayout2.setBackgroundColor(toolbarColors[i]);
        mToolbar.setBackgroundColor(toolbarColors[i]);
        mWindow.setStatusBarColor(toolbarColors[i]);
    }

    private void revealToolbar() {
        revealCenter = new Point(xC, yC);
        Animator anim = ViewAnimationUtils.createCircularReveal(mAppBarLayout2,
                revealCenter.x, revealCenter.y,
                0, mToolbar.getWidth() * 2);
        anim.setDuration(1000).start();
    }

    private void initColors() {
        toolbarColors = new int[2];
        toolbarColors[0] = color(R.color.primary);
        toolbarColors[1] = color(R.color.red);
    }

    private int color(@ColorRes int res) {
        return ContextCompat.getColor(getContext(), res);
    }

    private void initAllViews(View view) {

        mWindow = getActivity().getWindow();

        n1 = (TextView) view.findViewById(R.id.n1);
        n2 = (TextView) view.findViewById(R.id.n2);
        n3 = (TextView) view.findViewById(R.id.n3);
        n4 = (TextView) view.findViewById(R.id.n4);
        n5 = (TextView) view.findViewById(R.id.n5);
        n6 = (TextView) view.findViewById(R.id.n6);
        n7 = (TextView) view.findViewById(R.id.n7);
        n8 = (TextView) view.findViewById(R.id.n8);
        n9 = (TextView) view.findViewById(R.id.n9);
        n0 = (TextView) view.findViewById(R.id.n0);
        minus = (TextView) view.findViewById(R.id.minus);
        minus.setVisibility(View.INVISIBLE);

        value = (TextView) view.findViewById(R.id.value);
        incomeText = (TextView) view.findViewById(R.id.incomeText);
        outcomeText = (TextView) view.findViewById(R.id.outcomeText);

        circleLayout = (RevealLinearLayout) view.findViewById(R.id.layer2);
        mAppBarLayout2 = (AppBarLayout) view.findViewById(R.id.appbar2);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);

    }


    private void initAllListeners(View view) {

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "1");
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "2");
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "3");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "4");
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "0");
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "5");
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "9");
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "6");
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "7");
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(value.getText() + "8");
            }
        });

        incomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xC = (int) v.getX();
                yC = (int) v.getY();
                pl_mn = 1;
                circleLayout.setBackgroundColor(toolbarColors[1]);
                updateColors(0);
                mListener.onFragmentInteraction(1);
                minus.setVisibility(View.INVISIBLE);
            }
        });

        outcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xC = (int) v.getX();
                yC = (int) v.getY();
                pl_mn = 0;
                Log.v("MSGER", xC + " " + yC);
                circleLayout.setBackgroundColor(toolbarColors[0]);
                updateColors(1);
                mListener.onFragmentInteraction(0);
                minus.setVisibility(View.VISIBLE);

            }
        });
    }

    private Item buildItem(int value, int pl_mn, Date date) {
        Item item = new Item();
        item.setDate(date);
        item.setPl_mn(pl_mn);
        item.setValue(value);

        return item;
    }


//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        revealCenter = new Point((int)event.getX(),(int) event.getY());
//
//        return true;
//    }


    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


}