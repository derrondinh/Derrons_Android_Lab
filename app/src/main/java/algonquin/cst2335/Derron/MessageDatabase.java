package algonquin.cst2335.Derron;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;

import algonquin.cst2335.Derron.ChatRoom;


@Database(entities = {ChatRoom.ChatMessage.class}, version = 1)
public abstract class MessageDatabase extends RoomDatabase {
    public abstract ChatMessageDAO cmDAO();
}