package tr.com.locatify.dao;

import tr.com.locatify.model.GeneralResponse;
import tr.com.locatify.model.Message;

import java.util.List;

/**
 * Created by Yunus on 12-Mar-16.
 */
public interface CurseDAO {

    public GeneralResponse insertMessage(Object [] args);

    public List<Message> getMessage(Object [] args);

}
