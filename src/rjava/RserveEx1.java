package rjava;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

// 한글 깨짐 방지
// Rserve(args="--RS-encoding utf8")

// R과 자바 연결
// Rserve()

public class RserveEx1 {
    public static void main(String[] args) throws RserveException, REXPMismatchException {
        RConnection c = new RConnection();
        REXP x = c.eval("1 + 2");
        System.out.println("R 결과 : " + x.asInteger());
        c.close();
    }
}
