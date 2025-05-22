package koreaIT;

import koreaIT.container.Container;
import koreaIT.controller.ArticleController;
import koreaIT.controller.MemberController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public App() {
        Container.init();
    }

    public void run() {

        System.out.println("== 프로그램 시작 ==");
        Scanner sc = Container.sc;

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            // DB conntion
            Connection conn = null;

            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 로딩 실패" + e);
            }

            String url = "jdbc:mariadb://127.0.0.1:3306/AM_JDBC_2025_05?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";

            try {
                conn = DriverManager.getConnection(url, "root", "");
//                System.out.println("연결 성공!");

                Container.conn = conn;
                int actionResult = doAction(cmd);

                if (actionResult == -1) {
                    System.out.println("== 프로그램 종료 ==");
                    sc.close();
                    break;
                }
            } catch (SQLException e) {
                System.out.println("에러 : " + e);
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // DB connection 까지

        }

    }

    private int doAction(String cmd) {
        MemberController memberController = Container.memberController;
        ArticleController articleController = Container.articleController;

        if (cmd.equals("exit")) {
            return -1;
        } else if (cmd.equals("member logout")) {
            memberController.doLogout();
        } else if (cmd.equals("member login")) {
            memberController.doLogin();
        } else if (cmd.equals("member join")) {
            memberController.doJoin();
        } else if (cmd.startsWith("article delete")) {
            articleController.doDelete(cmd);
        } else if (cmd.startsWith("article detail")) {
            articleController.showDetail(cmd);
        } else if (cmd.startsWith("article modify")) {
            articleController.doModify(cmd);
        } else if (cmd.equals("article write")) {
            articleController.doWrite();
        } else if (cmd.startsWith("article list")) {
            articleController.showList(cmd);
        } else {
            System.out.println("사용할 수 없는 명령어입니다.");
        }

        return 0;
    }

}
