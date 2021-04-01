import java.util.Random;

public class College {
    private int sat, cost, population, major;
    private double gpa, acceptanceRate;
    private String name;

    // Main constructor
    College(String name, int major, int cost, int population, int acceptanceRate, Double gpa, int sat) {
        this.sat = sat;
        this.cost = cost;
        this.major = major;
        this.population = population;
        this.gpa = gpa;
        this.acceptanceRate = acceptanceRate;
        this.name = name;
    }

    //Random Constructor
    College() {
        Random random = new Random();
        this.sat = random.nextInt(1200) + 400;
        this.cost = random.nextInt(10000) + 5000;
        this.major = random.nextInt(50);
        this.population = random.nextInt(20000) + 10000;
        this.gpa = (random.nextInt(99) / 100) + (random.nextInt(3) + 2);
        if(this.gpa > 4.50) {
            this.gpa = this.gpa - (random.nextDouble() + 0.2);
        }
        this.acceptanceRate = random.nextInt(99) + 1;
        this.name = getRandomName();
    }

    College(String name) {
        Random random = new Random();
        this.sat = random.nextInt(1200) + 400;
        this.cost = random.nextInt(10000) + 5000;
        this.major = random.nextInt(50);
        this.population = random.nextInt(20000) + 10000;
        this.gpa = (random.nextInt(99) / 100) + (random.nextInt(3) + 2);
        if(this.gpa > 4.50) {
            this.gpa = this.gpa - (random.nextDouble() + 0.2);
        }
        this.acceptanceRate = random.nextInt(99) + 1;
        this.name = name;
    }

    // Getters:
    public int getSAT(){return this.sat;}
    public int getCost(){return this.cost;}
    public int getMajor(){return this.major;}
    public int getPopulation(){return this.population;} 
    public double getGPA(){return this.gpa;}
    public double getAcceptanceRate(){return this.acceptanceRate;}
    public String getName(){return this.name;}

    // Setters:
    public void setSAT(int newSAT){this.sat = newSAT;}
    public void setCost(int newCost){this.cost = newCost;}
    public void setMajor(int newMajor){this.major = newMajor;}
    public void setPopulation(int newPopulation){this.population = newPopulation;}
    public void setGPA(double newGPA){this.gpa = newGPA;}
    public void setAcceptanceRate(double newAcceptanceRate){this.acceptanceRate = newAcceptanceRate;}
    public void setName(String newName){this.name = newName;}

    public String getRandomName() {
        String name;
        Random random = new Random();
        String[] firstNames = {"John", "Bryan", "Carls", "Rylee", "Colten", "Raquel", "Alyson", "Crystopher", "Niel", "Ceaser"};
        String[] thirdWord = {"School", "College", "University", "Academy", "Center of Learning"};
        String[] fourthWord = {"Colorado", "Utah", "Arizona", "Mississippi","Kentucky", ""};

        name = firstNames[random.nextInt(firstNames.length)] + " " + firstNames[random.nextInt(firstNames.length)] + " " + thirdWord[random.nextInt(thirdWord.length)] + " " + fourthWord[random.nextInt(fourthWord.length)];

        return name;
    }
}