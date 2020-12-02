package andre.recycle.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import andre.recycle.Activity.MainActivity;
import andre.recycle.Activity.SampahActivity;
import andre.recycle.Activity.UnitActivity;
import andre.recycle.R;
import andre.recycle.Rest.SampolInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    SampolInterface sampolInterface;
    @BindView(R.id.lyUnit)
    LinearLayout lyUnit;
    @BindView(R.id.list_katalog)
    TextView list_katalog;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBar actionBar =
                ((MainActivity) getActivity()).getSupportActionBar();
        assert actionBar != null;actionBar.setTitle("Beranda");

    }

    @OnClick(R.id.lyUnit)
    public void lyUnit(View view){
        Intent gotounit = new Intent(getActivity(), UnitActivity.class);
        startActivity(gotounit);
    }

    @OnClick(R.id.list_katalog)
    public void list_katalog(View view){
        Intent gotokatalog = new Intent(getActivity(), SampahActivity.class);
        startActivity(gotokatalog);
    }

}
