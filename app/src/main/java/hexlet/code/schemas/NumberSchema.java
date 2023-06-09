package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    {
        init = o -> o == null || o instanceof Number;
        addRequirement(init);
    }
    @Override
    public NumberSchema required() {
        Predicate<Object> newReq = o -> o instanceof Integer;
        removeInitReq();
        addRequirement(newReq);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> newReq = o -> o == null || o instanceof Integer && (Integer) o > 0;
        addRequirement(newReq);
        return this;
    }

    public NumberSchema range(int n1, int n2) {
        Predicate<Object> newReq = o -> o instanceof Integer && isInRange(n1, n2, (Integer) o);
        addRequirement(newReq);
        return this;
    }

    private boolean isInRange(int floor, int ceil, int target) {
        return target >= floor && target <= ceil;
    }
}
