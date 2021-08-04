import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/boot";

        // 数据库的用户名与密码，需要根据自己的设置
        final String USER = "root";
        final String PASS = "12345678";

        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            // 把Driver类装载进jvm
            Class.forName("com.mysql.cj.jdbc.Driver");


            // 打开链接
            System.out.println("连接数据库...");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println(" 实例化Statement对...");
            //创建statement对象
            stmt = (Statement) conn.createStatement();

            //查询
            String sql = "SELECT * FROM tb_shengchanjihua";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // 通过字段检索
                int ID = rs.getInt("ID");
                String Luci = rs.getString("Luci");
                String JiHao = rs.getString("JiHao");
                String GongYiLuJing=rs.getString("GongYiLuJing");
                // 输出数据
                System.out.print("ID: " + ID);
                System.out.print(",炉次: " + Luci);
                System.out.print(", 记号：" + JiHao);
                System.out.print(",工艺路径: " + GongYiLuJing);

                System.out.print("\n");
            }
            //更新update
             String update_sql = "update  tb_shengchanjihua set GongYiLuJing='EOFVOD1BOF' where ID=1";
             stmt.execute(update_sql);

            //增加insert
                String inset_sql = "insert into tb_shengchanjihua (Luci,JiHao,GongYiLuJing) values(\"脱磷炉\", \"BCJD04\",  \"BOFDEOVOD\")";
                int i = stmt.executeUpdate(inset_sql);

            //删除 delete
                String delete_sql = "delete from tb_shengchanjihua";
                //stmt.execute(delete_sql);

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
        System.out.println("jdbc_test_end!");

    }
}
