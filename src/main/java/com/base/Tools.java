package com.base;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.entity.ErrorLog;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tools {
    private final static Logger logger = LoggerFactory.getLogger("DingdingTool");


    public static boolean CRS_sendDingMsg(String method, String url, int code1, int code2,
                                          String logUrl, String[] dingding) {
        //  ok:  response:{"errmsg":"ok","errcode":0}
        boolean sendstat = true;
        if (dingding != null) {
            for (String ding : dingding) {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=" + ding.trim());
                OapiRobotSendRequest request = new OapiRobotSendRequest();
                request.setMsgtype("markdown");
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle("错误警告");
                markdown.setText("##  监控报警:" + method + "     " + url + "\r\n" +
                        "---\r\n" +
                        "+ *返回码: host1=" + code1 + "; host2=" + code2 + "**" +
                        "  \r\n    +  [点此查看详细信息](" + logUrl + ")");
                request.setMarkdown(markdown);
                OapiRobotSendResponse response = null;
                try {
                    response = client.execute(request);
                } catch (ApiException e) {
                    e.printStackTrace();
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }

//    System.out.println("response:"+response.getBody().toString());
                if (response.getErrmsg().equals("ok")) {
                    sendstat = true;
                    logger.info("发送钉钉{}成功:" + ding);
                } else {
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }
            }
        }
        return sendstat;
    }


    public static boolean sendDingMsg(ErrorLog errorLog, String logUrl, String[] dingding) {
        //  ok:  response:{"errmsg":"ok","errcode":0}
        boolean sendstat = true;
        if (dingding != null) {
            for (String ding : dingding) {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=" + ding.trim());
                OapiRobotSendRequest request = new OapiRobotSendRequest();
                request.setMsgtype("markdown");
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle("错误警告");
                markdown.setText("##  监控报警:" + errorLog.getMethod() + "     " + errorLog.getUrl() + "\r\n" +
                        "---\r\n" +
                        "+ 返回码: " + errorLog.getRes_code() + " , 响应时长:" + errorLog.getElapsedTime() + "ms " +
                        "\r\n" +
                        "+ [点此查看详细信息](" + logUrl + ")");
                request.setMarkdown(markdown);
                OapiRobotSendResponse response = null;
                try {
                    response = client.execute(request);
                } catch (ApiException e) {
                    e.printStackTrace();
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }

                if (response.getErrmsg().equals("ok")) {
//                    sendstat=true;
                    logger.info("发送钉钉{}成功:" + ding);
                } else {
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }
            }

        }
        return sendstat;
    }


    public static boolean sendDingMsg2(String msg, String[] dingding) {
        //  ok:  response:{"errmsg":"ok","errcode":0}
        boolean sendstat = true;
        if (dingding != null) {
            for (String ding : dingding) {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=" + ding.trim());
                OapiRobotSendRequest request = new OapiRobotSendRequest();
                request.setMsgtype("markdown");
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle("监控报警:错误警告");
                markdown.setText("##   出现异常: \r\n +" + msg + "\r\n"
                );
                request.setMarkdown(markdown);
                OapiRobotSendResponse response = null;
                try {
                    response = client.execute(request);
                } catch (ApiException e) {
                    e.printStackTrace();
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }

                if (response.getErrmsg().equals("ok")) {
//                    sendstat=true;
                    logger.info("发送钉钉{}成功:" + ding);
                } else {
                    sendstat = false;
                    logger.error("发送钉钉{}失败:" + ding);
                }
            }

        }
        return sendstat;
    }

//    public String  replaceExcept(String content,String patten){
//        // "key":***,
////        String Patten=patten+"(.*)\n";
//        String Patten=patten+"([^,]*,)";
//        Pattern pattern = Pattern.compile(Patten);
//        // 忽略大小写的写法
//        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
//        Matcher m = pattern.matcher(content);
//        while (m.find()) {
//            String name=m.group();
//            logger.info("匹配的except内容名称***:"+name);
//            content=content.replace(name,"");
//        }
//        return content;
//    }

}
