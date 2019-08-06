package test.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJSON01 {

	private static final long EXPIRE_TIME = 0;
	private static final String SECRET = "1234567";

	public static void main(String[] args)throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("key-a", 100);
		map.put("key-b", 200);
		ObjectMapper om=new ObjectMapper();
		String s1=om.writeValueAsString(map);
		System.out.println(s1);
		
		Map<String,Object> map2=om.readValue(s1,Map.class);
		System.out.println(map2);
		
		System.out.println(JSON.toJSONString(map));
		System.out.println(JSON.parseObject(s1,Map.class));
		
		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		Algorithm algorithm = Algorithm.HMAC256(SECRET);
		String username = null;
		JWT.create()
		   .withClaim("username", username)
		   //到期时间
		   .withExpiresAt(date)
		   //创建一个新的JWT，并使用给定的算法进行标记
		   .sign(algorithm);
		
	}
}
