package algonquin.cst2335.Derron.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.Derron.data.MainViewModel;
import algonquin.cst2335.Derron.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        TextView mytext = variableBinding.mytextview;
        Button mybutton = variableBinding.mybutton;
        EditText myedit = variableBinding.myedittext;
        CheckBox mycheckbox = variableBinding.mycheckbox;
        Switch myswitch = variableBinding.myswitch;
        RadioButton myradiobutton = variableBinding.myradiobutton;

       /* mytext.setText(model.text);
        mybutton.setText(model.button);
        myedit.setText(model.editString);*/

        model.isOn.observe(this,(selected) ->{
            variableBinding.mycheckbox.setChecked(selected);
            variableBinding.myswitch.setChecked(selected);
            variableBinding.myradiobutton.setChecked(selected);
            Toast.makeText(this,String.format("the buttons are now: %b",selected),Toast.LENGTH_LONG).show();


        });
       variableBinding.mycheckbox.setOnCheckedChangeListener( (a,b) ->{
           model.isOn.postValue(b);

        });
       variableBinding.myswitch.setOnCheckedChangeListener( (a,b) ->{
            model.isOn.postValue(b);
        });
       variableBinding.myradiobutton.setOnCheckedChangeListener( (a,b) ->{
           model.isOn.postValue(b);
       });
       variableBinding.theimagebutton.setOnClickListener( (v) ->{
           Toast.makeText(this,"These words",Toast.LENGTH_LONG).show();

       });

        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });

        model.editString.observe(this, s ->{
            variableBinding.mytextview.setText("Your edit text has " + s);
        });
    }
}








