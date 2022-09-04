leetcode

fileName:
lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})

custom template:
package LeetCode.editor.cn;

public class lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();

    }

${question.code}
}

