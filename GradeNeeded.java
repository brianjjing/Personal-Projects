import java.util.Scanner;

public class GradeNeeded {

    public void CalculusGradeNeeded(){  
        Scanner Input = new Scanner(System.in);

        System.out.println("How many points do you have in the 'coursework' category?");
        double CourseworkPoints = Double.valueOf(Input.nextLine());
        System.out.println("What is the maximum amount of points you can have in the 'coursework' category?");
        double TotalCourseworkPoints = Double.valueOf(Input.nextLine());
        double CourseworkGrade = (CourseworkPoints / TotalCourseworkPoints);

        System.out.println("How many points do you have in the 'exams' category?");
        double ExamsPoints = Double.valueOf(Input.nextLine());
        System.out.println("What is the maximum amount of points you can have in the 'exams' category?");
        double TotalExamsPoints = Double.valueOf(Input.nextLine());
        double ExamsGrade = (ExamsPoints / TotalExamsPoints);

        System.out.println("What is your desired grade in the class after this next exam, as a percent of 100? Do not include the percent sign.");
        double DesiredGrade = Double.valueOf(Input.nextLine());

        System.out.println("How many points is your next exam?");
        double TotalNextExamPoints = Double.valueOf(Input.nextLine());

        System.out.println("Is the grade out for your semester final yet? Respond with either 'yes' or 'no' in all lowercase.");
        String DidFinal = Input.nextLine();
            if ("yes".equals(DidFinal)) {
                System.out.println("How many points did you receive on your final?");
                double FinalPoints = Double.valueOf(Input.nextLine());
        
                System.out.println("How many points was your final out of?");
                double TotalFinalPoints = Double.valueOf(Input.nextLine());

                double FinalGrade = (FinalPoints/TotalFinalPoints);

                double ExamPointsNeeded = ((DesiredGrade-10*CourseworkGrade-25*FinalGrade)/65)*(TotalExamsPoints+TotalNextExamPoints)-ExamsPoints;
                System.out.println("You need " + ExamPointsNeeded + "/" + TotalNextExamPoints + ", or " + 100*Double.valueOf(ExamPointsNeeded/TotalNextExamPoints) + "% on the next test to get " + DesiredGrade + "% in the class.");
            }


            else if ("no".equals(DidFinal)) {
                System.out.println("Is your next exam a final exam or a normal test/quiz? Respond with either 'final' or 'normal' in all lowercase.");
                String NextTest = Input.nextLine();
                    if ("final".equals(NextTest)) {
                        double FinalPointsNeeded = ((DesiredGrade - 10*CourseworkGrade - 65*ExamsGrade)/25)*TotalNextExamPoints;
                        System.out.println("You need " + FinalPointsNeeded + "/" + TotalNextExamPoints + ", or " + 100*Double.valueOf(FinalPointsNeeded/TotalNextExamPoints) + "% on the final to get " + DesiredGrade + "% in the class.");
                    }
                    else if ("normal".equals(NextTest)) {
                        double ExamPointsNeeded = ((75*DesiredGrade/100-10*CourseworkGrade)/65)*(TotalExamsPoints+TotalNextExamPoints)-ExamsPoints;
                        System.out.println("You need " + ExamPointsNeeded + "/" + TotalNextExamPoints + ", or " + 100*Double.valueOf(ExamPointsNeeded/TotalNextExamPoints) + "% on the next test to get " + DesiredGrade + "% in the class.");
                    }
                    else {
                        System.out.println("Please enter either 'final' or 'normal' in all lowercase.");
                    }
                    }

            else {
                System.out.println("Please enter either 'yes' or 'no' in all lowercase.");
            }           
        Input.close();     
            }
        }