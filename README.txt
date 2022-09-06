leetcode插件文件名和模板配置

tip：如果准备换个文件目录刷题时，打开设置，先更换TempFilePath，再去修改模板中package的导入

fileName:
lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})

custom template:
package LeetCode.editor.cn;

public class lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(Project.String[] args) {
        Solution solution = new lc${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();

    }

${question.code}
}

