# 实验11（补充）：有序链表

## 实验要求

实现“有序链表”工具类，使表中各节点的数值维持升序（由小到大，可以相等）

参照代码模板，实现以下功能：

- 创建：类名为`OrderedList`，实现构造方法，初始为空表。
- 添加：`void add(int value);` 创建含数值的节点，添加到表中合适的位置，保持升序。
- 查找：`boolean find(int value);` 数值存在返回`true`，否则返回`false`。
- 计数：`int count(int value);` 统计含有目标值的节点个数并返回。
- 删除：`boolean remove(int value);` 如找到首个含目标值的节点则删除并返回`true`，否则返回`false`。
- 合并：`void merge(OrderedList lst);` 合并两个有序表（当前实例和参数实例）并保持有序。结果保存在当前实例，参数实例置为空。
- 输出：`String toString();` 将表中内容仿照数组形式输出为字符串。

推荐用**VSCode**或**IDEA**编辑本Markdown文件。

## 实验报告

- 姓名：**请填写**
- 学号：**请填写**
- 心得：**请填写**
  - 有序链表类有何优缺点？能作为词典用吗？
  - 有序链表类能继承普通的链表类吗？
  - 断言和单元测试的体会。

## 实验代码

- 以下示例代码中`TODO`注释为待实现的部分。
- **提交实验报告时请将实现功能后的完整程序粘贴到下部代码区域。**
- 由三个反引号的行之间是代码区域。

```java
/**
 * 有序链表
 */
public class OrderedList {
  /**
   * 链表节点内部类
   */
  private static class Node {
    Node next;
    int data;

    Node(int value, Node post) {
      this.next = post;
      this.data = value;
    }
  }

  private Node head; // 头节点

  /**
   * 初始化为空表
   */
  public OrderedList() {
    head = null;
  }

  /**
   * 接受不定长度数值列表的构造方法
   * @param values 可变参数
   */
  public OrderedList(int... values) {
    head = null;
    // TODO
  }

  /**
   * 获取有序表长度（元素个数）
   * @return 链表长度
   */
  public int length() {
    int n = 0;
    // TODO
    return n;
  }

  /**
   * 表中是否存在含有目标值的节点。
   * @param value 目标值
   * @return 找到则返回true，否则返回false。
   */
  public boolean exists(int value) {
    // TODO
    return false;
  }

  /**
   * 在表中查找并统计含有目标值的全部节点个数。
   * @param value 目标值
   * @return 含有目标值的全部节点个数。
   */
  public int count(int value) {
    int n = 0;
    // TODO
    return n;
  }

  /**
   * 将值添加到表中合适的位置（保持升序）
   * @param value 待添加的数值。
   */
  public void add(int value) {
    // TODO
  }

  /**
   * 从表中删除含有目标值的首个节点。
   * @param value 待删除的目标值
   * @return 找到首个并删除后返回true，找不到则返回false。
   */
  public boolean remove(int value) {
    // TODO
    return true;
  }

  /**
   * 合并两个有序表（本表和lst），结果保存在本表，lst置为空。
   * @param lst 待合并的有序表。
   */
  public void merge(OrderedList lst) {
    // TODO
  }

  /**
   * 将表的各节点值按方括号包围、逗号分隔的形式转换为字符串。形如：[1,2,2,7]
   * @return 内容字符串。
   */
  @Override
  public String toString() {
    var s = new StringBuilder();
    // TODO
    return s.toString();
  }

  /**
   * 单元测试
   * 为使用断言（assert）功能，编辑IDEA的运行配置，修改选项，添加JVM选项 -ea
   */
  public static void test() {
    var a = new OrderedList();
    assert a.length() == 0;

    a.add(2); // 添加功能
    assert a.length() == 1; // 测试长度功能
    assert !a.exists(1);
    assert a.exists(2);

    a.add(1);
    a.add(3);
    a.add(2);
    assert a.toString().equals("[1,2,2,3]"); // 测试有序性
    assert a.count(0) == 0;
    assert a.count(1) == 1;
    assert a.count(2) == 2;
    assert a.count(3) == 1;
    assert a.count(9) == 0;

    var b = new OrderedList(7, 3, 2, 1, 0);
    assert b.length() == 5;
    assert b.toString().equals("[0,1,2,3,7]");

    a.merge(b); // 合并功能
    assert a.length() == 9;
    assert b.length() == 0; // 参数实例应截断
    assert a.toString().equals("[0,1,1,2,2,2,3,3,7]");

    assert a.remove(0); // 删除首节点
    assert !a.remove(0); // 再次删除应找不到

    assert a.remove(3);
    assert a.remove(3);
    assert !a.remove(3); // 再次删除应找不到

    assert a.remove(7); // 删除尾节点
    assert a.toString().equals("[1,1,2,2,2]");
  }

  public static void main(String[] args){
    test();
  }
}
```
