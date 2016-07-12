package com.cane.controller;

import com.cane.model.ClientDataEntity;
import com.cane.model.InvoiceRecordEntity;
import com.cane.model.TaxcontrolSettingEntity;
import com.cane.repository.ClientDataDao;
import com.cane.repository.InvoiceRecordDao;
import com.cane.repository.ManagerDao;
import com.cane.repository.TaxcontrolSettingDao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xu_kanfeng on 15/12/27.
 */
@Controller /* @Controller注解：采用注解的方式，可以明确的定义该类为处理请求的Controller类 */
public class MainController {

    // 自动装配，相当于数据库操作的极简化，只要定义了就可以直接进行数据库操作，不用再去管开启连接、关闭连接等问题
    @Autowired
    ManagerDao managerDao;
    @Autowired
    ClientDataDao clientDataDao;
    @Autowired
    InvoiceRecordDao invoiceRecordDao;
    @Autowired
    TaxcontrolSettingDao taxcontrolSettingDao;

    @RequestMapping(value = "/", method = RequestMethod.GET) /* @RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post */
    public String index() { /* 定义了所需访问的jsp的名字 */
        return "invoice";
    } /* 处理完该请求后返回的页面，此请求返回 index.jsp页面 */


//    // 添加用户 页面
//    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
//    public String addUser() {
//        return "addUser";
//    }
//
//    // 添加用户 处理
//    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
//    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) { /* @ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取） */
//
//        // 数据库中添加一个用户，save()方法处理完毕后，数据依然在缓冲区未写入数据库
//        //userRepository.save(userEntity);
//
//        // 数据库中添加一个用户，并立即刷新
//        userRepository.saveAndFlush(userEntity);
//
//        // 返回重定向 到 /users 请求
//        return "redirect:/users";
//    }
//
//    // 查看用户详情
//// @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
//// 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
//    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
//    public String showUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {
//
//        // 找到userId所表示的用户
//        UserEntity userEntity = userRepository.findOne(userId);
//
//        // 传递给请求页面
//        modelMap.addAttribute("user", userEntity);
//        return "userDetail";
//    }
//
//    // 更新用户信息 页面
//    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
//    public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {
//
//        // 找到userId所表示的用户
//        UserEntity userEntity = userRepository.findOne(userId);
//
//        // 传递给请求页面
//        modelMap.addAttribute("user", userEntity);
//        return "updateUser";
//    }
//
//    // 更新用户信息 操作
//    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
//    public String updateUserPost(@ModelAttribute("user") UserEntity userEntity) {
//
//        // 更新用户信息
//        userRepository.updateUser(userEntity.getFirstName(), userEntity.getLastName(),
//                userEntity.getPassword(), userEntity.getId());
//        return "redirect:/users";
//    }
//
//    // 删除用户
//    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
//    public String deleteUser(@PathVariable("userId") Integer userId) {
//
//        // 删除id为userId的用户
//        userRepository.delete(userId);
//        // 立即刷新
//        userRepository.flush();
//        return "redirect:/users";
//    }


    // example for JSON
//    @RequestMapping(value = "/drawResult", method = RequestMethod.GET)
//    @ResponseBody
//    public void drawResult(String phone, String from) {
//        if (!StringUtils.isEmpty(phone)) {
//            ClientEntity client = clientDao.getClientByPhone(phone);
//            JSONObject result = new JSONObject();
//            try {
//                if (client != null) {
//                    if (from.equals("drawCash")){
//                        if (client.getHasDrawedCash() == 1) {
//                            result.put("type", 0);
//                            result.put("value", "该手机号码已经抽过奖!");
//                        } else {
//                            if(client.getCashValue() == 0)
//                            {
//                                result.put("type", 0);
//                                result.put("value", "请至手机抽奖区抽奖, 谢谢!");
//                            }else {
//                                result.put("type", 1);
//                                result.put("value", client.getCashValue());
//                                client.setHasDrawedCash((byte) 1);
//                                clientDao.setClientHasDrawedCash(client);
//                            }
//                        }
//                    }else{
//                        if (client.getHasDrawedIphone() == 1) {
//                            result.put("type", 0);
//                            result.put("value", "该手机号码已经抽过奖!");
//                        } else {
//                            result.put("type", 1);
//                            result.put("value",client.getPhoneType());
//                            client.setHasDrawedIphone((byte) 1);
//                            clientDao.setClientHasDrawedIphone(client);
//                        }
//                    }
//                } else {
//                    result.put("type", 0);
//                    result.put("value", "很遗憾,该用户没有抽奖资格!");
//                }
//            } catch (Exception e) {
//
//            }
//            renderJson(result.toString());
//        }
//    }

