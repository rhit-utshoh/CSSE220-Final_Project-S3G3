package brain;

import java.util.Random;

public class ADHDBrain implements CognitiveBrain {

    private final Random rand = new Random();

    @Override
    public boolean allowMovement() {
        // Occasionally ignores input (about 1 out of 5 updates, it' just for now to check..)
        return rand.nextInt(5) != 0;
    }
}
