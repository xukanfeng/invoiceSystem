package com.cane.wechat;

/**
 * Created by xu_kanfeng on 16/7/6.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 微信服务端收发消息接口
 *
 * @author pamchen-1
 *
 */
public class WechatServlet extends HttpServlet {
    private final String token = "xukanfeng";
    public String accessToken = "";
    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        /** 读取接收到的xml消息 */
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        String xml = sb.toString();	//次即为接收到微信端发送过来的xml数据

        String result = "";
        /** 判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回 */
        String echostr = request.getParameter("echostr");
        if (echostr != null && echostr.length() > 1) {
//            System.out.println("开始签名校验");
//            String signature = request.getParameter("signature");
//            String timestamp = request.getParameter("timestamp");
//            String nonce = request.getParameter("nonce");
//
//            ArrayList<String> array = new ArrayList<String>();
//            array.add(signature);
//            array.add(timestamp);
//            array.add(nonce);
//
//            //排序
//            String sortString = sort(token, timestamp, nonce);
//            //加密
//            String mytoken = Decript.SHA1(sortString);
//            //校验签名
//            if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
//                System.out.println("发送echostr。");
//                response.getWriter().println(echostr); //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
//                System.out.println("签名校验通过。");
//            } else {
//                System.out.println("签名校验失败。");
//            }

            result = echostr;

        } else {
            //正常的微信处理流程
            //获取token
//            WechatProcess startProcess = new WechatProcess();
//            accessToken = startProcess.getAccessToken();
            //创建菜单
            //startProcess.createMenu(accessToken);
            //自动回复
            //result = new WechatProcess().processWechatMag(xml);
            //获取信息
//            String appid = "wx4400d4620d933394";
//            String secret = "d4624c36b6795d1d99dcf0547af5443d";
//            String redirectUrl = "http://xukanfeng1989.imwork.net/wechat";
//            String accessToken = CommonUtil.getToken(appid, secret).getAccessToken();
//
//            WeixinUserInfo user = CommonUtil.getUserInfo(accessToken, "ooK-yuJvd9gEegH6nRIen-gnLrVw");//缺少openid
//            System.out.println("OpenID：" + user.getOpenId());
//            System.out.println("关注状态：" + user.getSubscribe());
//            System.out.println("关注时间：" + user.getSubscribeTime());
//            System.out.println("昵称：" + user.getNickname());
//            System.out.println("性别：" + user.getSex());
//            System.out.println("国家：" + user.getCountry());
//            System.out.println("省份：" + user.getProvince());
//            System.out.println("城市：" + user.getCity());
//            System.out.println("语言：" + user.getLanguage());
//            System.out.println("头像：" + user.getHeadImgUrl());
            WechatProcess startProcess = new WechatProcess();
            result = startProcess.sendUrl(xml);
        }

        try {
            OutputStream os = response.getOutputStream();
            os.write(result.getBytes("UTF-8"));
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to
     * post.
     *
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 排序方法
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
//    public static String sort(String token, String timestamp, String nonce) {
//        String[] strArray = { token, timestamp, nonce };
//        Arrays.sort(strArray);
//
//        StringBuilder sbuilder = new StringBuilder();
//        for (String str : strArray) {
//            sbuilder.append(str);
//        }
//
//        return sbuilder.toString();
//    }
}

