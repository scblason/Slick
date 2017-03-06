package test;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;

import com.github.slick.Presenter;

import javax.inject.Inject;
import javax.inject.Provider;

public class DaggerFragment extends Fragment implements ExampleView {

    @Inject
    Provider<ExamplePresenter> provider;
    @Presenter
    ExamplePresenter presenter;

    @Override
    public void onAttach(Context context) {
        DaggerFragment_Slick.bind(this);
        super.onAttach(context);
    }
}