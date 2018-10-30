package life.eks.xmall.controller.home;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/userInfo")
    public Map<String, Object> userInfo() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", name);
        return userInfo;
    }
}