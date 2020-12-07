package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;
    
    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    @Override
    public boolean matches(Player p) {
        for(var m : matchers) {
            if (m.matches(p)){
                return true;
            }
        }
        return false;
    }
}
