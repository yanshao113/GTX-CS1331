import java.util.Arrays;
public class RedAstronaut extends Player implements Impostor,Comparable<Player>{
    private String skill;
    public static final String defaultSkill = "experienced";
    public static final int defaultSusLevel = 15;
    public RedAstronaut(String name, int susLevel, String skill){
        super(name,susLevel);
        this.skill = skill;
    }
    public RedAstronaut(String name){
        this(name,defaultSusLevel, defaultSkill);
    }

    @Override
    public void emergencyMeeting() {
        if(!this.isFrozen()) {
            Player[] players = Player.getPlayers();
            Arrays.sort(players);
            int len = players.length - 1;
            for (int i = len; i >= 0; i--) {
                if (!players[i].isFrozen()&&(!this.equals(players[i]))) {
                    for(int j = i-1; j>=0;j--){
                        if(!players[j].isFrozen()){
                            if (players[i].compareTo(players[j]) != 0) {
                                players[i].setFrozen(true);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } gameOver();
    }
    @Override
    public void freeze(Player p){
        if(this.isFrozen() || p.isFrozen() || (p instanceof Impostor)){
            return;
        }
        if(this.getSusLevel() < p.getSusLevel()){
            p.setFrozen(true);
        }else{
            int tmp_suslevel = this.getSusLevel();
            this.setSusLevel(tmp_suslevel*2);
        }
        super.gameOver();
    }
    @Override
    public void sabotage(Player p){
        if(this.isFrozen() || p.isFrozen() || (p instanceof Impostor)){
            return;
        }
        int tmp_suslevel = p.getSusLevel();
        if(this.getSusLevel()<20){
            p.setSusLevel((int)(tmp_suslevel * 1.5));
        }else{
            p.setSusLevel((int)(tmp_suslevel * 1.25));
        }
    }

    public boolean equals(Object o){
        if(o instanceof RedAstronaut){
            RedAstronaut player = (RedAstronaut) o;
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
            return String.format("MY NAME IS %s, AND I HAVE A SUSLEVEL OF %d. I AM CURRENTLY %s. I AM AN %s PLAYER!", this.getName().toUpperCase(),this.getSusLevel(),frozenornot.toUpperCase(),this.skill.toUpperCase());
        }else{
            return String.format("My name is %s, and I have a suslevel of %d. I am currently %s. I am an %s player!",this.getName(),this.getSusLevel(),frozenornot,this.skill);
        }
    }
    public String getSkill(){
        return this.skill;
    }
    public void setSkill(String newSkill) {
        this.skill = newSkill;
    }

}
