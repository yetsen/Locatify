package tr.com.locatify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tr.com.locatify.dao.CurseDAO;
import tr.com.locatify.model.GeneralResponse;
import tr.com.locatify.model.GetNewMessagesRequest;
import tr.com.locatify.model.Message;
import tr.com.locatify.model.Point;

import java.util.List;

/**
 * Created by Yunus on 12-Mar-16.
 */
@Controller
public class CurseWebSocketController {


    @Autowired
    private CurseDAO curseDAO;

    @MessageMapping("/getMessagesWebsocket")
    @SendTo("/getMessages")
    public List<Message> getMessages(GetNewMessagesRequest request) throws InterruptedException {
        Object [] args = {request.getPoint().getLatitude(), request.getPoint().getLatitude(), request.getPoint().getLongitude(), request.getPoint().getLongitude(), request.getLastId()};
        List<Message> result = curseDAO.getMessage(args);
        while (result.size() == 0) {
            Thread.sleep(3000);
            result = curseDAO.getMessage(args);
        }
        return curseDAO.getMessage(args);
    }
}
