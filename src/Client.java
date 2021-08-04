import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;



public class Client {


    public static void main(String[] args) throws Exception {
        FileInputStream fr1=new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\shengchanjihua1.txt");
        FileInputStream fr2=new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\fuliao1.txt");
        FileInputStream fr3=new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\cheliangguobang1.txt");
        FileInputStream fr4=new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\chugang1.txt");

        byte[] buf = new byte[29];
        byte[] revBuf = new byte[29];
        //int num1 = fr1.read(buf);
         //int num2 = fr2.read(buf);
//         int num3 = fr3.read(buf);
       int num4 = fr4.read(buf);



        Socket socket = new Socket("localhost", 8000);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.write(buf, 0, 29);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        fromServer.read(revBuf, 0, 29);


        //开启多个线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    shengchanjihua1();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fuliao1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    chugang1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    cheliangguobang1();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

    }

    public static void cheliangguobang1() throws Exception {
        FileInputStream fr = new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\cheliangguobang.txt");
        byte[] buf = new byte[950];
        byte[] revBuf = new byte[950];
        int num = fr.read(buf);
        //System.out.println(num);


        Socket socket = new Socket("localhost", 8002);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.write(buf, 0, 950);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        fromServer.read(revBuf, 0, 950);
        for (int i = 0; i < revBuf.length; i++) {

            System.out.println(revBuf[i]);

        }

        //toServer.close();
        toServer.flush();

    }


    public static void chugang1() throws Exception {
        FileInputStream fr = new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\chugang.txt");
        byte[] buf = new byte[535];
        byte[] revBuf = new byte[535];
        int num = fr.read(buf);
        //System.out.println(num);


        Socket socket = new Socket("localhost", 8003);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.write(buf, 0, 535);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        fromServer.read(revBuf, 0, 535);
        for (int i = 0; i < revBuf.length; i++) {
            System.out.println(revBuf[i]);
        }
        //toServer.close();
        toServer.flush();

    }


    public static void fuliao1() throws Exception {
        FileInputStream fr = new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\fuliao.txt");
        byte[] buf = new byte[350];
        byte[] revBuf = new byte[350];
        int num = fr.read(buf);
        //System.out.println(num);


        Socket socket = new Socket("localhost", 8004);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.write(buf, 0, 350);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        fromServer.read(revBuf, 0, 350);
        for (int i = 0; i < revBuf.length; i++) {
            System.out.println(revBuf[i]);
        }
        //toServer.close();
        toServer.flush();

    }


    public static void shengchanjihua1() throws Exception {
        FileInputStream fr = new FileInputStream("C:\\Users\\wuxuemei\\Desktop\\Client\\shengchanjihua.txt");
        byte[] buf = new byte[118];
        byte[] revBuf = new byte[118];
        int num = fr.read(buf);


        //System.out.println(num);


        Socket socket = new Socket("localhost", 8001);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        toServer.write(buf, 0, 118);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        fromServer.read(revBuf, 0, 118);
        for (int i = 0; i < revBuf.length; i++) {
            System.out.println(revBuf[i]);
        }
        //toServer.close();
        toServer.flush();



    }


}

