package com.example.musicapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.musicapp.SelectListener;

import com.example.musicapp.activities.ProductDetailActivity;
import com.example.musicapp.recycleviews.Model;
import com.example.musicapp.R;
import com.example.musicapp.recycleviews.ModelCategoryFragment;
import com.example.musicapp.recycleviews.ModelProduct;
import com.example.musicapp.recycleviews.ModelTag;
import com.example.musicapp.recycleviews.RecycleViewHomeProductAdapter;
import com.example.musicapp.recycleviews.RecycleViewHomeTagsAdapter;
import com.example.musicapp.recycleviews.RecyclerViewAdapter;
import com.example.musicapp.recycleviews.SelectListener2;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */

public class HomeFragment extends Fragment implements SelectListener2{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Model> dataholderCollection;
    ArrayList<ModelTag> dataholderTag;
    ArrayList<ModelProduct> dataholderProduct;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datafragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        //horizontal layout
      //  LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        /**
         * Collection recycle view
         */

        RecyclerView recyclerViewCollection = view.findViewById(R.id.recyclerview);
        recyclerViewCollection.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));

        dataholderCollection=new ArrayList<>();
        Model ob1=new Model(R.drawable.womanc,"WOMEN COLLECTION");
        dataholderCollection.add(ob1);
        Model ob2=new Model(R.drawable.menc,"MEN COLLECTION");
        dataholderCollection.add(ob2);
        Model ob3=new Model(R.drawable.kidsc,"KIDS COLLECTION");
        dataholderCollection.add(ob3);
        recyclerViewCollection.setAdapter(new RecyclerViewAdapter(dataholderCollection));

        /**
         * Tag recycle view
         */

        RecyclerView recyclerViewTag = view.findViewById(R.id.recyclerviewTagsHome);
        recyclerViewTag.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));

        //Tags recycle view fill
        dataholderTag = new ArrayList<>();
        ModelTag tag1 = new ModelTag("Trending");
        dataholderTag.add(tag1);
        ModelTag tag2 = new ModelTag("Festival Clothing");
        dataholderTag.add(tag2);
        ModelTag tag3 = new ModelTag("Romantic & feminine");
        dataholderTag.add(tag3);
        ModelTag tag4 = new ModelTag("Sun-kissed styles");
        dataholderTag.add(tag4);
        recyclerViewTag.setAdapter(new RecycleViewHomeTagsAdapter(dataholderTag));


        /**
         * Product recycle view
         */

        RecyclerView recyclerViewProduct = view.findViewById(R.id.recyclerviewProductHome);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerViewProduct.setLayoutManager(gridLayoutManager);

        dataholderProduct = new ArrayList<>();
        ModelProduct product1 = new ModelProduct(R.drawable.bagproduct,"Straw Beach Bag", "$ 24.99");
        dataholderProduct.add(product1);
        ModelProduct product2 = new ModelProduct(R.drawable.pantsproduct,"Ankle-length Pants", "$ 29.99");
        dataholderProduct.add(product2);
        ModelProduct product3 = new ModelProduct(R.drawable.womanc,"Ankle-length Pants", "$ 29.99");
        dataholderProduct.add(product3);
        recyclerViewProduct.setAdapter(new RecycleViewHomeProductAdapter(dataholderProduct, this));



        return view;
    }




    @Override
    public void onItemClicked(ModelProduct modelProduct) {
      Toast.makeText(getActivity(), modelProduct.getName(), Toast.LENGTH_SHORT).show();
        Log.v("GO TO DETAILS","ON ITEM CLICKED");
        Intent newIntent=new Intent();
        newIntent.setClass(getActivity(),ProductDetailActivity.class);
        getActivity().startActivity(newIntent);
    }
}



