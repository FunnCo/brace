import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    private static String filepath = "C:\\Users\\FunnCo\\IdeaProjects\\brace\\example.txt";


    public static String getFilepath() {
        return filepath;
    }

    public static boolean validation(char[] charsFromString) {
        boolean isValid = true;
        int countOfCloseExpected = 0;
        for (char charFromString : charsFromString) {
            if ((charFromString == '(')||(charFromString == ')')){
                if (charFromString == '('){
                    countOfCloseExpected++;
                }
                if ((charFromString == ')')&&!(countOfCloseExpected == 0)){
                    countOfCloseExpected--;
                    continue;
                }
                if ((charFromString == ')')&&(countOfCloseExpected == 0)){
                    System.out.println("Ошибка. Неожиданная закрывающая скобка");
                    isValid = false;
                }

            }
        }
        if (charsFromString[charsFromString.length-1] == '('){
            System.out.println("Ошибка. Неожиданная открывающая скобка");
        }
        if(countOfCloseExpected!=0){
            System.out.println("Ошибка. Есть незакрытые скобки");
            isValid = false;
        }
        if(isValid){
            System.out.println("Все хорошо");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        return isValid;
    }

    public static String getString() throws FileNotFoundException {
        String result = "";
        Scanner scanner = new Scanner(new FileReader(filepath));
        while (scanner.hasNext()) {
            result = result + scanner.next();
        }
        return result;
    }
}
