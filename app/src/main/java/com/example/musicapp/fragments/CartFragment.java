package com.example.musicapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.R;
import com.example.musicapp.recycleviews.SelectListener2;
import com.example.musicapp.recycleviews.shoppingCart.ModelCartFragment;
import com.example.musicapp.recycleviews.shoppingCart.RecycleViewCartFragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment  {
    ArrayList<ModelCartFragment> dataholderCart;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        View view=inflater.inflate(R.layout.fragment_cart, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerViewCart = view.findViewById(R.id.recyclerviewcartfragment);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false));

        dataholderCart = new ArrayList<>();
        ModelCartFragment product1 = new ModelCartFragment(R.drawable.bagproduct,"Straw Beach Bag", "$ 24.99");
        dataholderCart.add(product1);
        ModelCartFragment product2 = new ModelCartFragment(R.drawable.pantsproduct,"Ankle-length Pants", "$ 29.99");
        dataholderCart.add(product2);
//        ModelCartFragment product3 = new ModelCartFragment(R.drawable.womanc,"Ankle-length Pants", "$ 29.99");
//        dataholderCart.add(product3);
        recyclerViewCart.setAdapter(new RecycleViewCartFragmentAdapter(dataholderCart));


        return view;
    }



}