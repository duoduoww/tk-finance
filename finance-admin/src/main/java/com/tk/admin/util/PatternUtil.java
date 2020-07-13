package com.tk.admin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @program: tk-finance
 * @description: 表达式判断
 * @author: kzc
 * @create: 2020-07-13 12:51
 **/
public class PatternUtil {

    public final static String PAR_MOBILE = "^[1][3,4,5,7,8][0-9]{9}$";

    public static boolean isMobile(String mobile){
        Pattern p = compile(PAR_MOBILE);
        Matcher m =  p.matcher(mobile);
        return m.matches();
    }
}
