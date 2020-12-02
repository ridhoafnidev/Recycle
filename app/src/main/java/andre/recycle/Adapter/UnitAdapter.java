package andre.recycle.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import andre.recycle.Model.ResponseUnit;
import andre.recycle.Model.Unit;
import andre.recycle.R;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.ViewHolder> implements Filterable {
    private ArrayList<Unit> rvData;
    Context context;
    Dialog myDialog;

    private ArrayList<Unit> rvDataList;
    private List<ResponseUnit> data;

    public UnitAdapter(Context context, ArrayList<Unit> inputData){
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
            ArrayList<Unit> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(rvDataList);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Unit item : rvDataList){
                    if (item.getUnit_nama().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getUnit_alamat().toLowerCase().contains(filterPattern)){
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_unit, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Unit Unit = rvData.get(position);
        holder.nama_unit.setText(Unit.getUnit_nama());
        holder.alamat_unit.setText(Unit.getUnit_alamat());

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nama_unit, alamat_unit;

        public ViewHolder(View v) {
            super(v);
            nama_unit = (TextView) v.findViewById(R.id.tv_unit);
            alamat_unit = (TextView) v.findViewById(R.id.tv_alamat);
        }


    }
}
