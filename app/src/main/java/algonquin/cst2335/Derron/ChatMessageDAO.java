package algonquin.cst2335.Derron;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import algonquin.cst2335.Derron.ChatRoom;



import java.util.List;

@Dao
public interface ChatMessageDAO {

    @Insert
    void insertMessage(ChatRoom.ChatMessage m);


    @Query("Select * from ChatMessage")
    List<ChatRoom.ChatMessage> getAllMessages();

    @Delete
    void deleteMessage(ChatRoom.ChatMessage m);




}
