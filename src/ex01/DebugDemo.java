package ex01;

public class DebugDemo {
  public static void main(String[] args){
    System.out.print("H");
    System.out.print("e");
    System.out.print("l");
    System.out.print("l");
    System.out.print("o");
    System.out.print(",");
    char c = 'J';
    System.out.print(c);
    int i = 'a';
    System.out.print(i); // TODO: 使用类型转换修正错误，使输出为“Hello,Java!”
    System.out.print('v'); // TODO：这里是单引号，上面是双引号，有何区别？
    System.out.print('a');
    System.out.print('!');
  }
}
/* Ex01-Task2: 单步跟踪示例
- 用“调试”方式运行程序。绿三角右边小虫子图标。
- 左边的红点是“断点”，程序运行到含有断点的行就会停下来，等待分析。
- 输出在下方的Console标签。
- 试用热键或下方调试面板顶部按钮：
  - Step Over: F8
  - Step Into: F7
  - Step Out: Shift+F8 执行到当前函数返回（但遇到断点还会停止）
  - Run to Cursor: Alt+F9
 */
