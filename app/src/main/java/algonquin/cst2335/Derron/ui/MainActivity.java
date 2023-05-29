package algonquin.cst2335.Derron.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

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

        mytext.setText(model.text);
        mybutton.setText(model.button);
        myedit.setText(model.edit);
        mycheckbox.setOnCheckedChangeListener( (a,b) ->{
            mytext.setText("the checkbox is on?" + b);
        });
        myswitch.setOnCheckedChangeListener( (a,b) ->{
            mytext.setText("the switch is on?" + b);
        });


        mybutton.setOnClickListener( (v) ->{
            model.text ="You clicked the button";
            model.button ="Something new here";
            mytext.setText(model.text);
            mybutton.setText(model.button);
        });



       /* variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.observe(this,s -> {
                variableBinding.mytextview.setText("Your edit text has: "+ s);
            });

        });*/
    }
}













