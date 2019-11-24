package com.everydaymall.utils;

import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * Converts a line of text into an array of lower case words. Words are
     * delimited by the following characters: , .\r\n:/\+
     * <p/>
     * In the future, this method should be changed to use a
     * BreakIterator.wordInstance(). That class offers much more fexibility.
     *
     * @param text a String of text to convert into an array of words
     * @return text broken up into an array of words.
     */
    public   final String[] toLowerCaseWordArray(String text) {
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        StringTokenizer tokens = new StringTokenizer(text, " ,\r\n.:/\\+");
        String[] words = new String[tokens.countTokens()];
        for (int i = 0; i < words.length; i++) {
            words[i] = tokens.nextToken().toLowerCase();
        }
        return words;
    }

    /**
     * Converts a line of text into an array of lower case words. Words are
     * delimited by the following characters: , .\r\n:/\+
     * <p/>
     * In the future, this method should be changed to use a
     * BreakIterator.wordInstance(). That class offers much more fexibility.
     *
     * @param text a String of text to convert into an array of words
     * @return text broken up into an array of words.
     */
    public   final String[] toStringArray(String text) {
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        StringTokenizer tokens = new StringTokenizer(text, ",\r\n/\\");
        String[] words = new String[tokens.countTokens()];
        for (int i = 0; i < words.length; i++) {
            words[i] = tokens.nextToken();
        }
        return words;
    }

    /**
     * * Converts a line of text into an array of lower case words. Words are
     * delimited by the following characters: , .\r\n:/\+
     * <p/>
     * In the future, this method should be changed to use a
     * BreakIterator.wordInstance(). That class offers much more fexibility.
     *
     * @param text  a String of text to convert into an array of words
     * @param token String
     * @return String[]broken up into an array of words.
     */
    public   final String[] toStringArray(String text, String token) {
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        StringTokenizer tokens = new StringTokenizer(text, token);
        String[] words = new String[tokens.countTokens()];
        for (int i = 0; i < words.length; i++) {
            words[i] = tokens.nextToken();
        }
        return words;
    }

    /**
     * @param source
     * @return
     */
    public   String[] splitOnWhitespace(String source) {
        int pos = -1;
        LinkedList<String> list = new LinkedList<String>();
        int max = source.length();
        for (int i = 0; i < max; i++) {
            char c = source.charAt(i);
            if (Character.isWhitespace(c)) {
                if (i - pos > 1) {
                    list.add(source.substring(pos + 1, i));
                }
                pos = i;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * Reppartner str
     *
     * @param str
     * @param key
     * @param replacement
     * @return
     */
    public  String replaceAll(String str, String key,
                                          String replacement) {
        if (str != null && key != null && replacement != null
                && !str.equals("") && !key.equals("")) {
            StringBuilder strbuf = new StringBuilder();
            int begin = 0;
            int slen = str.length();
            int npos = 0;
            int klen = key.length();
            for (; begin < slen && (npos = str.indexOf(key, begin)) >= begin; begin = npos
                    + klen) {
                strbuf.append(str.substring(begin, npos)).append(replacement);
            }

            if (begin == 0) {
                return str;
            }
            if (begin < slen) {
                strbuf.append(str.substring(begin));
            }
            return strbuf.toString();
        } else {
            return str;
        }
    }

    /**
     * 合并串,并替换其中的变量
     *
     * @param id
     * @param params
     * @return
     */
    public  String mergString(String id, String... params) {
        if (id == null) {
            return id;
        } else {
            for (int i = 0; i < params.length; i++) {
                id = replaceAll(id, "$" + i, params[i]);
            }
            return id;
        }
    }

    @SuppressWarnings("rawtypes")
    public   String getUrl(Map map) {
        if (null == map || map.keySet().size() == 0) {
            return ("");
        }
        StringBuffer url = new StringBuffer();
        Set keys = map.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = String.valueOf(i.next());
            if (map.containsKey(key)) {
                Object val = map.get(key);
                String str = val != null ? val.toString() : "";
                url.append(key).append("=").append(str).append("&");
            }
        }
        String strURL = "";
        strURL = url.toString();
        if ("&".equals("" + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return (strURL);
    }

    /**
     * 字符串转换成数字
     *
     * @param str 数字形式的字符串如:"11"
     * @return Integer 如:11
     */
    public   int str2Int(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        } else {
            try {
                return Integer.valueOf(str);
            } catch (Exception e) {
                return 0;
            }

        }
    }

    public   long str2Long(String str) {
        if (isEmpty(str)) {
            return 0;
        } else {
            return Long.parseLong(str);
        }
    }

    public   double str2Double(String str) {
        if (isEmpty(str)) {
            return 0;
        } else {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    /**
     * 字符串处理,当字符串为null时,以""形式返回
     *
     * @param str
     * @return String
     */
    public   String str2NULL(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 字符串处理,当字符串为null或""时,返回"0"
     *
     * @param str
     * @return
     */
    public   String Str2IntStr(String str) {
        if (str == null || "".equals(str)) {
            return "0";
        } else {
            return str;
        }
    }

    /**
     * 加密(SHA-256)
     *
     * @param strSrc
     * @param encName
     * @return
     */
    public   String Encrypt(String strSrc, String encName) {
        if (isEmpty(strSrc))
            return null;
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * 16进制转换
     *
     * @param bts
     * @return
     */
    public   String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public   String toHexString(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            if (notEmpty(s4)) {
                str.append(s4);
            }
        }
        return str.toString();
    }

    /**
     * 字符串转换
     *
     * @param s
     * @return
     */
    public   byte[] str2bytes(String s) {
        if (s == null) {
            return null;
        }

        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            String tmp = s.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(tmp, 16);
        }
        return bytes;
    }

    /**
     * 字符串字符过滤
     *
     * @param str
     * @return
     */
    public   String replaceHttpXmlString(String str) {
        String[] rStrings = new String[]{"&", ">", "<", "‘", "#", " ", "\""};
        String[] xmlStrings = new String[]{"&amp;", "&gt ;", "&lt;",
                "&apos;", "&#35;", "&nbsp;", "&quot;"};
        for (int i = 0; i < rStrings.length; i++) {
            str = str.replace(rStrings[i], xmlStrings[i]);
        }
        return str;
    }

    /**
     * 产生随机字符串
     *
     * @param length
     * @return
     */
    public   String randomString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int loop = 0; loop < length; loop++)
            sb.append(hexDigits[rand.nextInt(hexDigits.length)]);
        return sb.toString();
    }

    /**
     * 产生随机字符串
     *
     * @param length
     * @return
     */
      String randomNumber(int length) {
        StringBuffer sb = new StringBuffer();
        for (int loop = 0; loop < length; loop++)
            sb.append(digits[rand.nextInt(digits.length)]);
        return sb.toString();
    }

    static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static final char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9'};

    static final Random rand = new Random();

    /**
     * 随机码
     *
     * @return
     */
    public   String getSN() {
        String sn = getOrderNo(8);
        String date = DateUtil.getcurrentDatetime("yyMMdd");
        return date + sn;
    }

    /**
     * 随机码
     *
     * @return
     */
    public   String getOrderNo(int n) {
        String sn = randomNumber(n);
        return sn;
    }

    /**
     * @param str
     * @return string
     */
    public   String getValue(String str) {
        if (null == str) {
            return "";
        }
        if ("".equals(str) || "null".equals(str) || "NULL".equals(str)) {
            return "";
        }
        return str.trim();
    }

    /**
     * 判空
     *
     * @param str
     * @return boolean
     */
    public   boolean isEmpty(String str) {
        return "".equals(getValue(str));
    }

    /**
     * 非空
     *
     * @param str value
     * @return boolean
     */
    public   boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 将String字符串转换为java.sql.Clob
     *
     * @param value
     * @return
     * @see java.sql.Clob
     */
    public   Clob str2Clob(String value) {
        Clob clob = null;
        try {
            clob = new SerialClob(value.toCharArray());
        } catch (SerialException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clob;
    }

    /**
     * 将Clob转为String
     *
     * @param clob
     * @return
     */
    public static String clob2Str(Clob clob) {
        if (clob != null)
            try {
                return clob.getSubString((long) 1, (int) clob.length());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    public   String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 解析简体中文，汉字
     *
     * @param character
     * @return
     */
    public   String chineseChar(String character) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]");
        Matcher matcher = pattern.matcher(character);
        while (matcher.find()) {
            sb.append(matcher.group(0));
        }
        return sb.toString();
    }

    /**
     * 判断字符长度，为空或NULL时，返回0
     *
     * @param leng
     * @return
     */
    public   int length(String leng) {
        if (isEmpty(leng))
            return 0;
        else
            return leng.length();
    }

    /**
     * 是否包含中文(简体)，true为包含。
     *
     * @param character
     * @return
     */
    public   boolean hasChineseChar(String character) {
        return chineseChar(character).trim().length() > 0 ? true : false;
    }

    public   int getStringNum(String sA, String sB, int num) {
        int position = 0;
        for (int i = 1; i < num; i++) {
            if (position == 0) {
                position = sA.toString().indexOf(sB);
            }
            // System.out.println(sB+" 在"+sA+" 中第"+i+"次出现的位置"+(weizhi+1));
            position = sA.indexOf(sB, position + 1);
        }
        return position + 1;
    }

    /**
     * 字符串数组转Integer数组
     * @param value
     * @return
     */
    public static Integer[] stringToInteger(String[] value){
        IntegerConverter integerConverter = new IntegerConverter();
        ArrayConverter arrayConverter = new ArrayConverter(Integer[].class,integerConverter);
        Integer[] b = (Integer[]) arrayConverter.convert(Integer[].class, value);
        return b;
    }
    
    public static class Singleton{
        private static StringUtils stringUtils;
        
        static {
            stringUtils=new StringUtils();
        }
        public static  StringUtils getInstance() {
            return stringUtils;
        }
    }
    
    public static StringUtils getInstance() {
        return Singleton.getInstance();
    }
    
    public  void init() {
        getInstance();
    }
}
