package com.karthik.spring.fcm.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PNErrorController implements ErrorController
{

  @Override
  public String getErrorPath()
  {
    return "/error";
  }

  @RequestMapping("/error")
  public String handleError()
  {
    return "<h1>Something went wrong!</h1>";
  }
}
