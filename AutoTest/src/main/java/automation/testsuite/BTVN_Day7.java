package automation.testsuite;

import org.testng.annotations.Test;

import java.util.Scanner;

public class BTVN_Day7 {

    @Test
    public void NhanVien(){
        String[] nhanVien = new String[5];
        nhanVien[0] = "Nguyen Van A";
        nhanVien[1] = "Nguyen Van B";
        nhanVien[2] = "Nguyen Van C";
        nhanVien[3] = "Nguyen Van D";
        nhanVien[4] = "Nguyen Van E";
        for (int i = 0; i < nhanVien.length; i++) {
            System.out.println(nhanVien[i]);
        }
    }
}
