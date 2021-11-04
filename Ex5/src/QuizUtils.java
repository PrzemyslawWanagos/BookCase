import java.util.*;

public class QuizUtils {
    public static List<Integer> scanForInt(String prompt, int min, int max, boolean singleSelection) {
        System.out.println(prompt);
        List<Integer> toReturn = new ArrayList<>();
        String[] fromScannerDelimited;
        String fromScanner;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                fromScanner = scanner.nextLine();
                fromScannerDelimited = fromScanner.split(",");
                if (singleSelection && fromScannerDelimited.length > 1) {
                    throw new Exception("too many argumets entered");
                }
                for (int i = 0; i < fromScannerDelimited.length; i++) {
                    Integer answerInt = Integer.parseInt(fromScannerDelimited[i]);
                    if (answerInt >= min && answerInt <= max) {
                        toReturn.add(answerInt);
                    } else {
                        throw new Exception("out of specified range");
                    }
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn.clear();
            }
        } while (toReturn.size() == 0);
        return toReturn;
    }

    public static String scanForString(String prompt) {
        System.out.println(prompt);
        String toReturn = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                scanForString(prompt);
            }
        } while (Objects.equals(toReturn, ""));
        return toReturn;
    }

    public static String scanForString(String prompt, String... allowedAnswers) {
        String toReturn = "";
        do {
            System.out.println(prompt);
            System.out.println("Dopuszczalne wartosci to: ");
            System.out.println(Arrays.toString(allowedAnswers));
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
                boolean isAnswerCorrect = false;
                for (int i = 0; i < allowedAnswers.length; i++) {
                    if (toReturn.equals(allowedAnswers[i])) {
                        isAnswerCorrect = true;
                        break;
                    }
                }
                if (!isAnswerCorrect) {
                    throw new Exception("not in the list of allowed answers");
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn = "";
            }
        } while (toReturn.equals(""));
        return toReturn;
    }

}
