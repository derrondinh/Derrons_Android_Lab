package algonquin.cst2335.Derron;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import algonquin.cst2335.Derron.ChatMessage;

import java.util.ArrayList;

public class ChatRoomViewModel extends ViewModel {
    public MutableLiveData<ArrayList<ChatMessage>> messages = new MutableLiveData<>();
    public MutableLiveData<ChatMessage> selectedMessage = new MutableLiveData< >();

}
