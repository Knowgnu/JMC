package DBF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TypeF.lStore2;
import TypeF.lMenu2;
import TypeF.lCode2;
import TypeF.Review2;

public class jmcSQL {

    Connection con = null;
    PreparedStatement pstmt;
    ResultSet rs;

    public void connect() {
        con = jmcDBC.DBConnect();
    }

    public void conClose() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 한식추천
    public String Koption() {
        String k = null;

        List<String> km = new ArrayList<>();

        if (km.size() == 0) {
            String sql = "SELECT L.MNAME2 FROM LMENU2 L, LSTORE2 S WHERE L.MCODE2 = S.MCODE2 AND FCODE2 = 10";
            try {
                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    km.add(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        int i = (int) (Math.random() * km.size());

        k = km.get(i);
        i = 0;
        return k;
    }

    // 일식추천
    public String Joption() {
        String j = null;

        List<String> jm = new ArrayList<>();

        if (jm.size() == 0) {
            String sql = "SELECT L.MNAME2 FROM LMENU2 L, LSTORE2 S WHERE L.MCODE2 = S.MCODE2 AND FCODE2 = 20";
            try {
                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    jm.add(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int i = (int) (Math.random() * jm.size());

        j = jm.get(i);
        i = 0;
        return j;
    }

    // 중식추천
    public String Coption() {
        String c = null;

        List<String> cm = new ArrayList<>();

        if (cm.size() == 0) {
            String sql = "SELECT L.MNAME2 FROM LMENU2 L, LSTORE2 S WHERE L.MCODE2 = S.MCODE2 AND FCODE2 = 30";
            try {
                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    cm.add(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int i = (int) (Math.random() * cm.size());

        c = cm.get(i);
        i = 0;
        return c;
    }

    // 양식추천
    public String Woption() {
        String w = null;

        List<String> wm = new ArrayList<>();

        if (wm.size() == 0) {
            String sql = "SELECT L.MNAME2 FROM LMENU2 L, LSTORE2 S WHERE L.MCODE2 = S.MCODE2 AND FCODE2 = 40";
            try {
                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    wm.add(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int i = (int) (Math.random() * wm.size());

        w = wm.get(i);
        i = 0;
        return w;
    }

    // 랜덤추천
    public String AllRandom() {
        String r = null;

        List<String> rm = new ArrayList<>();

        if (rm.size() == 0) {
            String sql = "SELECT MNAME2 FROM LMENU2";
            try {
                pstmt = con.prepareStatement(sql);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    rm.add(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int i = (int) (Math.random() * rm.size());

        r = rm.get(i);
        i = 0;
        return r;
    }

    // (한식)식당출력
    public String kResult(String k) {
        String kStore = null;
        String kNum = null;
        String kAddr = null;
        String kKey1 = null;
        String kKey2 = null;
        String kKey3 = null;
        String ss1 = null;

        String sql = "SELECT S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LSTORE2 S, REVIEW2 R, LMENU2 M WHERE S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, k);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                kStore = rs.getString("SNAME2");
                kNum = rs.getString("STNUM2");
                kAddr = rs.getString("SADDR2");
                kKey1 = rs.getString("SKEYWORD1");
                kKey2 = rs.getString("SKEYWORD2");
                kKey3 = rs.getString("SKEYWORD3");
                ss1 = "\n가게이름 ［ " + kStore + " ]" +
                        "\n전화번호 ［ " + kNum + " ]" +
                        "\n가게주소 ［ " + kAddr + " ]" +
                        "\n키워드리뷰 ［ " + kKey1 + " ] ［ " + kKey2 + " ] ［ " + kKey3 + " ]";
                System.out.println(ss1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss1;
    }
    //(중식)식당출력
    public String cResult(String c) {
        String cStore = null;
        String cNum = null;
        String cAddr = null;
        String cKey1 = null;
        String cKey2 = null;
        String cKey3 = null;
        String ss3 = null;

        String sql = "SELECT S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LSTORE2 S, REVIEW2 R, LMENU2 M WHERE S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cStore = rs.getString("SNAME2");
                cNum = rs.getString("STNUM2");
                cAddr = rs.getString("SADDR2");
                cKey1 = rs.getString("SKEYWORD1");
                cKey2 = rs.getString("SKEYWORD2");
                cKey3 = rs.getString("SKEYWORD3");
                ss3 = "\n가게이름 ［ " + cStore + " ]" +
                        "\n전화번호 ［ " + cNum + " ]" +
                        "\n가게주소 ［ " + cAddr + " ]" +
                        "\n키워드리뷰 ［ " + cKey1 + " ] ［ " + cKey2 + " ] ［ " + cKey3 + " ]";
                System.out.println(ss3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss3;
    }
    //(일식)식당출력
    public String jResult(String j) {
        String jStore = null;
        String jNum = null;
        String jAddr = null;
        String jKey1 = null;
        String jKey2 = null;
        String jKey3 = null;
        String ss2 = null;

        String sql = "SELECT S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LSTORE2 S, REVIEW2 R, LMENU2 M WHERE S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, j);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                jStore = rs.getString("SNAME2");
                jNum = rs.getString("STNUM2");
                jAddr = rs.getString("SADDR2");
                jKey1 = rs.getString("SKEYWORD1");
                jKey2 = rs.getString("SKEYWORD2");
                jKey3 = rs.getString("SKEYWORD3");
                ss2 = "\n가게이름 ［ " + jStore + " ]" +
                        "\n전화번호 ［ " + jNum + " ]" +
                        "\n가게주소 ［ " + jAddr + " ]" +
                        "\n키워드리뷰 ［ " + jKey1 + " ] ［ " + jKey2 + " ] ［ " + jKey3 + " ]";
                System.out.println(ss2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss2;
    }
    //(양식)식당출력
    public String wResult(String w) {
        String wStore = null;
        String wNum = null;
        String wAddr = null;
        String wKey1 = null;
        String wKey2 = null;
        String wKey3 = null;
        String ss4 = null;

        String sql = "SELECT S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LSTORE2 S, REVIEW2 R, LMENU2 M WHERE S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, w);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                wStore = rs.getString("SNAME2");
                wNum = rs.getString("STNUM2");
                wAddr = rs.getString("SADDR2");
                wKey1 = rs.getString("SKEYWORD1");
                wKey2 = rs.getString("SKEYWORD2");
                wKey3 = rs.getString("SKEYWORD3");
                ss4 = "\n가게이름 ［ " + wStore + " ]" +
                        "\n전화번호 ［ " + wNum + " ]" +
                        "\n가게주소 ［ " + wAddr + " ]" +
                        "\n키워드리뷰 ［ " + wKey1 + " ] ［ " + wKey2 + " ] ［ " + wKey3 + " ]";
                System.out.println(ss4);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss4;
    }
    // (랜덤)식당출력
    public String rResult(String r) {
        String rStore = null;
        String rNum = null;
        String rAddr = null;
        String rKey1 = null;
        String rKey2 = null;
        String rKey3 = null;
        String ss5 = null;

        String sql = "SELECT S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LSTORE2 S, REVIEW2 R, LMENU2 M WHERE S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, r);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rStore = rs.getString("SNAME2");
                rNum = rs.getString("STNUM2");
                rAddr = rs.getString("SADDR2");
                rKey1 = rs.getString("SKEYWORD1");
                rKey2 = rs.getString("SKEYWORD2");
                rKey3 = rs.getString("SKEYWORD3");
                ss5 = "\n가게이름 ［ " + rStore + " ]" +
                        "\n전화번호 ［ " + rNum + " ]" +
                        "\n가게주소 ［ " + rAddr + " ]" +
                        "\n키워드리뷰 ［ " + rKey1 + " ] ［ " + rKey2 + " ] ［ " + rKey3 + " ]";
                System.out.println(ss5);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss5;
    }
    public String pResult(String p) { //등록 출력
        String pfType = null;
        String pmName = null;
        String pStore = null;
        String pNum = null;
        String pAddr = null;
        String pKey1 = null;
        String pKey2 = null;
        String pKey3 = null;
        String ss6 = null;

        String sql = "SELECT C.FTYPE2, M.MNAME2, S.SNAME2, S.STNUM2, S.SADDR2, R.SKEYWORD1, R.SKEYWORD2, R.SKEYWORD3 FROM LCODE2 C, LSTORE2 S, REVIEW2 R, LMENU2 M WHERE C.FCODE2 = S.FCODE2 AND S.SCODE2 = R.SCODE2 AND S.MCODE2 = M.MCODE2 AND M.MNAME2 = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pfType = rs.getString("FTYPE2");
                pmName = rs.getString("MNAME2");
                pStore = rs.getString("SNAME2");
                pNum = rs.getString("STNUM2");
                pAddr = rs.getString("SADDR2");
                pKey1 = rs.getString("SKEYWORD1");
                pKey2 = rs.getString("SKEYWORD2");
                pKey3 = rs.getString("SKEYWORD3");
                ss6 =   "\n음식종류 [ " + pfType + " ] " +
                        "\n메뉴이름 [ " + pmName + " ] " +
                        "\n가게이름 ［ " + pStore + " ]" +
                        "\n전화번호 ［ " + pNum + " ]" +
                        "\n가게주소 ［ " + pAddr + " ]" +
                        "\n키워드리뷰 ［ " + pKey1 + " ] ［ " + pKey2 + " ] ［ " + pKey3 + " ]";
                System.out.println(ss6);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ss6;
    }
    public void join(lMenu2 lmenu2) { // 메뉴삽입
        String sql = "INSERT INTO LMENU2 VALUES(?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, lmenu2.getmCode2());
            pstmt.setString(2, lmenu2.getmName2());

            int result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int lMenu2() { // 메뉴코드 생성
        int mCode2 = 20;
        String sql = "SELECT MAX(MCODE2) FROM LMENU2";

        try {
            pstmt = con.prepareStatement(sql);

            // sql문 실행
            rs = pstmt.executeQuery();

            // 결과 확인
            while (rs.next()) {
                mCode2 = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mCode2;
    }

    public void join(lStore2 lstore2) { // 가게정보 삽입
        String sql = "INSERT INTO LSTORE2 VALUES(?, ?, ?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, lstore2.getsCode2());
            pstmt.setString(2, lstore2.getsName2());
            pstmt.setString(3, lstore2.getsTNum2());
            pstmt.setString(4, lstore2.getsAddr2());
            pstmt.setInt(5, lstore2.getfCode2());
            pstmt.setInt(6, lstore2.getmCode2());
            int result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int lStore2() { // 가게코드 생성
        int sCode2 = 20;
        String sql = "SELECT MAX(SCODE2) FROM LSTORE2";

        try {
            pstmt = con.prepareStatement(sql);

            // sql문 실행
            rs = pstmt.executeQuery();

            // 결과 확인
            while (rs.next()) {
                sCode2 = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sCode2;

    }

    public void join(Review2 review2) { // 키워드 삽입
        String sql = "INSERT INTO REVIEW2 VALUES(?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, review2.getsKeyword1());
            pstmt.setString(2, review2.getsKeyword2());
            pstmt.setString(3, review2.getsKeyword3());
            pstmt.setInt(4, review2.getsCode2());
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("가게등록 성공!");
            } else {
                System.out.println("가게등록 실패!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}