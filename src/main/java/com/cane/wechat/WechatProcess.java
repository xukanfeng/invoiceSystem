package com.cane.wechat;

/**
 * Created by xu_kanfeng on 16/7/6.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 微信xml消息处理流程逻辑类
 * @author pamchen-1
 *
 */
public class WechatProcess {
    String appid = "wx929039a2309fa2d5";
    String secret = "377d7c8717d2378ba794afceaa911942";
    String redirectUrl = "http://xukanfeng1989.imwork.net/getUserInfo";
    /**
     * 解析处理xml、获取智能回复结果（通过图灵机器人api接口）
     * @param xml 接收到的微信数据
     * @return	最终的解析结果（xml格式数据）
     */
    public String processWechatMag(String xml){
        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);

        /** 以文本消息为例，调用图灵机器人api接口，获取回复内容 */
        String result = "";
        if("text".endsWith(xmlEntity.getMsgType())){
            result = new TulingApiProcess().getTulingResult(xmlEntity.getContent());
        }

        /** 此时，如果用户输入的是“你好”，在经过上面的过程之后，result为“你也好”类似的内容
         *  因为最终回复给微信的也是xml格式的数据，所有需要将其封装为文本类型返回消息
         * */
        result = new FormatXmlProcess().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);

        return result;
    }

    public String getAccessToken(){

        String apiUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4400d4620d933394&secret=d4624c36b6795d1d99dcf0547af5443d";
        String param = apiUrl;

        /** 发送httpget请求 */
        HttpGet request = new HttpGet(param);
        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1");
        System.out.println(result);

        try {
            JSONObject json = new JSONObject(result);
            //以code=100000为例，参考图灵机器人api文档
            result = json.getString("access_token");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("2");
        System.out.println(result);
        return result;
    }

    public String createMenu(String accessToken){
        String s = "{\"button\":[{\"name\":\"开发票\",\"sub_button\":[{\"type\":\"click\",\"name\":\"笑话大全\",\"key\":\"m_joke\"},{\"type\":\"click\",\"name\":\"内涵段子\",\"key\":\"m_duanzi\"},{\"type\":\"click\",\"name\":\"爆笑图片\",\"key\":\"m_laughImg\"}]},{\"name\":\"实用工具\",\"sub_button\":[{\"type\":\"click\",\"name\":\"天气查询\",\"key\":\"m_weather\"},{\"type\":\"click\",\"name\":\"公交查询\",\"key\":\"m_bus\"}]},{\"type\":\"click\",\"name\":\"关于企特\",\"key\":\"m_about\"}]}";

        //HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        HttpPost request = new HttpPost(apiUrl);
        request.setEntity(new StringEntity(s, "UTF-8"));
        HttpResponse response = null;
        try {
            response = new DefaultHttpClient().execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = "";
        try {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3");
        System.out.println(result);
        JSONObject json = null;
        try {
            json = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            result = json.getString("errmsg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("3");
        System.out.println(result);

        return result;
    }

    public String sendUrl(String xml){

        String codeApiUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + redirectUrl + "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";

        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);
        String result = new FormatXmlProcess().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), codeApiUrl);
        System.out.println("url:");
        System.out.println(result);
        return result;
    }

    public String getUserInfo(String code) {

        //HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);
        //String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;

//        String appid = "wx4400d4620d933394";
//        String secret = "d4624c36b6795d1d99dcf0547af5443d";
//        String redirectUrl = "http://xukanfeng1989.imwork.net/wechat";
//        String codeApiUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + redirectUrl + "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
//
//        HttpGet codeRequest = new HttpGet(codeApiUrl);
//        String result = "";
//        String code = "";
//        try {
//            HttpResponse response = HttpClients.createDefault().execute(codeRequest);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                result = EntityUtils.toString(response.getEntity());
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("10");
//        System.out.println(result);
//
//        try {
//            JSONObject json = new JSONObject(result);
//            code = json.getString("code");
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println("20");
//        System.out.println(code);

////////////////////////////////////////////////////////////////
        String tokenApiUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        HttpGet tokenRequest = new HttpGet(tokenApiUrl);
        String result = "";
        String token = "";
        String openid = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(tokenRequest);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("30");
        System.out.println(result);

        try {
            JSONObject json = new JSONObject(result);
            token = json.getString("access_token");
            openid = json.getString("openid");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("40");
        System.out.println(token);

////////////////////////////////////////////////////////////////
        String userinfoApiUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=" + openid;
        HttpGet userinfoRequest = new HttpGet(userinfoApiUrl);
        result = "";
        String userinfo = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(tokenRequest);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("50");
        System.out.println(result);

        JSONObject json = null;
        try {
            json = new JSONObject(result);
            //userinfo = json.getString("userinfo");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println("60");
        //System.out.println(result);

        try {
            System.out.println("OpenID：" + json.getString("openid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        System.out.println("关注状态：" + result.getString("userinfo");
//        System.out.println("关注时间：" + result.getString("userinfo");
        try {
            System.out.println("昵称：" + json.getString("nickname"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        System.out.println("性别：" + json.getString("sex");
//        System.out.println("国家：" + json.getString("country");
//        System.out.println("省份：" + json.getString("province");
        try {
            System.out.println("城市：" + json.getString("city"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println("语言：" + json.getString("language");
        try {
            System.out.println("头像：" + json.getString("headimgurl"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
