package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Predicate<Object> init;
    private final List<Predicate<Object>> requirements = new ArrayList<>();

    abstract BaseSchema required();

    public final boolean isValid(Object obj) {
        for (Predicate<Object> req : requirements) {
            if (!req.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected final void addRequirement(Predicate<Object> req) {
        requirements.add(req);
    }

    protected final void removeInitReq() {
        requirements.remove(init);
    }

    protected final void removeSpecifiedReq(Predicate<Object> req) {
        requirements.remove(req);
    }
}
