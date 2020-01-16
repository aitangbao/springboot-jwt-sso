package com.aitangbao.sso.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.aitangbao.sso.entity.TbUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * jwt工具类
 */
public class JwtUtils {

    public static final String USER_ID_KEY = "user_id_key";

    public static final String USER_ACCOUNT_KEY = "user_account_key";


    public static final String SUBJECT = "onehee";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "onehee666";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(TbUser user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("userName",user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;

    }


    /**
     * 判断当前登陆用户是不是admin
     * @param request
     * @return
     */
    public static boolean isAdmin(HttpServletRequest request) {
        if (request.getAttribute(USER_ACCOUNT_KEY) == null) {
            return false;
        }
        if ("admin".equals(request.getAttribute(USER_ACCOUNT_KEY).toString())){
            return true;
        } else {
            return false;
        }
    }



}