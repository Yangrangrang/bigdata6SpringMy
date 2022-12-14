package com.example.bigdata6springstudy.controller;

import com.example.bigdata6springstudy.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")    // 앞에 무조건 '/'이 있어야 한다. > @GetMapping에 앞에 무조건 /user가 붙어있음
public class UserController {
    @GetMapping("/list.do")
    public String list(
            HttpServletRequest req,
            @RequestParam(defaultValue = "1") int page) {
        String rows_str = req.getParameter("rows");
        int rows = (rows_str == null) ? 10 : Integer.parseInt(rows_str);

        System.out.println("page" + page);
        System.out.println("rows" + rows);
        return "/userList"; // /userList.html (html은 생략 가능)
        // == req.getRequestDispatcher("/WEB-INF/templates/userList.html").forward(req,resp);

    }

    @GetMapping("/detail.do")
    public String detail(@RequestParam int userNo,
                         Model model){
        // @RequestParam 를 명시하면 자동으로 required-ture 가 된다. (이 동적 페이지에 해당 파라미터가 꼭 필요하다)
        // @RequestParam 를 생략할 수도 있다. (but, 생략하면required=true가 애매하게 동장한다.)
        System.out.println("요청된 유저 상세 번호: " + userNo);

        UserDto user = new UserDto();
        user.setUserNo(3);
        user.setName("길동");
        user.setBrith(new Date());
        user.setSal(99999);
        model.addAttribute("user",user);    // Model = Controller와 view를 연결해주는 객체다.
        // == request.setAttribute("user",user);

        return "/userDetail";
    }
    @PostMapping("/update.do")
        public String update(UserDto user) {
        int update = 0;
        System.out.println(user);
        if(update>0){
            return "redirect:/user/list.do";
        } else {
            return "redirect:/user/detail.do?userNo=1";
        }
    }
}

