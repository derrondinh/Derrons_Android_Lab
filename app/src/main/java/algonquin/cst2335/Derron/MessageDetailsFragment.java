package algonquin.cst2335.Derron;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import algonquin.cst2335.Derron.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {

    ChatMessage selected;
    public MessageDetailsFragment(ChatMessage m){
        selected  = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);

        binding.textView2.setText(selected.message);
        binding.textView3.setText(selected.timeSent);
        binding.textView5.setText("Id = " + selected.id);
        if(selected.isSentButton()){
            binding.textView4.setText("Sent Button");
        }
        else{
            binding.textView4.setText("Recieved Button");
        }
        return binding.getRoot();

    }
}