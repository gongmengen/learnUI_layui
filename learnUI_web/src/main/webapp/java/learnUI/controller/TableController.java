package learnUI.controller;

import learnUI.bean.User;
import learnUI.common.LayResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TableController {

    @RequestMapping("/demo/table/user/")
    @ResponseBody
    public LayResult tableDome(){
        List users = new ArrayList();
        users.add(new User(1,"张三","男"));
        return new LayResult(0,"",1,users);
    }
}
