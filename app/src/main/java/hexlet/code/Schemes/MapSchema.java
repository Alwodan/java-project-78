package hexlet.code.Schemes;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    Predicate<Object> currentSizePredicate;
    Predicate<Object> currentShapePredicate;
    {
        init = o -> o == null || o instanceof Map<?, ?>;
        addRequirement(init);
    }
    @Override
    public MapSchema required() {
        Predicate<Object> newReq = o -> o instanceof Map;
        removeInitReq();
        addRequirement(newReq);
        return this;
    }

    public MapSchema sizeof(int n) {
        removeSpecifiedReq(currentSizePredicate);
        currentSizePredicate = o -> o instanceof Map && ((Map<?, ?>) o).size() == n;
        addRequirement(currentSizePredicate);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemeMap) {
        removeSpecifiedReq(currentShapePredicate);
        currentShapePredicate = target -> {
            if (target instanceof Map<?, ?>) { //So compiler won't cry
                for (Map.Entry<String, BaseSchema> entry : schemeMap.entrySet()) {
                    String schemaKey = entry.getKey();
                    Object valueToCheck = ((Map<?, ?>) target).get(schemaKey);
                    if (!entry.getValue().isValid(valueToCheck)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        };
        addRequirement(currentShapePredicate);
        return this;
    }
}
