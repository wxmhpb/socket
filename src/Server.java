import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Server {

    public static void main(String[] args) {


        int[] len = {4, 6, 8, 6, 2, 2, 1};

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("开启监听 8000 端口...");

            System.out.println("Server started at " + new Date() + '\n');
            byte[] buf = new byte[29];
//        int count = 0;
            while (true) {
                //            count++;
                //            System.out.println(count);
                Socket socket = serverSocket.accept();
                System.out.println(socket.getLocalAddress() + " : " + socket.getPort() + " 与我建立了链接....");

                if (socket != null) {
                    DataInputStream inputFromClient = new DataInputStream(new BufferedInputStream(
                            socket.getInputStream()));
                    DataOutputStream outputToClient = new DataOutputStream(new BufferedOutputStream(
                            socket.getOutputStream()));
                    inputFromClient.read(buf, 0, 29);
                    String str = new String(buf);

                    //s1为电文长度
                    //System.out.println(len2);
                    //len3为结束符

                    //                System.out.println(len3);
                    char bb;//判断电文是否传送成功，A为成功，B为失败
                    //结束符
                    String len3 = Integer.toString(0x0a);
                    int cc = Integer.parseInt(len3);
                    System.out.println("cc = " + cc);
                    int j = 0, count1 = 0;
                    while (cc != 10) {
                        inputFromClient.read(buf, j, 1);
                        cc = buf[j];
                        j++;
                        count1++;
                    }
                    if (count1 == 28) {
                        bb = 'A';
                    } else {
                        bb = 'B';
                    }


                    //inputFromClient.close();
                    int index = 0;
                    String s1 = "";

                    for (int i = 0; i < 1; i++) {

                        s1 = str.substring(index, index + len[i]);
                        index += len[i];
                    }

                    String s2 = "";

                    for (int i = 1; i < 2; i++) {

                        s2 = str.substring(index, index + len[i]);
                        index += len[i];
                    }

                    //  System.out.println("s2--" + s2);
                    if (s2.equals("JOLMY1")) {
                        socket.close();
                        fuliao();

                    } else if (s2.equals("JOLM01")) {
                        socket.close();
                        shengchanjihua();


                    } else if (s2.equals("JOLM11")) {
                        socket.close();
                        chugang();


                    } else if (s2.equals("JNLM01")) {
                        socket.close();
                        cheliangguobang();

                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void cheliangguobang() throws Exception {
        int[] len = {4, 6, 8, 6, 2, 2, 1, 1, 20, 12, 20, 20, 50, 20, 10, 100, 100, 50, 50, 60, 60, 11, 11, 11, 14, 14, 14, 14, 100, 20, 20, 20};

        ServerSocket serverSocket = new ServerSocket(8002);
        System.out.println("Server started at " + new Date() + '\n');
//        Socket socket = serverSocket.accept();
//        DataInputStream inputFromClient = new DataInputStream(
//                socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(
//                socket.getOutputStream());

        FileOutputStream output = new FileOutputStream("cheliangguobang1.txt");

        byte[] buf = new byte[880];
//        int count = 0;
        while (true) {
//            count++;
//            System.out.println(count);

            Socket socket = serverSocket.accept();
            if (socket != null) {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                inputFromClient.read(buf, 0, 880);
                String str = new String(buf);
                //s1为电文长度
                //System.out.println(len2);
                //len3为结束符

//                System.out.println(len3);
                char bb;//判断电文是否传送成功，A为成功，B为失败
                //结束符
                String len3 = Integer.toString(0x0a);
                int cc = Integer.parseInt(len3);
                int j = 0, count1 = 0;
                while (cc != 10) {
                    inputFromClient.read(buf, j, 1);
                    cc = buf[j];
                    j++;
                    count1++;
                }
                if (count1 == 879) {
                    bb = 'A';
                } else {
                    bb = 'B';
                }


                //inputFromClient.close();
                int index = 0;

                String s1 = "";
                System.out.println("电文长度------------");
                for (int i = 0; i < 1; i++) {

                    s1 = str.substring(index, index + len[i]);

                    System.out.println(s1);
                    index += len[i];
                }

                String s2 = "";
                System.out.println("电文号------------");
                for (int i = 1; i < 2; i++) {

                    s2 = str.substring(index, index + len[i]);
                    System.out.println(s2);

                    index += len[i];
                }
                String s3 = "";
                System.out.println("电文发送日期------------");
                for (int i = 2; i < 3; i++) {

                    s3 = str.substring(index, index + len[i]);

                    System.out.println(s3);
                    index += len[i];
                }
                String s4 = "";
                System.out.println("电文发送时间------------");
                for (int i = 3; i < 4; i++) {

                    s4 = str.substring(index, index + len[i]);

                    System.out.println(s4);
                    index += len[i];
                }
                String s5 = "";
                System.out.println("发送端描述码------------");
                for (int i = 4; i < 5; i++) {

                    s5 = str.substring(index, index + len[i]);

                    System.out.println(s5);
                    index += len[i];
                }
                String s6 = "";
                System.out.println("接收端描述码------------");
                for (int i = 5; i < 6; i++) {

                    s6 = str.substring(index, index + len[i]);

                    System.out.println(s6);
                    index += len[i];
                }
                String s7 = "";
                System.out.println("传送功能码------------");
                for (int i = 6; i < 7; i++) {

                    s7 = str.substring(index, index + len[i]);

                    System.out.println(s7);
                    index += len[i];
                }
                System.out.println("处理标志:------------");
                for (int i = 7; i < 8; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }

                System.out.println("磅单号------------");
                for (int i = 8; i < 9; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("计量委托号------------");
                for (int i = 9; i < 10; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("车号------------");
                for (int i = 10; i < 11; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("货名代码------------");
                for (int i = 11; i < 12; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("货名中文------------");
                for (int i = 12; i < 13; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("订单编号------------");
                for (int i = 13; i < 14; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("收货单位代码------------");
                for (int i = 14; i < 15; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("收货单位------------");
                for (int i = 15; i < 16; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("发货单位------------");
                for (int i = 16; i < 17; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("装点------------");
                for (int i = 17; i < 18; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("卸点------------");
                for (int i = 18; i < 19; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("皮重磅站------------");
                for (int i = 19; i < 20; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("毛重磅站------------");
                for (int i = 20; i < 21; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("毛重------------");
                for (int i = 21; i < 22; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("皮重------------");
                for (int i = 22; i < 23; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("净重------------");
                for (int i = 23; i < 24; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("过毛时间------------");
                for (int i = 24; i < 25; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("过皮时间------------");
                for (int i = 25; i < 26; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("磅单时间------------");
                for (int i = 26; i < 27; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("修改时间------------");
                for (int i = 27; i < 28; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("船批号------------");
                for (int i = 28; i < 29; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("预留字段1------------");
                for (int i = 29; i < 30; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("预留字段2------------");
                for (int i = 30; i < 31; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("预留字段3------------");
                for (int i = 31; i < 32; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("------------");
                StringBuilder sb = new StringBuilder();
                sb.append("0110");
                sb.append(str.substring(0, 879));
                sb.append(bb);
                sb.append(String.join("", Collections.nCopies(80, " ")));
                //System.out.println("length:" + sb.length());
                sb.append("\n");
                System.out.println("length:" + sb.length());
                //如果bb输出为A，说明成功，B为失败
                System.out.println("bb:" + sb.charAt(879));
                //System.out.println("answer:" + sb);
                //byte[] answerMsg = new byte[110];
                byte[] answerMsg = sb.toString().getBytes();
                // for(int i = 0; i < answerMsg.length; i++){
                //  System.out.println(answerMsg[i]);
                //}
                outputToClient.write(answerMsg, 0, 950);

                output.write(buf, 0, 880);
                //output.close();

            }
        }


    }

    public static void chugang() {
        int[] len = {4, 6, 8, 6, 2, 2, 2, 2, 3, 2, 6, 8, 7, 6, 20, 8, 20, 20, 1, 1, 1, 1, 1};
        //, 6, 3, 3, 2, 1, 1, 1, 14, 14, 14, 14, 14, 14, 14, 14, 1, 14, 14, 1, 14, 14, 1, 14, 14, 1, 14, 14, 14, 3, 10

        try {
            ServerSocket serverSocket = new ServerSocket(8003);
            System.out.println("Server started at " + new Date() + '\n');

            FileOutputStream output = new FileOutputStream("chugang1.txt");

            byte[] buf = new byte[450];
//        int count = 0;
            while (true) {
                //            count++;
                //            System.out.println(count);

                Socket socket = serverSocket.accept();
                if (socket != null) {
                    DataInputStream inputFromClient = new DataInputStream(
                            socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream(
                            socket.getOutputStream());
                    inputFromClient.read(buf, 0, 450);
                    String str = new String(buf);
                    //s1为电文长度
                    //System.out.println(len2);
                    //len3为结束符

                    //                System.out.println(len3);
                    char bb;//判断电文是否传送成功，A为成功，B为失败
                    //结束符
                    String len3 = Integer.toString(0x0a);
                    int cc = Integer.parseInt(len3);
                    int j = 0, count1 = 0;
                    while (cc != 10) {
                        inputFromClient.read(buf, j, 1);
                        cc = buf[j];
                        j++;
                        count1++;
                    }
                    if (count1 == 266) {
                        bb = 'A';
                    } else {
                        bb = 'B';
                    }


                    //inputFromClient.close();
                    int index = 0;

                    String s1 = "";
                    System.out.println("电文长度------------");
                    for (int i = 0; i < 1; i++) {

                        s1 = str.substring(index, index + len[i]);

                        System.out.println(s1);
                        index += len[i];
                    }

                    String s2 = "";
                    System.out.println("电文号------------");
                    for (int i = 1; i < 2; i++) {

                        s2 = str.substring(index, index + len[i]);
                        System.out.println(s2);

                        index += len[i];
                    }
                    String s3 = "";
                    System.out.println("电文发送日期------------");
                    for (int i = 2; i < 3; i++) {

                        s3 = str.substring(index, index + len[i]);

                        System.out.println(s3);
                        index += len[i];
                    }
                    String s4 = "";
                    System.out.println("电文发送时间------------");
                    for (int i = 3; i < 4; i++) {

                        s4 = str.substring(index, index + len[i]);

                        System.out.println(s4);
                        index += len[i];
                    }
                    String s5 = "";
                    System.out.println("发送端描述码------------");
                    for (int i = 4; i < 5; i++) {

                        s5 = str.substring(index, index + len[i]);

                        System.out.println(s5);
                        index += len[i];
                    }
                    String s6 = "";
                    System.out.println("接收端描述码------------");
                    for (int i = 5; i < 6; i++) {

                        s6 = str.substring(index, index + len[i]);

                        System.out.println(s6);
                        index += len[i];
                    }
                    String s7 = "";
                    System.out.println("传送功能码------------");
                    for (int i = 6; i < 7; i++) {

                        s7 = str.substring(index, index + len[i]);

                        System.out.println(s7);
                        index += len[i];
                    }
                    System.out.println("电文组数:------------");
                    for (int i = 7; i < 8; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }

                    System.out.println("电文组序号------------");
                    for (int i = 8; i < 9; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("计划总炉数------------");
                    for (int i = 9; i < 10; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("电文炉数------------");
                    for (int i = 10; i < 11; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    String s9 = "";
                    System.out.println("计划号------------");
                    for (int i = 11; i < 12; i++) {

                        s9 = str.substring(index, index + len[i]);
                        System.out.println(s9);
                        index += len[i];
                    }
                    System.out.println("制造命令号------------");
                    for (int i = 12; i < 13; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("LOT号------------");
                    for (int i = 13; i < 14; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("熔炼号------------");
                    for (int i = 14; i < 15; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    String s10 = "";
                    System.out.println("出钢记号------------");
                    for (int i = 15; i < 16; i++) {

                        s10 = str.substring(index, index + len[i]);
                        System.out.println(s10);
                        index += len[i];
                    }
                    System.out.println("钢区工艺路径代码------------");
                    for (int i = 16; i < 17; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    String s11 = " ";
                    System.out.println("工序路径------------");
                    for (int i = 17; i < 18; i++) {

                        s11 = str.substring(index, index + len[i]);
                        System.out.println(s11);
                        index += len[i];


                    }

                    System.out.println("精练路径------------");
                    for (int i = 18; i < 19; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("BOF炉号------------");
                    for (int i = 19; i < 20; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("AODFlag------------");
                    for (int i = 20; i < 21; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("AOD炉号------------");
                    for (int i = 21; i < 22; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    System.out.println("合金熔化炉炉号------------");
                    for (int i = 22; i < 23; i++) {

                        String s = str.substring(index, index + len[i]);
                        System.out.println(s);
                        index += len[i];
                    }
                    //                        System.out.println("连铸机号------------");
                    //                        for (int i = 16; i < 17; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("连铸较次机号------------");
                    //                        for (int i = 17; i < 18; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("浇次内总炉数------------");
                    //                        for (int i = 18; i < 19; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("浇次内顺序号------------");
                    //                        for (int i = 19; i < 20; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("脱硫指示------------");
                    //                        for (int i = 20; i < 21; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("吹氩指示------------");
                    //                        for (int i = 21; i < 22; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("换中间包标记------------");
                    //                        for (int i = 22; i < 23; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("脱P脱C指示------------");
                    //                        for (int i = 23; i < 24; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("KR处理开始时间------------");
                    //                        for (int i = 24; i < 25; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("BOF炉开吹时刻------------");
                    //                        for (int i = 25; i < 26; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("BOF炉出钢终时刻------------");
                    //                        for (int i = 26; i < 27; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("AOD炉开吹时刻------------");
                    //                        for (int i = 28; i < 29; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("AOD炉出钢终时刻------------");
                    //                        for (int i = 29; i < 30; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼1开始时刻------------");
                    //                        for (int i = 30; i < 31; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //
                    //
                    //                        System.out.println("精炼1结束时刻------------");
                    //                        for (int i = 31; i < 32; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼1对应工序说明------------");
                    //                        for (int i = 32; i < 33; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼2开始时刻------------");
                    //                        for (int i = 33; i < 34; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //
                    //
                    //                        System.out.println("精炼2结束时刻------------");
                    //                        for (int i = 34; i < 35; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼2对应工序说明------------");
                    //                        for (int i = 35; i < 36; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼3开始时刻------------");
                    //                        for (int i = 36; i < 37; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //
                    //
                    //                        System.out.println("精炼3结束时刻------------");
                    //                        for (int i = 37; i < 38; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼3对应工序说明------------");
                    //                        for (int i = 38; i < 39; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼4开始时刻------------");
                    //                        for (int i = 39; i < 40; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //
                    //
                    //                        System.out.println("精炼4结束时刻------------");
                    //                        for (int i = 40; i < 41; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("精炼4对应工序说明------------");
                    //                        for (int i = 41; i < 42; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //
                    //                        System.out.println("CC要求时刻/钢包到达时刻------------");
                    //                        for (int i = 42; i < 43; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("钢包浇注始时刻------------");
                    //                        for (int i = 43; i < 44; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("钢包浇注终时刻------------");
                    //                        for (int i = 44; i < 45; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("计划钢水量------------");
                    //                        for (int i = 45; i < 46; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    //                        System.out.println("断面------------");
                    //                        for (int i = 46; i < 47; i++) {
                    //
                    //                            String s = str.substring(index, index + len[i]);
                    //                            System.out.println(s);
                    //                            index += len[i];
                    //                        }
                    System.out.println("------------");
                    StringBuilder sb = new StringBuilder();
                    sb.append("0110");
                    sb.append(str.substring(0, 449));
                    sb.append(bb);
                    sb.append(String.join("", Collections.nCopies(80, " ")));
                    //System.out.println("length:" + sb.length());
                    sb.append("\n");
                    System.out.println("length:" + sb.length());
                    //如果bb输出为A，说明成功，B为失败
                    System.out.println("bb:" + sb.charAt(449));
                    //System.out.println("answer:" + sb);
                    //byte[] answerMsg = new byte[110];
                    byte[] answerMsg = sb.toString().getBytes();
                    // for(int i = 0; i < answerMsg.length; i++){
                    //  System.out.println(answerMsg[i]);
                    //}
                    outputToClient.write(answerMsg, 0, 535);

                    output.write(buf, 0, 450);
                    //output.close();

                    String a[] = {s9, s10, s11};
                    test.query(s9,a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void fuliao() throws IOException {
        int[] len = {4, 6, 8, 6, 2, 2, 1, 1, 20, 118, 50, 6, 1, 20, 5, 10};

        ServerSocket serverSocket = new ServerSocket(8004);
        System.out.println("Server started at " + new Date() + '\n');
//        Socket socket = serverSocket.accept();
//        DataInputStream inputFromClient = new DataInputStream(
//                socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(
//                socket.getOutputStream());

        FileOutputStream output = new FileOutputStream("fuliao1.txt");

        byte[] buf = new byte[450];
//        int count = 0;
        while (true) {
//            count++;
//            System.out.println(count);

            Socket socket = serverSocket.accept();
            if (socket != null) {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                inputFromClient.read(buf, 0, 450);
                String str = new String(buf);
                //s1为电文长度
                //System.out.println(len2);
                //len3为结束符

//                System.out.println(len3);
                char bb;//判断电文是否传送成功，A为成功，B为失败
                //结束符
                String len3 = Integer.toString(0x0a);
                int cc = Integer.parseInt(len3);
                int j = 0, count1 = 0;
                while (cc != 10) {
                    inputFromClient.read(buf, j, 1);
                    cc = buf[j];
                    j++;
                    count1++;
                }
                if (count1 == 449) {
                    bb = 'A';
                } else {
                    bb = 'B';
                }


                //inputFromClient.close();
                int index = 0;

                String s1 = "";
                System.out.println("电文长度------------");
                for (int i = 0; i < 1; i++) {

                    s1 = str.substring(index, index + len[i]);

                    System.out.println(s1);
                    index += len[i];
                }

                String s2 = "";
                System.out.println("电文号------------");
                for (int i = 1; i < 2; i++) {

                    s2 = str.substring(index, index + len[i]);
                    System.out.println(s2);

                    index += len[i];
                }
                String s3 = "";
                System.out.println("电文发送日期------------");
                for (int i = 2; i < 3; i++) {

                    s3 = str.substring(index, index + len[i]);

                    System.out.println(s3);
                    index += len[i];
                }
                String s4 = "";
                System.out.println("电文发送时间------------");
                for (int i = 3; i < 4; i++) {

                    s4 = str.substring(index, index + len[i]);

                    System.out.println(s4);
                    index += len[i];
                }
                String s5 = "";
                System.out.println("发送端描述码------------");
                for (int i = 4; i < 5; i++) {

                    s5 = str.substring(index, index + len[i]);

                    System.out.println(s5);
                    index += len[i];
                }
                String s6 = "";
                System.out.println("接收端描述码------------");
                for (int i = 5; i < 6; i++) {

                    s6 = str.substring(index, index + len[i]);

                    System.out.println(s6);
                    index += len[i];
                }
                String s7 = "";
                System.out.println("传送功能码------------");
                for (int i = 6; i < 7; i++) {

                    s7 = str.substring(index, index + len[i]);

                    System.out.println(s7);
                    index += len[i];
                }
                System.out.println("操作标记:------------");
                for (int i = 7; i < 8; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }

                System.out.println("辅料代码------------");
                for (int i = 8; i < 9; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("辅料名称------------");
                for (int i = 9; i < 10; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("物料名称------------");
                for (int i = 10; i < 11; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("材料类型------------");
                for (int i = 11; i < 12; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("操作码------------");
                for (int i = 12; i < 13; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("工序位置代码------------");
                for (int i = 13; i < 14; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("密度------------");
                for (int i = 14; i < 15; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("米重------------");
                for (int i = 15; i < 16; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("------------");
                StringBuilder sb = new StringBuilder();
                sb.append("0110");
                sb.append(str.substring(0, 449));
                sb.append(bb);
                sb.append(String.join("", Collections.nCopies(80, " ")));
                //System.out.println("length:" + sb.length());
                sb.append("\n");
                System.out.println("length:" + sb.length());
                //如果bb输出为A，说明成功，B为失败
                System.out.println("bb:" + sb.charAt(449));
                //System.out.println("answer:" + sb);
                //byte[] answerMsg = new byte[110];
                byte[] answerMsg = sb.toString().getBytes();
                // for(int i = 0; i < answerMsg.length; i++){
                //  System.out.println(answerMsg[i]);
                //}
                outputToClient.write(answerMsg, 0, 350);

                output.write(buf, 0, 450);
                //output.close();

            }
        }

    }


    public static void shengchanjihua() throws IOException {
        int[] len = {4, 6, 8, 6, 2, 2, 1, 2, 8, 20, 3};

        ServerSocket serverSocket = new ServerSocket(8001);
        //System.out.println("Server started at " + new Date() + '\n');
//        Socket socket = serverSocket.accept();
//        DataInputStream inputFromClient = new DataInputStream(
//                socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(
//                socket.getOutputStream());

        FileOutputStream output = new FileOutputStream("shengchanjihua1.txt");

        byte[] buf = new byte[80];
//        int count = 0;
        while (true) {
//            count++;
//            System.out.println(count);

            Socket socket = serverSocket.accept();
            if (socket != null) {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                inputFromClient.read(buf, 0, 80);
                String str = new String(buf);
                //s1为电文长度
                //System.out.println(len2);
                //len3为结束符

//                System.out.println(len3);
                char bb;//判断电文是否传送成功，A为成功，B为失败
                //结束符
                String len3 = Integer.toString(0x0a);
                int cc = Integer.parseInt(len3);
                int j = 0, count1 = 0;
                while (cc != 10) {
                    inputFromClient.read(buf, j, 1);
                    cc = buf[j];
                    j++;
                    count1++;
                }
                if (count1 == 79) {
                    bb = 'A';
                } else {
                    bb = 'B';
                }


                //inputFromClient.close();
                int index = 0;


                String s1 = "";
                System.out.println("电文长度------------");
                for (int i = 0; i < 1; i++) {

                    s1 = str.substring(index, index + len[i]);

                    System.out.println(s1);
                    index += len[i];
                }

                String s2 = "";
                System.out.println("电文号------------");
                for (int i = 1; i < 2; i++) {

                    s2 = str.substring(index, index + len[i]);
                    System.out.println(s2);

                    index += len[i];
                }
                String s3 = "";
                System.out.println("电文发送日期------------");
                for (int i = 2; i < 3; i++) {

                    s3 = str.substring(index, index + len[i]);

                    System.out.println(s3);
                    index += len[i];
                }
                String s4 = "";
                System.out.println("电文发送时间------------");
                for (int i = 3; i < 4; i++) {

                    s4 = str.substring(index, index + len[i]);

                    System.out.println(s4);
                    index += len[i];
                }
                String s5 = "";
                System.out.println("发送端描述码------------");
                for (int i = 4; i < 5; i++) {

                    s5 = str.substring(index, index + len[i]);

                    System.out.println(s5);
                    index += len[i];
                }
                String s6 = "";
                System.out.println("接收端描述码------------");
                for (int i = 5; i < 6; i++) {

                    s6 = str.substring(index, index + len[i]);

                    System.out.println(s6);
                    index += len[i];
                }
                String s7 = "";
                System.out.println("传送功能码------------");
                for (int i = 6; i < 7; i++) {

                    s7 = str.substring(index, index + len[i]);

                    System.out.println(s7);
                    index += len[i];
                }
                System.out.println("工序:------------");
                for (int i = 7; i < 8; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }

                System.out.println("年月日------------");
                for (int i = 8; i < 9; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("出钢记号------------");
                for (int i = 9; i < 10; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("炉数------------");
                for (int i = 10; i < 11; i++) {

                    String s = str.substring(index, index + len[i]);
                    System.out.println(s);
                    index += len[i];
                }
                System.out.println("------------");
                StringBuilder sb = new StringBuilder();
                sb.append("0110");
                sb.append(str.substring(0, 32));
                sb.append(bb);
                sb.append(String.join("", Collections.nCopies(80, " ")));
                //System.out.println("length:" + sb.length());
                sb.append("\n");
                System.out.println("length:" + sb.length());
                //如果bb输出为A，说明成功，B为失败
                System.out.println("bb:" + sb.charAt(32));
                //System.out.println("answer:" + sb);
                //byte[] answerMsg = new byte[110];
                byte[] answerMsg = sb.toString().getBytes();
                // for(int i = 0; i < answerMsg.length; i++){
                //  System.out.println(answerMsg[i]);
                //}
                outputToClient.write(answerMsg, 0, 118);

                output.write(buf, 0, 80);
                //output.close();


            }
        }

    }

}


class test {
    public static final String URL = "jdbc:mysql://121.4.124.123:3306/boot";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private static Connection conn=null;
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void query(String s,String[]b) {
        List<String> list=new ArrayList<>();
        List<String> list1=new ArrayList<>();

        try {
            Connection connection=test.getConnection();
            //创建statement对象
            //插入
            String sql1 = "SELECT * FROM tb_shengchanjihua where JiHuaHao=?";
            PreparedStatement ptmt1 = conn.prepareStatement(sql1);
            ptmt1.setString(1,s);
            ResultSet rs1 = ptmt1.executeQuery();
            System.out.println(sql1);
            if(!rs1.next()){
                insert(b);
            }
               //更新
               String sql = "SELECT JiHuaHao FROM tb_shengchanjihua ";
               PreparedStatement ptmt = conn.prepareStatement(sql);
               //ptmt.setString(1,s);
               ResultSet rs = ptmt.executeQuery();

               while(rs.next()){
                   list.add(rs.getString(1));
               }

               String jihuahao[] = (String[])list.toArray(new String[list.size()]);
               for(int ji=0;ji<jihuahao.length;ji++){
                   if(jihuahao[ji].equals(s)){
                       update(b,ji+1);
                   }
               }
       //刪除

            String sql2 = "SELECT JiHuaHao FROM tb_shengchanjihua ";
            PreparedStatement ptmt2 = conn.prepareStatement(sql2);
            ResultSet rs2 = ptmt2.executeQuery();
            while(rs2.next()){
                list1.add(rs2.getString(1));
            }
            String str="00000000";

            String jihuahao1[] = (String[])list1.toArray(new String[list1.size()]);
            for(int ji=0;ji<jihuahao1.length;ji++){
                if(jihuahao1[ji].equals(str)){
                   delete(ji+1);
                }
            }

        } catch (Exception es) {
            es.printStackTrace();
        }
    }

    public static void insert(String[]a){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into tb_shengchanjihua (JiHao,JiHuaHao,GongYiLuJing) values(?,?,?)");
            ps.setString(1, a[1]);
            ps.setString(2, a[0]);
            ps.setString(3, a[2]);
            //执行
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void update(String []a,Integer x){
        //更新update

        try {
            String update_sql = "update  tb_shengchanjihua set GongYiLuJing=? where ID=?";
            PreparedStatement ptmt = conn.prepareStatement(update_sql); //预编译SQL，减少sql执行
            //传参
            ptmt.setString(1, a[2]);
            ptmt.setInt(2,x);
            ptmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }

    }
    public static void delete(Integer a){
        try {
            //删除 delete
            String delete_sql = "delete from tb_shengchanjihua where id=?";
            PreparedStatement ptmt1 = conn.prepareStatement(delete_sql);
            //传参
            ptmt1.setInt(1,a);
            //执行
            ptmt1.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

