package com.example.musicapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.R;
import com.example.musicapp.recycleviews.ModelCategoryFragment;
import com.example.musicapp.recycleviews.ModelTag;
import com.example.musicapp.recycleviews.RecycleViewCategoryFragmentAdapter;
import com.example.musicapp.recycleviews.RecycleViewHomeTagsAdapter;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    ArrayList<ModelCategoryFragment> dataholderCatFr;
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
//    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerViewTag = view.findViewById(R.id.recyclerviewcategoryfragment);
        recyclerViewTag.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false));

        //Tags recycle view fill
        dataholderCatFr = new ArrayList<>();
        ModelCategoryFragment cat1 = new ModelCategoryFragment("Women");
        dataholderCatFr.add(cat1);
        ModelCategoryFragment cat2 = new ModelCategoryFragment("Divided");
        dataholderCatFr.add(cat2);
        ModelCategoryFragment cat3 = new ModelCategoryFragment("Men");
        dataholderCatFr.add(cat3);
        ModelCategoryFragment cat4 = new ModelCategoryFragment("Baby");
        dataholderCatFr.add(cat4);
        ModelCategoryFragment cat5 = new ModelCategoryFragment("Kids");
        dataholderCatFr.add(cat5);
        ModelCategoryFragment cat6 = new ModelCategoryFragment("H&M HOME");
        dataholderCatFr.add(cat6);
        ModelCategoryFragment cat7 = new ModelCategoryFragment("Gift Guide");
        dataholderCatFr.add(cat7);
        ModelCategoryFragment cat8 = new ModelCategoryFragment("Outlet");
        dataholderCatFr.add(cat8);
        ModelCategoryFragment cat9 = new ModelCategoryFragment("Student Discount");
        dataholderCatFr.add(cat9);
        recyclerViewTag.setAdapter(new RecycleViewCategoryFragmentAdapter(dataholderCatFr));


        return view;
    }
}