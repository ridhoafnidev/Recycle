package andre.recycle.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import andre.recycle.Activity.MainActivity;
import andre.recycle.R;

public class InformasiFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_informasi, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBar actionBar =
                ((MainActivity) getActivity()).getSupportActionBar();
        assert actionBar != null;actionBar.setTitle("Informasi");
    }
}
