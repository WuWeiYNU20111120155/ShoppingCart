package com.wuwei.shopping_cart.web.session.controller;

import com.wuwei.shopping_cart.web.session.model.Session;
import com.wuwei.shopping_cart.web.session.model.SessionManager;
import com.wuwei.shopping_cart.web.session.view.LoginRequest;
import com.wuwei.shopping_cart.web.user.model.User;
import com.wuwei.shopping_cart.web.user.model.UserDao;
import com.wuwei.shopping_cart.web.user.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class sessionController {

    private static final  String USER_ID = "user_id";
    private static final  String SESSION_TOKEN = "session_token";

    private UserDao userDao;
    private SessionManager sessionManager;

    public sessionController(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
    }

    /*
    Login in
     */
    @PostMapping("/session")
    public ResponseEntity login(HttpServletResponse response, @RequestBody LoginRequest loginRequest){
        User user = userDao.getByName(loginRequest.getUserName());
        // 验证用户是否存在或者密码是否正确
        if(user == null || !user.getPassword().equals(loginRequest.getPassWord())){
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        //添加session
        String token = UUID.randomUUID().toString();//生成sessionId
        sessionManager.getSessions().put(user.getId(),new Session(user.getId(),token));
        response.addCookie(new Cookie(USER_ID,Integer.toString(user.getId())));
        response.addCookie(new Cookie(SESSION_TOKEN,token));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /*
    current user
     */
    @GetMapping("/current")
    public ResponseEntity<UserView> current(@CookieValue(name = USER_ID, defaultValue = "0") int userId,@CookieValue(name = SESSION_TOKEN,defaultValue = "") String token){
        Session session = sessionManager.getSessions().get(userId);
        if(session == null || !session.getToken().equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        /* 认证成功 */
        return new ResponseEntity<>(new UserView(userId,userDao.findById(userId).getName()),HttpStatus.OK);
    }

    /*
    logOut
     */
    @DeleteMapping("/session")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") int userId,@CookieValue(name = SESSION_TOKEN,defaultValue = "") String token){
        Session session = sessionManager.getSessions().get(userId);
        if(session == null || !session.getToken().equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        /* 认证成功 */

        //delete
        sessionManager.getSessions().remove(userId);
        return  new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
