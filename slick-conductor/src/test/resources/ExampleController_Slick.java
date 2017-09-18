package test;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import com.bluelinelabs.conductor.Controller;
import com.github.slick.InternalOnDestroyListener;
import com.github.slick.conductor.SlickDelegateConductor;
import java.lang.Override;

public class ExampleController_Slick implements InternalOnDestroyListener {
    private static ExampleController_Slick hostInstance;
    private final SparseArray<SlickDelegateConductor<ExampleView, ExamplePresenter>> delegates = new SparseArray<>();

    public static <T extends Controller & ExampleView> void bind(T exampleController, @IdRes int i, float f) {
        final int id = exampleController.getInstanceId().hashCode();
        if (hostInstance == null) hostInstance = new ExampleController_Slick();
        SlickDelegateConductor<ExampleView, ExamplePresenter> delegate = hostInstance.delegates.get(id);
        if (delegate == null) {
            final ExamplePresenter presenter = new ExamplePresenter(i, f);
            delegate = new SlickDelegateConductor<>(presenter, exampleController.getClass(), id);
            delegate.setListener(hostInstance);
            hostInstance.delegates.put(id, delegate);
            exampleController.addLifecycleListener(delegate);
        }
        ((ExampleController) exampleController).presenter = delegate.getPresenter();
    }

    @Override
    public void onDestroy(int id) {
        hostInstance.delegates.remove(id);
        if (hostInstance.delegates.size() == 0) {
            hostInstance = null;
        }
    }
}