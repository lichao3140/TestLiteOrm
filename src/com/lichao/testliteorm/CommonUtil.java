package com.lichao.testliteorm;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Looper;
import android.text.TextUtils;

public class CommonUtil {
	//============================����=============================
    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    //ȫ��Ϊ��
    public static boolean isAllEmpty(List... lists) {
        for (List list : lists) {
            if (!isEmpty(list)) {
                return false;
            }
        }

        return true;
    }

    //��һ��Ϊ��
    public static boolean isOneEmpty(List... lists) {
        for (List list : lists) {
            if (isEmpty(list)) {
                return true;
            }
        }

        return false;
    }


    //============================�ַ���============================================
    public static boolean isEmpty(String s) {
        return s == null || TextUtils.isEmpty(s);
    }

    //ȫ��Ϊ��
    public static boolean isAllEmpty(String... strings) {
        for (String s : strings) {

            if (!isEmpty(s)) {
                //�����һ����Ϊ���򷵻�false.
                return false;
            }

        }

        return true;
    }

    //��һ��Ϊ��
    public static boolean isOneEmpty(String... strings) {
        for (String s : strings) {
            if (isEmpty(s)) {
                return true;
            }
        }

        return false;
    }


    //============================URL============================================

    /**
     * ֻencode����
     */
    public static String encode(String sourceString) {
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Matcher matcher = pattern.matcher(sourceString);
        while (matcher.find()) {
            String s1 = matcher.group();
            sourceString = sourceString.replace(s1, urlEncode(s1));
        }

        return sourceString;
    }


    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return URLEncoder.encode(s);
        }
    }

    public static String urlDecode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return URLDecoder.decode(s);
        }
    }

    //============================ELSE============================================

    //����uuid
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //�ж��Ƿ������߳�
    public boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
