package com.thakran.moviedb.interceptor;

import com.thakran.moviedb.dto.RequestLogDTO;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    public static final RequestLogDTO requestLogDTO = new RequestLogDTO();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> paramMap = request.getParameterMap();
        JSONParser jsonParser = new JSONParser();
        String str = IOUtils.toString(request.getReader());

        if(request.getMethod().equals("GET"))
        {
            String mapAsString = paramMap.keySet().stream()
                    .map(key -> key + "=" + paramMap.get(key)[0])
                    .collect(Collectors.joining(", ", "{", "}"));

            requestLogDTO.setRequest(mapAsString);
        }
        if(request.getMethod().equals("OPTIONS"))
        {
            return true;
        }
        else if (str.length() > 0) {
            JSONObject json = (JSONObject) jsonParser.parse(str);

            requestLogDTO.setRequest(json.toJSONString());

        }
        return true;

    }
}
