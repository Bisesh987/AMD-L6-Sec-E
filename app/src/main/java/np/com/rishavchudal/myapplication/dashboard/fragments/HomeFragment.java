package np.com.rishavchudal.myapplication.dashboard.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import np.com.rishavchudal.myapplication.R;
import np.com.rishavchudal.myapplication.dashboard.Product;
import np.com.rishavchudal.myapplication.dashboard.adapters.HomeRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private TextView tvHomeDisplay;
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddItem;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(
                R.layout.fragment_home,
                container,
                false
        );
        tvHomeDisplay = view.findViewById(R.id.tv_home_display);
        fabAddItem = view.findViewById(R.id.fab_add_item);
        recyclerView = view.findViewById(R.id.recycler_view_home);
        return view;
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
        tvHomeDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        requireActivity(),
                        "This is Home Fragment",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        List<Product> products = getProductList();
        HomeRecyclerAdapter recyclerAdapter = new HomeRecyclerAdapter(
                requireActivity(),
                products
        );
        recyclerView.setAdapter(recyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<Product> getProductList() {
        //TODO Replace with actual list from storage
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.title = "Title 1";
        product1.description = "Description 1";
        products.add(product1);

        Product product2 = new Product();
        product2.title = "Title 2";
        product2.description = "Description 2";
        products.add(product2);

        Product product3 = new Product();
        product3.title = "Title 3";
        product3.description = "Description 3";
        products.add(product3);

        return products;
    }



}