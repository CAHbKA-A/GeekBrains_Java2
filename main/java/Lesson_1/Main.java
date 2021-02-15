package Lesson_1;


public class Main {

    private static JumpableRunnable[] team;
    private static Object[] obstacle;

    public static void main(String[] args) {

        createTeamObstracle();
        competitions();

    }

    private static void competitions() {
        for (int i = 0; i < team.length; i++) {
            System.out.println(team[i] + " Вышел на старт");
            boolean finished = true;
            for (int j = 0; j < obstacle.length; j++) {
                System.out.println("На пути " + obstacle[j]);

                if (obstacle[j] instanceof Wall) {
                    team[i].jump();
                    if (((Wall) obstacle[j]).tryJump(team[i])) {
                        System.out.println("Перепрыгнул");
                    } else {
                        finished = false;
                        System.out.println("Не смог((");
                        break;

                    }
                } else {
                    team[i].run();
                    if (((RuningTrack) obstacle[j]).tryRun(team[i])) {
                        System.out.println("Пробежал");
                    } else {
                        finished = false;
                        System.out.println("Не добежал, выдохся((");
                        break;
                    }
                }
            }

            System.out.println(finished ? "Фингишировал" : "Выбыл из забега");
            System.out.println();
        }
    }

    private static void createTeamObstracle() {
        team = new JumpableRunnable[]{
                new Human(),
                new Cat(),
                new Droid(),
                new Human("Петя", 2, 400),
                new Cat("Барсик", 3, 40),
                new Cat("Мышка", 1, 200),
                new Droid("T1000", 12, 10000)

        };
        obstacle = new Object[]{
                new Wall(1),
                new Wall(2),
                new RuningTrack(100),
                new Wall(3),
                new Wall(4),
                new RuningTrack(300),
                new Wall(6),
                new RuningTrack(500)
        };
    }
}
