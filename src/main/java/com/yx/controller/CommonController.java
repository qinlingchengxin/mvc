package com.yx.controller;

import com.yx.utils.App;
import com.yx.utils.GenResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * User: NMY
 * Date: 16-8-27
 */
@Controller
@RequestMapping(value = "common")
public class CommonController {

    /**
     * 使用java进行post提交
     *
     * @throws java.io.IOException
     */
    @RequestMapping(value = "doPost")
    public void doPost() throws IOException {
        URL postUrl = new URL("https://api.weixin.qq.com/cgi-bin/messages/template/send?access_token=9d6jc1Iuf6FpmktaAeMhHm-5h5uR55wzLc-WJWqfKxeAJLWInvGTP_pnxuPEhps53Go33s3g-n6TZfmwS-8_1gVRZtqclFvGEuWJpnjv7Zh4fkRGxNzJEOPQ6iYV3CNvYNNjAJAMBB");
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");//POST请求
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");//json
        connection.setConnectTimeout(3000);//毫秒
        connection.connect();
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        String params = "{\"touser\":\"otvoEwFBh6lzZa9oX1S043RxF3uE\",\"template_id\":\"R-aK59C_TsWEBl9ylgj-VH1WUceEwPfLVBu15Py2P3E\",\"url\":\"http://www.baidu.com\",\"data\":{\"first\":{\"value\":\"张三邀请李四参加第五届牛逼运动会！\",\"color\":\"#173177\"},\"keyword1\":{\"value\":\"2016/08/25\",\"color\":\"#173177\"},\"remark\":{\"value\":\"祝您愉快！\",\"color\":\"#173177\"}}}";
        out.write(params);
        out.flush();
        out.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        System.out.println(sb.toString());
    }

    /**
     * 测试jsonP跨域问题
     */
    @RequestMapping(value = "testJsonP")
    @ResponseBody
    public String testJsonP() {
        return "hello";
    }

    /**
     * 测试接收enum类型数据
     * common/testEnum.do?app=qq
     */
    @RequestMapping(value = "testEnum")
    @ResponseBody
    public Map<String, Object> testEnum(App app) {
        return GenResult.SUCCESS.genResult(app);
    }
}
