package cn.edu.cqu.cht.function;

import java.util.ArrayList;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:37
 */
public class Test {
    public ArrayList<String> showLogistics(String logisticsState) {
        StringBuilder temp = new StringBuilder();
        ArrayList<String> logistics = new ArrayList<>();
        for (int i = 0; i < logisticsState.length(); i++) {
            if (logisticsState.charAt(i) != '-') {
                temp.append(String.valueOf(logisticsState.charAt(i)));
            } else {
                logistics.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        return logistics;
    }

    private static Test instance;

    public static Test getInstance() {
        if (instance == null) {
            instance = new Test();
        }
        return instance;
    }

    private Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        String logisticsState = "1-2-3-4-5-";
        ArrayList<String> show = test.showLogistics(logisticsState);
        for (String s : show) {
            System.out.println(s);
        }
    }
}
