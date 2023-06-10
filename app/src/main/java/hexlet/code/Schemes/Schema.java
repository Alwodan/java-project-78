package hexlet.code.Schemes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Schema {
    private final List<Predicate<Object>> requirements = new ArrayList<>();

    abstract void required();

    public boolean isValid(Object obj) {
        for (Predicate<Object> req : requirements) {
            if (!req.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected void addRequirement(Predicate<Object> req) {
        requirements.add(req);
    }

    protected void removeAllPredicates() {
        requirements.clear();
    }
}
