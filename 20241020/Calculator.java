import java.util.Scanner;

abstract class Calc {
    public String errorMsg;
    protected int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract int calculate();
}

class Add extends Calc {
    @Override
    public int calculate() {
        errorMsg = null;
        return a + b;
    }
}

class Sub extends Calc {
    @Override
    public int calculate() {
        errorMsg = null;
        return a - b;
    }
}

class Mul extends Calc {
    @Override
    public int calculate() {
        errorMsg = null;
        return a * b;
    }
}

class Div extends Calc {
    @Override
    public int calculate() {
        if (b == 0) {
            errorMsg = "0으로 나눌 수 없음.";
            return 0;
        } else {
            errorMsg = null;
            return a / b;
        }
    }
}

public class Calculator {
    public Calculator() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("두 정수와 연산자를 입력하시오>>");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String operator = scanner.next();
            Calc obj;
            switch (operator) {
                case "+":
                    obj = new Add();
                    break;
                case "-":
                    obj = new Sub();
                    break;
                case "*":
                    obj = new Mul();
                    break;
                case "/":
                    obj = new Div();
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    scanner.close();
                    return;
            }
            obj.setValue(a, b);
            int res = obj.calculate();
            if (obj.errorMsg == null) {
                System.out.println("계산 결과 " + res);
            } else {
                System.out.print(obj.errorMsg);
                System.out.println(" 프로그램 종료");
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Calculator mycal = new Calculator();
        mycal.run();
    }
}
