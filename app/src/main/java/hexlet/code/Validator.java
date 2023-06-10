package hexlet.code;

import hexlet.code.Schemes.MapSchema;
import hexlet.code.Schemes.NumberSchema;
import hexlet.code.Schemes.StringSchema;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }
}
