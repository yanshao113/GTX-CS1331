import java.util.Arrays;
public class BlueAstronaut extends Player implements Crewmate{
    private int numTasks;
    private int taskSpeed;
    public static final int DEFAULT_NUMTASKS = 6;
    public static final int DEFAULT_TASKSPEED = 10;
    public static final int DEFAULT_SUSLEVEL =15;
    private boolean cplTskfirsttime = false;
    public BlueAstronaut(String name,int susLevel,int numTasks,int taskSpeed){
        super(name,susLevel);
        this.numTasks =numTasks;
        this.taskSpeed = taskSpeed;
    }
    public BlueAstronaut(String name){
        this(name,DEFAULT_SUSLEVEL,DEFAULT_NUMTASKS,DEFAULT_TASKSPEED);
    }
    public void emergencyMeeting(){
        if(!this.isFrozen()) {
            Player[] players = Player.getPlayers();
            Arrays.sort(players);
            int len = players.length - 1;
            for (int i = len; i >= 0; i--) {
                if (!players[i].isFrozen()) {
                    for(int j = i-1; j>=0;j--){
                        if(!players[j].isFrozen()){
                            if(players[i].compareTo(players[j])!=0){
                                players[i].setFrozen(true);
                                return;
                            }
                                return;
                        }
                    }
                }
            }
        }gameOver();
    }
    public void completeTask(){
        if(!this.isFrozen()){
            if(this.taskSpeed>20){
                if(this.numTasks<2){
                    this.setNumTasks(0);
                    if(!this.cplTskfirsttime){
                        System.out.println("I have completed all my tasks");
                        this.cplTskfirsttime =true;
                    }
                }else{
                    this.setNumTasks(this.numTasks-2);
                }

            }else{
                if(this.numTasks<1){
                    this.setNumTasks(0);
                    if(!this.cplTskfirsttime) {
                        System.out.println("I have completed all my tasks");
                        this.cplTskfirsttime = true;
                    }
                }else{
                    this.setNumTasks(this.numTasks-1);
                }

            }
        }

    }
    public boolean equals(Object o){
        if(o instanceof BlueAstronaut){
            BlueAstronaut player = (BlueAstronaut) o;
            if(this.getName().equals(player.getName()) && (this.isFrozen()==player.isFrozen())&&(this.getSusLevel()==player.getSusLevel())){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String frozenornot;
        if(this.isFrozen()){
            frozenornot = "frozen";

        }else{
            frozenornot = "not frozen";
        }
        if(this.getSusLevel()>15){
            return String.format("MY NAME IS %s, AND I HAVE A SUSLEVEL OF %d. I AM CURRENTLY %s. I HAVE %d LEFT OVER.", this.getName().toUpperCase(),this.getSusLevel(),frozenornot.toUpperCase(),this.numTasks);
        }else{
            return String.format("My name is %s, and I have a suslevel of %d. I am currently %s. I have %d left over.",this.getName(),this.getSusLevel(),frozenornot,this.numTasks);
        }
    }
    public int getNumTasks(){
        return this.numTasks;
    }
    public void setNumTasks(int newNumTasks){
        this.numTasks = newNumTasks;
    }
    public int getTaskSpeed(){
        return this.taskSpeed;
    }
    public void setTaskSpeed(int newTaskspeed){
        if(newTaskspeed>0){
            this.taskSpeed = newTaskspeed;
        }
    }
}
