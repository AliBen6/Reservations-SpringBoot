package be.iccbxl.pid.rest;


import be.iccbxl.pid.service.BrusselsEventRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrusselsEventController {

    @Autowired
    private BrusselsEventRestService brusselsEventRestService;

    @GetMapping("/events")
    @ResponseBody
    public void getAllEvents() {
        brusselsEventRestService.consume();
    }
}
