package algonquin.cst2335.Derron.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public String button="i'm a button";
    public String text="Hello World";

    public MutableLiveData<String> editString = new MutableLiveData<>();

    public MutableLiveData<Boolean> isOn = new MutableLiveData<>(false);
}
