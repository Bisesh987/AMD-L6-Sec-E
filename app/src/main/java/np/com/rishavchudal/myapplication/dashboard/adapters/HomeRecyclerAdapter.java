package np.com.rishavchudal.myapplication.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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
        Product product = products.get(position);
        holder.itemTvTitle.setText(product.title);
        holder.itemTvDescription.setText(product.description);
        holder.itemRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        context,
                        "Item at position " + holder.getAdapterPosition() + " is clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class HomeRecyclerViewHolder
            extends RecyclerView.ViewHolder {

        private ImageView itemImageView;
        private TextView itemTvTitle;
        private TextView itemTvDescription;
        private ConstraintLayout itemRootLayout;

        public HomeRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.iv_item);
            itemTvTitle = itemView.findViewById(R.id.tv_item_title);
            itemTvDescription = itemView.findViewById(R.id.tv_item_description);
            itemRootLayout = itemView.findViewById(R.id.item_root_layout);
        }

        public ImageView getItemImageView() {
            return itemImageView;
        }

        public TextView getItemTvTitle() {
            return itemTvTitle;
        }

        public TextView getItemTvDescription() {
            return itemTvDescription;
        }

        public ConstraintLayout getItemRootLayout() {
            return itemRootLayout;
        }
    }
}
