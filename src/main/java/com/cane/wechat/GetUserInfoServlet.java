package com.cane.wechat;

/**
 * Created by xu_kanfeng on 16/7/6.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class GetUserInfoServlet extends HttpServlet {
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

        String code = request.getParameter("code");

        System.out.println("#####");
        System.out.println(code);

        WechatProcess startProcess = new WechatProcess();
        startProcess.getUserInfo(code);
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

