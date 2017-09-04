package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.TokenAuthenticationRequest;
import com.luoyu.yorozuya.pojo.TokenAuthenticationResponse;
import com.luoyu.yorozuya.pojo.vo.UserVO;
import com.luoyu.yorozuya.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 落羽 on 2017/9/1.
 */
@RestController
public class AuthController {
    protected Logger logger = Logger.getLogger(AuthController.class.getName());
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody TokenAuthenticationRequest authenticationRequest) throws AuthenticationException {
        logger.info(String.format("createAuthenticationToken() invoked: %s for %s ", authService.getClass().getName(), authenticationRequest.getUsername()));
        try {
            final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            // Return the token
            return ResponseEntity.ok(new TokenAuthenticationResponse(token));
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised user login REST Call "+ex);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        logger.info(String.format("refreshAndGetAuthenticationToken() invoked: %s for %s ", authService.getClass().getName(), token));
        try {
            String refreshedToken = authService.refresh(token);
            return ResponseEntity.ok(new TokenAuthenticationResponse(refreshedToken));
        } catch (Exception ex) {
            logger.warning("Exception raised refresh token "+ex);
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserVO userVO) throws AuthenticationException {
        logger.info(String.format("register() invoked: %s for %s ", authService.getClass().getName(), userVO.getUsername()));
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        try {
            authService.register(user);
        }catch (Exception ex){
            logger.warning("Exception raised register User REST Call "+ex);
            return new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }


}
