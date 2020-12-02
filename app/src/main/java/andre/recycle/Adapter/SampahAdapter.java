package andre.recycle.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import andre.recycle.Model.ResponseSampah;
import andre.recycle.Model.Sampah;
import andre.recycle.R;

import static andre.recycle.Rest.CombineApi.img_url;

public class SampahAdapter extends RecyclerView.Adapter<SampahAdapter.ViewHolder> implements Filterable {
    private ArrayList<Sampah> rvData;
    Context context;
    Dialog myDialog;

    private ArrayList<Sampah> rvDataList;
    private List<ResponseSampah> data;

    public SampahAdapter(Context context, ArrayList<Sampah> inputData){
        this.context = context;
        rvData = inputData;
        rvDataList = new ArrayList<>(rvData);
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Sampah> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(rvDataList);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Sampah item : rvDataList){
                    if (item.getSampah_nama().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getSampah_harga().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            rvData.clear();
            rvData.addAll((ArrayList) results.values);
            notifyDataSetChanged();

        }
    };
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sampah, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Sampah Sampah = rvData.get(position);
        holder.nama_sampah.setText(Sampah.getSampah_nama());
        holder.harga_sampah.setText(Sampah.getSampah_harga());
        String gambar = Sampah.getSampah_foto();

        Picasso.get()
                .load(img_url + gambar)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.img_sampah);

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nama_sampah, harga_sampah;
        public ImageView img_sampah;

        public ViewHolder(View v){
            super(v);
            nama_sampah = (TextView) v.findViewById(R.id.nama_sampah);
            harga_sampah = (TextView) v.findViewById(R.id.harga_sampah);
            img_sampah = (ImageView) v.findViewById(R.id.img_sampah);
        }
    }



}
