package rjava;

/*
seoul_new.txt 파일을 읽어서 wordcloud 그래프 생성하기.
파일의 위치
 */

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;

public class RserveEx2 {
    public static void  main (String[] args) throws REngineException, REXPMismatchException {
        RConnection c = new RConnection();
        String path = "G:/R/data/";
        String file = "seoul_new.txt";
        c.parseAndEval("setwd('" + path + "')");
        c.parseAndEval("library(KoNLP)");
        c.parseAndEval("library(wordcloud)");
        c.parseAndEval("library(RColorBrewer)");
        c.parseAndEval("useSejongDic()");
        c.parseAndEval("data1=readLines('" + file + "')");
        c.parseAndEval("data2 = sapply(data1, extractNoun, USE.NAMES=F)");
        c.parseAndEval("data3 = unlist(data2)");
        c.parseAndEval("data3 = gsub('\\\\d+','',data3)");
        c.parseAndEval("data3 = gsub('서울시','',data3)");
        c.parseAndEval("data3 = gsub('서울','',data3)");
        c.parseAndEval("data3 = gsub(' ','',data3)");
        c.parseAndEval("data3 = gsub(' ','',data3)");
        c.parseAndEval("data3 = gsub('OO','',data3)");
        c.parseAndEval("write(unlist(data3), 'seoul_2.txt')");
        c.parseAndEval("data4 = readLines('seoul_2.txt')");
        c.parseAndEval("data4 = Filter(function(x) {nchar(x) >= 2}, data4)");
        c.parseAndEval("wordcount = table(data4)");
        c.parseAndEval("palete = brewer.pal(9, 'Set3')");
        c.parseAndEval("wordcloud(names(wordcount),\n" +
                "freq = wordcount,\n" +
                "scale = c(5,1), # 글자크기 지정 1~5\n" +
                "rot.per = 0.25, # 글자 배치\n" +
                "min.freq = 1, # 출력될 최소 단어의 갯수\n" +
                "random.order = F, # 글자 배치를 규칙대로\n" +
                "random.color = T, # 글자 색상은 랜덤으로\n" +
                "colors = palete) # 색상의 영역");
        c.parseAndEval("legend(0.3, 1, \"서울시 응답소 요청사항 분석\",\n" +
                "cex = 0.8, # 글자 크기\n" +
                "fill = NA,\n" +
                "border = NA,\n" +
                "bg = \"white\",\n" +
                "text.col = \"red\",\n" +
                "text.font = 2,\n" +
                "box.col = \"red\")");
        c.parseAndEval("savePlot('wordcloud1.png', type='png')");
        c.parseAndEval("dev.off()");
        c.close();
    }
}