    public void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType + "; charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(text);
        } catch (IOException e) {
        } finally {
            //IOUtils.closeQuietly(writer);
        }
    }

    private void renderJson(String text) {
        render(getResponse(), "application/json", text);
    }

    private HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    // example for managerLogin
//    @RequestMapping(value = "/managerLogin", method = RequestMethod.GET)
//    public String managerLogin() {
//        return "/managerLogin";
//    }

    //example for managerVerify
//    @RequestMapping(value = "/managerVerify", method = RequestMethod.POST)
//    public String managerVerify(@ModelAttribute("manager") ManagerEntity managerEntity,
//                                @CookieValue(value = "hasLogin", defaultValue = "0") Integer hasLogin,
//                                HttpServletResponse response){
//
//        ManagerEntity manager = managerDao.getManagerByName(managerEntity.getName());
//
//        if(manager != null && (manager.getPassword().equals(managerEntity.getPassword()))){
//            hasLogin = 1;
//            Cookie cookie = new Cookie("hasLogin", hasLogin.toString());
//            response.addCookie(cookie);
//
//            return "redirect:/clientManage";
//        }else{
//            return "redirect:/managerLogin";
//        }
//    }

    //example for cookie
//    @RequestMapping(value = "/taxcontrolSetting", method = RequestMethod.GET)
//    public String users(ModelMap modelMap, @CookieValue(value = "hasLogin", defaultValue = "0") Integer hasLogin) {
//        if (hasLogin == 0) {
//            return "managerLogin";
//        }else{
//            List<TaxcontrolSettingEntity> taxcontrolSettingList = taxcontrolSettingDao.getTaxcontrolSettingList();
//            modelMap.addAttribute("taxcontrolSettingList", taxcontrolSettingList);
//            return "taxcontrolSetting";
//        }
//    }

    //////////////////
    @RequestMapping(value = "/clientLogin", method = RequestMethod.GET)
    public String clientLogin(ModelMap modelMap){
        //get client data
        String wechatId = "";
        List<ClientDataEntity> clientList = clientDataDao.getClientDataListByWechatId(wechatId);
        if(clientList.get(0).getCompanyName() != null && clientList.get(0).getTaxpayerId() != null) {
            modelMap.addAttribute("clientList", clientList);
            return "companyList";
        }
        else return "inputData";
    }
    @RequestMapping(value = "/inputData", method = RequestMethod.GET)
    public String inputData() {
        return "inputData";
    }
    @RequestMapping(value = "/companyList", method = RequestMethod.GET)
    public String companyList(ModelMap modelMap) {
        List<ClientDataEntity> clientList = clientDataDao.getClientDataListByWechatId("xukanfeng"); //@@get para form wechat
        modelMap.addAttribute("clientList", clientList);
        return "companyList";
    }
    @RequestMapping(value = "/modifyData", method = RequestMethod.GET)
    public String modifyData() {
        return "modifyData";
    }
    @RequestMapping(value = "/deleteData", method = RequestMethod.GET)
    public String deleteData() {
        return "deleteData";
    }
    @RequestMapping(value = "/showQRcode", method = RequestMethod.GET)
    public String showQRcode(String companyName, ModelMap modelMap) { //String companyName,
        ClientDataEntity clientData = clientDataDao.getClientDataByWechatIdAndCompanyName("xukanfeng", companyName); //@@get para form wechat
        modelMap.addAttribute("clientData", clientData);
        return "showQRcode";
    }
    /////////////////////
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public String invoice(ModelMap modelMap) {
        ClientDataEntity clientData = clientDataDao.getClientDataByWechatIdAndCompanyName("xukanfeng", "用友能源有限公司"); //@@get para form wechat
        modelMap.addAttribute("clientData", clientData);
        TaxcontrolSettingEntity taxcontrolSetting = taxcontrolSettingDao.getTaxcontrolSettingByDefault();
        modelMap.addAttribute("taxcontrolSetting", taxcontrolSetting);
        return "invoice";
    }
    @RequestMapping(value = "/invoicePost", method = RequestMethod.POST)
    public String addClientDataPost(@ModelAttribute("invoiceData") InvoiceRecordEntity invoiceRecordEntity) { /* @ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取） */
        invoiceRecordDao.addInvoiceRecord(invoiceRecordEntity);
        return "redirect:/invoiceRecord";
    }
    @RequestMapping(value = "/clientData", method = RequestMethod.GET)
    public String getClientData(ModelMap modelMap) {
        List<ClientDataEntity> clientList = clientDataDao.getClientDataList();
        modelMap.addAttribute("clientList", clientList);
        return "clientData";
    }
    @RequestMapping(value = "/searchClientData", method = RequestMethod.GET)
    public String searchClientData(String companyNameOrTaxpayerId, ModelMap modelMap) {
        if(null == companyNameOrTaxpayerId) return null;
        if(Character.isDigit(companyNameOrTaxpayerId.charAt(0))) {
            List<ClientDataEntity> clientList = clientDataDao.getClientDataListByTaxpayerId(companyNameOrTaxpayerId);
            modelMap.addAttribute("clientList", clientList);
        }
        else {
            List<ClientDataEntity> clientList = clientDataDao.getClientDataListByCompanyName(companyNameOrTaxpayerId);
            modelMap.addAttribute("clientList", clientList);
        }

        return "clientData";
    }
    @RequestMapping(value = "/addClientData", method = RequestMethod.GET)
    public String addClientData() {
        return "addClientData";
    }
    @RequestMapping(value = "/addClientDataPost", method = RequestMethod.POST)
    public String addClientDataPost(@ModelAttribute("clientData") ClientDataEntity clientDataEntity) { /* @ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取） */
        clientDataDao.addClientData(clientDataEntity);
        return "redirect:/clientData";
    }
    @RequestMapping(value = "/invoiceRecord", method = RequestMethod.GET)
    public String getInvoiceRecord(ModelMap modelMap) {
        List<InvoiceRecordEntity> invoiceRecordList = invoiceRecordDao.getInvoiceRecordList();
        modelMap.addAttribute("invoiceRecordList", invoiceRecordList);
        return "invoiceRecord";
    }
    @RequestMapping(value = "/searchInvoiceRecord", method = RequestMethod.GET)
    public String searchInvoiceRecord(String companyNameOrTaxpayerId, ModelMap modelMap) {
        if(null == companyNameOrTaxpayerId) return null;
        if(Character.isDigit(companyNameOrTaxpayerId.charAt(0))) {
            List<InvoiceRecordEntity> invoiceRecordList = invoiceRecordDao.getInvoiceRecordListByTaxpayerId(companyNameOrTaxpayerId);
            modelMap.addAttribute("invoiceRecordList", invoiceRecordList);
        }
        else {
            List<InvoiceRecordEntity> invoiceRecordList = invoiceRecordDao.getInvoiceRecordListByCompanyName(companyNameOrTaxpayerId);
            modelMap.addAttribute("invoiceRecordList", invoiceRecordList);
        }

        return "invoiceRecord";
    }
    @RequestMapping(value = "/taxcontrolSetting", method = RequestMethod.GET)
    public String getTaxcontrolSetting(ModelMap modelMap) {
        List<TaxcontrolSettingEntity> taxcontrolSettingList = taxcontrolSettingDao.getTaxcontrolSettingList();
        modelMap.addAttribute("taxcontrolSettingList", taxcontrolSettingList);
        return "taxcontrolSetting";
    }
    @RequestMapping(value = "/searchTaxcontrolSetting", method = RequestMethod.GET)
    public String searchTaxcontrolSetting(String companyNameOrTaxpayerId, ModelMap modelMap) {
        if(null == companyNameOrTaxpayerId) return null;
        if(Character.isDigit(companyNameOrTaxpayerId.charAt(0))) {
            List<TaxcontrolSettingEntity> taxcontrolSettingList = taxcontrolSettingDao.getTaxcontrolSettingListByTaxpayerId(companyNameOrTaxpayerId);
            modelMap.addAttribute("taxcontrolSettingList", taxcontrolSettingList);
        }
        else {
            List<TaxcontrolSettingEntity> taxcontrolSettingList = taxcontrolSettingDao.getTaxcontrolSettingListByCompanyName(companyNameOrTaxpayerId);
            modelMap.addAttribute("taxcontrolSettingList", taxcontrolSettingList);
        }
        return "taxcontrolSetting";
    }

    public final class MatrixToImageWriter {

        private static final int BLACK = 0xFF000000;
        private static final int WHITE = 0xFFFFFFFF;

        private MatrixToImageWriter() {}

        //inner class cannot have static declarations
        public BufferedImage toBufferedImage(BitMatrix matrix) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
                }
            }
            return image;
        }

        public void writeToFile(BitMatrix matrix, String format, File file)
                throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if (!ImageIO.write(image, format, file)) {
                throw new IOException("Could not write an image of format " + format + " to " + file);
            }
        }

        public void writeToStream(BitMatrix matrix, String format, OutputStream stream)
                throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if (!ImageIO.write(image, format, stream)) {
                throw new IOException("Could not write an image of format " + format);
            }
        }
    }
    @RequestMapping(value = "/generateQRcode", method = RequestMethod.POST)
    public String generateQRcode(@ModelAttribute("clientData") ClientDataEntity clientDataEntity, ModelMap modelMap) { /* @ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取） */
        clientDataEntity.setWechatId("xukanfeng"); //@@get para form wechat
        clientDataDao.addClientData(clientDataEntity);

        try {
            String content = clientDataEntity.getWechatId() + "_" + clientDataEntity.getTaxpayerId(); //@@get para form wechat
            String path = "/Users/xu_kanfeng/Documents/tax_system/src/main/webapp/invoiceSystem/images/QRcode";
            //"../../../../webapp/invoiceSystem/images/QRcode";
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            //内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "gb2312");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
            //生成二维码
            File outputFile = new File(path, clientDataEntity.getWechatId() + "_" + clientDataEntity.getTaxpayerId() + ".jpg"); //@@get para form wechat
            MatrixToImageWriter matrixToImageWriter = new MatrixToImageWriter();
            matrixToImageWriter.writeToFile(bitMatrix, "jpg", outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<ClientDataEntity> clientList = clientDataDao.getClientDataListByWechatId("xukanfeng"); //@@get para form wechat
        modelMap.addAttribute("clientList", clientList);
        return "companyList";
    }
    @RequestMapping(value = "/setDefaultTaxcontrolSetting", method = RequestMethod.GET)
    public String setDefaultTaxcontrolSetting(ModelMap modelMap) {
        List<TaxcontrolSettingEntity> taxcontrolSettingList = taxcontrolSettingDao.getTaxcontrolSettingList();
        modelMap.addAttribute("taxcontrolSettingList", taxcontrolSettingList);
        return "taxcontrolSetting";
    }
    @RequestMapping(value = "/deleteTaxcontrolSetting", method = RequestMethod.GET)
    public String deleteTaxcontrolSetting(String shopName, String machineId) {
        taxcontrolSettingDao.deleteTaxcontrolSetting(shopName, machineId);
        return "redirect:/taxcontrolSetting";
    }
    @RequestMapping(value = "/updateTaxcontrolSetting", method = RequestMethod.GET)
    public String updateTaxcontrolSetting(String shopName, String machineId, ModelMap modelMap) {
        TaxcontrolSettingEntity taxcontrolSetting = taxcontrolSettingDao.getTaxcontrolSetting(shopName, machineId); //@@get para form wechat
        modelMap.addAttribute("taxcontrolSetting", taxcontrolSetting);
        return "updateTaxcontrolSetting";
    }
    @RequestMapping(value = "/updateTaxcontrolSettingPost", method = RequestMethod.GET)
    public String updateTaxcontrolSettingPost(String shopName, String machineId) {

        return "redirect:/taxcontrolSetting";
    }
    @RequestMapping(value = "/addTaxcontrolSetting", method = RequestMethod.GET)
    public String addTaxcontrolSetting() {
        return "addTaxcontrolSetting";
    }
    @RequestMapping(value = "/addTaxcontrolSettingPost", method = RequestMethod.POST)
    public String addTaxcontrolSettingPost(@ModelAttribute("taxcontrolSetting") TaxcontrolSettingEntity taxcontrolSettingEntity) { /* @ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取） */
        taxcontrolSettingDao.addTaxcontrolSetting(taxcontrolSettingEntity);
        return "redirect:/taxcontrolSetting";
    }
}

