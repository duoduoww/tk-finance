package com.tk.admin.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;

/**
 * @program: tk-finance
 * @description: JNA打印
 * @author: kzc
 * @create: 2020-07-14 11:42
 **/
public class JnaUtil {



    /**
     * DLL动态库调用方法
     * @Description: 读取调用CDecl方式导出的DLL动态库方法
     * @author: LinWenLi
     * @date: 2018年7月18日 上午10:49:02
     */
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary("msvcrt",
                        CLibrary.class);

        // DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径。（此处：(Platform.isWindows()?"msvcrt":"c")指本地动态库msvcrt.dll）
        void printf(String format, Object... args);
        // 声明将要调用的DLL中的方法,可以是多个方法(此处示例调用本地动态库msvcrt.dll中的printf()方法)
        // int openport (String pirnterName);
    }

    public static void main2(String[] args) {
        CLibrary.INSTANCE.printf("Hello, World\n");
        // CLibrary.INSTANCE.openport("TSC TTP-2410M");

        String[] arr = {"稽核","深刻的","skiers"};
        for (int i=0;i < arr.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, arr[i]);
        }
    }



    public interface TscLibDll extends StdCallLibrary {
          // 动态库实例
        TscLibDll INSTANCE = (TscLibDll) Native.loadLibrary ("TSCLIB", TscLibDll.class);
        int about ();
        int openport (String pirnterName);
        int closeport ();
        int sendcommand (String printerCommand);
        int setup (String width,String height,String speed,String density,String sensor,String vertical,String offset);
        int downloadpcx (String filename,String image_name);
        int barcode (String x,String y,String type,String height,String readable,String rotation,String narrow,String wide,String code);
        int printerfont (String x,String y,String fonttype,String rotation,String xmul,String ymul,String text);
        int clearbuffer ();
        int printlabel (String set, String copy);
        int formfeed ();
        int nobackfeed ();
        int windowsfont (int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, String content);
    }

    public static void main3(String[] args) {
        System.setProperty("jna.encoding", "GBK");// 支持中文
        // System.loadLibrary("TSCLIB");
        //TscLibDll.INSTANCE.about();
        TscLibDll.INSTANCE.openport("TSC TTP-244 pro");   //打印机型号
        //TscLibDll.INSTANCE.downloadpcx("C:\\UL.PCX", "UL.PCX");
        //打印二维码的参数和内容
        TscLibDll.INSTANCE.sendcommand("REM ***** This is a test by JAVA. *****");
        TscLibDll.INSTANCE.setup("100", "100", "5", "7", "0", "0", "0");
        // 清除
        TscLibDll.INSTANCE.clearbuffer();
        TscLibDll.INSTANCE.printerfont ("100", "10", "3", "0", "1", "1", "(JAVA) DLL Test!!");
        // 文本内容打印
        TscLibDll.INSTANCE.windowsfont(300, 10, 50, 0, 2, 0, "arial", "布小生中大店");
        TscLibDll.INSTANCE.windowsfont(100, 60, 38, 0, 0, 0, "arial", "品名：BXS2006");
        TscLibDll.INSTANCE.windowsfont(100, 140, 38, 0, 0, 0, "arial", "颜色：4#");
        TscLibDll.INSTANCE.windowsfont(100, 180, 38, 0, 0, 0, "arial", "数量：1222米");
        TscLibDll.INSTANCE.windowsfont(100, 220, 38, 0, 0, 0, "arial", "批号：52233");
        TscLibDll.INSTANCE.windowsfont(100, 260, 38, 0, 0, 0, "arial", "匹号：1");
        TscLibDll.INSTANCE.windowsfont(100, 300, 38, 0, 0, 0, "arial", "幅宽：150CM");
        TscLibDll.INSTANCE.windowsfont(100, 340, 38, 0, 0, 0, "arial", "克重：150CM");
        TscLibDll.INSTANCE.windowsfont(100, 380, 38, 0, 0, 0, "arial", "成分：20%绵纶 80人棉");

        //TscLibDll.INSTANCE.sendcommand("PUTPCX 550,10,\"UL.PCX\"");  //传送指令
        TscLibDll.INSTANCE.barcode("300", "440", "128", "38", "1", "0", "2", "2", "2020071622");

        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }




    public static void main(String[] args) {
        System.setProperty("jna.encoding", "GBK");// 支持中文
        //TscLibDll.INSTANCE.about();
        TscLibDll.INSTANCE.openport("TSC TTP-244 pro");
        //TscLibDll.INSTANCE.downloadpcx("C:\\UL.PCX", "UL.PCX");
        TscLibDll.INSTANCE.sendcommand("REM ***** This is a test by JAVA. *****");
        TscLibDll.INSTANCE.setup("60", "80", "5", "8", "0", "0", "0");
        TscLibDll.INSTANCE.clearbuffer();
        //TscLibDll.INSTANCE.sendcommand("PUTPCX 550,10,\"UL.PCX\"");
        // TscLibDll.INSTANCE.printerfont ("100", "10", "3", "0", "1", "1", "(JAVA) DLL Test!!");

        TscLibDll.INSTANCE.windowsfont(50, 20, 50, 0, 2, 0, "arial", "布小生中大店");
        TscLibDll.INSTANCE.windowsfont(20, 100, 40, 0, 0, 0, "arial", "品名：BXS2006");
        TscLibDll.INSTANCE.windowsfont(20, 145, 40, 0, 0, 0, "arial", "颜色：4#");
        TscLibDll.INSTANCE.windowsfont(20, 190, 40, 0, 0, 0, "arial", "数量：1222米");
        TscLibDll.INSTANCE.windowsfont(20, 235, 40, 0, 0, 0, "arial", "批号：52233");
        TscLibDll.INSTANCE.windowsfont(20, 290, 40, 0, 0, 0, "arial", "匹号：1");
        TscLibDll.INSTANCE.windowsfont(20, 335, 40, 0, 0, 0, "arial", "幅宽：150CM");
        TscLibDll.INSTANCE.windowsfont(20, 380, 40, 0, 0, 0, "arial", "克重：150CM");
        TscLibDll.INSTANCE.windowsfont(20, 425, 40, 0, 0, 0, "arial", "成分：20%绵纶 80人棉");


        //TscLibDll.INSTANCE.barcode("350", "500", "128", "50", "1", "0", "2", "2", "123456789");
        // TscLibDll.INSTANCE.clearbuffer();
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }
}


































