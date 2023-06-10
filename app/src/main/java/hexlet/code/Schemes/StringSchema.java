package hexlet.code.Schemes;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    {
        init = o -> o == null || o instanceof String && ((String) o).isEmpty();
        addRequirement(init);
    }
    @Override
    public StringSchema required() {
        Predicate<Object> newReq = o -> o instanceof String && !((String) o).isEmpty();
        removeInitReq();
        addRequirement(newReq);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<Object> newReq = o -> ((String) o).contains(str);
        addRequirement(newReq);
        return this;
    }

    public StringSchema minLength(int num) {
        Predicate<Object> newReq = o -> o.toString().length() >= num;
        addRequirement(newReq);
        return this;
    }
}
