package cn.roncantwritecode.leetcodejava.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ron Wu
 * @date 2022/2/9
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        int n = 3;
        List<String> result = generateParenthesis.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        StringBuffer result = new StringBuffer("");
        generateParenthesis(0, 0, n, result, results);
        return results;
    }

    private void generateParenthesis(int left, int right, int n, StringBuffer result, List<String> results) {
        // 如果左括号数量小于右括号数量，或者左右括号数量超过n，不合法
        if (left < right || left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            results.add(result.toString());
            return;
        }

        // 插入左括号
        result.append("(");
        generateParenthesis(left + 1, right, n, result, results);
        result.deleteCharAt(result.length() - 1);

        // 插入右括号
        result.append(")");
        generateParenthesis(left, right + 1, n, result, results);
        result.deleteCharAt(result.length() - 1);
    }
}
