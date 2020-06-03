package com.karthik.spring.fcm.requests;

import java.util.ArrayList;
import java.util.List;

import com.karthik.spring.fcm.model.FCMClient;
import com.karthik.spring.fcm.services.PushNotificationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController
{

  private final String TOPIC = "global";

  @Autowired
  PushNotificationService pushNotificationsService;

  @RequestMapping(value = "/client", method = RequestMethod.POST)
  public ResponseEntity<String> sendPushNotification(@RequestBody FCMClient fCMClient)
  {
    try
    {
      firePushNotification(fCMClient);
    }
    catch (JSONException je)
    {

    }
    catch (Exception e)
    {

    }

    return new ResponseEntity<>(fCMClient.toString(), HttpStatus.OK);
  }

  private void firePushNotification(FCMClient fCMClient) throws JSONException
  {
    List<String> tokens = fCMClient.getRegistrationTokens();
    for (String token : tokens)
    {
      JSONObject body = new JSONObject();
      body.put("to", token);
      body.put("priority", "high");
      HttpEntity<String> request = new HttpEntity<>(body.toString());
      pushNotificationsService.send(request, fCMClient);
    }
  }

  @RequestMapping(value = "/client1", method = RequestMethod.GET)
  public ResponseEntity<String> checkGet()
  {
    return new ResponseEntity<>("Hello - GET is executed", HttpStatus.OK);
  }
}
