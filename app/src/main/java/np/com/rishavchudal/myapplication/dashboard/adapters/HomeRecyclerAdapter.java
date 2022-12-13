package np.com.rishavchudal.myapplication.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.rishavchudal.myapplication.R;
import np.com.rishavchudal.myapplication.dashboard.Product;

/**
 * Created by Rishav Chudal on 13/12/2022.
 */
public class HomeRecyclerAdapter
        extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeRecyclerViewHolder> {
    private final Context context;
    private final List<Product> products;


    public HomeRecyclerAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(
                R.layout.item_layout_home_recycler_view,
                parent,
                false
        );
        return new HomeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull HomeRecyclerViewHolder holder,
            int position
    ) {

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class HomeRecyclerViewHolder
            extends RecyclerView.ViewHolder {

        public HomeRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
