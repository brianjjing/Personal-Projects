import java.util.Scanner;

public class WorkoutMaker {
    String[][] exercises = {{"chest", "Bench Press", "Dumbbell Flies", "Incline Bench Press", "Dips", "Cable Crossover", "Pec Deck"}, {"shoulders", "Lateral Raise", "Shoulder Press", "Rear Delt Fly", "Arnold Press"}, {"biceps/forearms", "Bicep Curls", "Hammer Curls", "Wrist Curls", "Preacher Curls", "Chin Ups"}, {"triceps", "Skullcrusher", "Tricep Pushdown", "Tricep Extension"}, {"back", "Deadlift", "Pull Ups", "Lat Pulldown", "Rows","Seated Rows", "Hyperextensions", "Shrugs"}, {"quads", "Squat", "Hack Squat", "Leg Extension", "Leg Press"}, {"hamstrings", "Hamstring Curl", "RDL", "Stiff Leg Deadlift"}, {"glutes", "Hip Thrusts", "Glute Kickback", "Sumo Deadlift", "Bulgarian Split Squat"}, {"calves", "Standing Calf Raises", "Seated Calf Raises"}, {"abs", "Hanging Leg Raise", "Medicine Ball Throws", "Weighted Crunches"}};
    
    public void workoutMaker() {
        //Step 1: Collecting Input
        Scanner input = new Scanner(System.in);
        System.out.println("What muscles do you want to work out, and in what order? Please type up to ten of the following, separated with a comma BUT NO SPACES: 'chest', 'shoulders', 'biceps/forearms', 'triceps', 'back', 'quads', 'hamstrings', 'glutes', 'calves', 'abs'. Example: chest,shoulders,triceps.");
        String[] musclesWorked = input.nextLine().split(",");
        for (String i : musclesWorked) {
            if (i.equals("chest") == false && i.equals("shoulders") == false && i.equals("biceps/forearms") == false && i.equals("triceps") == false && i.equals("back") == false && i.equals("quads") == false && i.equals("hamstrings") == false && i.equals("glutes") == false && i.equals("calves") == false && i.equals("abs") == false) {
                System.out.println("Please type valid muscles to work out.");
                return;
            }
        }
        System.out.println("Are you looking to increase muscular strength, size, or endurance? Please select only one. Type “st” for strength, “si” for size, or “e” for endurance.");
        String exerciseType = input.nextLine();
        if (exerciseType.equals("st") == false && exerciseType.equals("si") == false && exerciseType.equals("e") == false) {
            input.close();
            System.out.println("Please type either 'st', 'si', or 'e'.");
            return;
        }
        System.out.println("How long would you like the workout to be? Please type a multiple of 30. The maximum time is 3 hours (180 minutes) and the minimum time is 30 minutes. This does not include warmup or cooldown.");
        int workoutTime = input.nextInt();
        if (workoutTime % 30 != 0 || workoutTime > 180) {
            input.close();
            System.out.println("Please type a multiple of 30 between 30 and 180.");
            return;
        }
        
        //Step 2: The main algorithm (getting the exercises).
        int timePerMuscle = workoutTime / musclesWorked.length;
        int totalSetsPerMuscle = timePerMuscle / 3;
        int exercisesPerMuscle = totalSetsPerMuscle / 4;
        if (totalSetsPerMuscle == 0) {
            totalSetsPerMuscle = 1;
        }
        if (exercisesPerMuscle == 0) {
            exercisesPerMuscle = 1;
        }
        String[] workoutExercises = new String[exercisesPerMuscle * musclesWorked.length];
        int exerciseCounter = 0; 
        for (String a : musclesWorked) {
            for (int b = 0; b < exercisesPerMuscle; b++) {
                for (int c = 0; c < 10; c++) {
                    if (a.equals(exercises[c][0])) {
                        workoutExercises[exerciseCounter] = exercises[c][(int) Math.random() * (exercises[c].length - 1) + 1];
                        exerciseCounter++;
                    }
                }
            }
            
        }

        //Step 3: Displaying the output.
        input.close();
        if (exerciseType.equals("st")) {
            System.out.println("Pick a weight or variation of these exercises that you can do until failure in the specified rep range.");
            for (String i : workoutExercises) {
                System.out.println(totalSetsPerMuscle + " sets of " + i + " for 3-5 reps each set. Rest for 3 minutes between sets.");
            }
        }
        if (exerciseType.equals("si")) {
            System.out.println("Pick a weight or variation of these exercises that you can do until failure in the specified rep range.");
            for (String i : workoutExercises) {
                System.out.println(totalSetsPerMuscle + " sets of " + i + " for 8-12 reps each set. Rest for 2 minutes between sets.");
            }
        }
        if (exerciseType.equals("e")) {
            System.out.println("Pick a weight or variation of these exercises that you can do until failure in the specified rep range.");
            for (String i : workoutExercises) {
                System.out.println(totalSetsPerMuscle + " sets of " + i + " for 15-20 reps each set. Rest for 1 minute between sets.");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        WorkoutMaker legDay = new WorkoutMaker();
        legDay.workoutMaker();
    }
}