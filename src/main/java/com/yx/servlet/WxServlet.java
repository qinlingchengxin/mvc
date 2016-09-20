package com.yx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * User: LiWenC
 * Date: 16-9-14
 */
public class WxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            InputStream inputStream = request.getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while ((len = inputStream.read(buffer)) > 0) {
                stringBuffer.append(new String(buffer, 0, len));
            }
            System.out.println(stringBuffer.toString());
            StringBuffer xml = new StringBuffer("<xml><ToUserName><![CDATA[");
            xml.append("otvoEwFBh6lzZa9oX1S043RxF3uE");
            xml.append("]]></ToUserName>");
            xml.append("<FromUserName><![CDATA[");
            xml.append("gh_3db7711c10f0");
            xml.append("]]></FromUserName>");
            xml.append("<CreateTime>");
            xml.append(System.currentTimeMillis());
            xml.append("</CreateTime>");
            xml.append("<MsgType><![CDATA[news]]></MsgType>");

            xml.append("<ArticleCount>2</ArticleCount>");
            xml.append("<Articles>");

            xml.append("<item>");
            xml.append("<Title><![CDATA[");
            xml.append("直接输入文字或语音即可快捷创建日程");
            xml.append("]]></Title>");
            xml.append("<PicUrl><![CDATA[");
            xml.append("http://static.etouch.cn/suishen/wx/wx_guide.png");
            xml.append("]]></PicUrl>");
            xml.append("<Url><![CDATA[");
            xml.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8d7503d9fffbe6f1&redirect_uri=http%3a%2f%2fwecal.ai%2fnew.html&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            xml.append("]]></Url>");
            xml.append("</item>");

            xml.append("<item>");
            xml.append("<Title><![CDATA[");
            xml.append("微历APP已经正式上线，欢迎下载使用！");
            xml.append("]]></Title>");
            xml.append("<PicUrl><![CDATA[");
            xml.append("http://d.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=6afa7433ce5c10383073c690d378f876/c9fcc3cec3fdfc0311ef9791dc3f8794a4c22607.jpg");
            xml.append("]]></PicUrl>");
            xml.append("<Url><![CDATA[");
            xml.append("http://115.28.100.160/download.html");
            xml.append("]]></Url>");
            xml.append("</item>");
            xml.append("</Articles>");
            xml.append("</xml>");
            PrintWriter out = response.getWriter();
            out.print(xml.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String echoStr = request.getParameter("echostr");
            PrintWriter out = response.getWriter();
            out.write(echoStr);
            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }
}
