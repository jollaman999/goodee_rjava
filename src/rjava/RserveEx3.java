package rjava;

/*
제주도여행지.txt 파일을 분석하여 제주도 추천여행지10개를 선택하여
pie 그래프(jejupie.png)와 막대그래프(jejubar.png)를 이미지파일로 생성하기
 */

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;

public class RserveEx3 {
    public static void main(String[] args) throws REngineException, REXPMismatchException {
        RConnection c = new RConnection();
        String path = "G:/R/data/";
        String file = "제주도여행지.txt";

        c.parseAndEval("setwd('" + path + "')");
        c.parseAndEval("library(KoNLP)");
        c.parseAndEval("library(stringr)");
        c.parseAndEval("useSejongDic()");
        c.parseAndEval("mergeUserDic(data.frame(readLines'" + file + "'), 'ncn'))");
        c.parseAndEval("txt = readLines('" + file + "')");
    }
}
