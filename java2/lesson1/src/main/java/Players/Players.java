package Players;
import Barriers.*;

public interface Players {

    void run();

    void jump();

    void info();

    int getRunLimit();

    int getJumpLimit();

    String getName();
}
