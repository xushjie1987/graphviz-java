/*
 * Copyright (C) 2015 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.graphviz.attribute;

/**
 *
 */
public class Arrow extends SimpleAttribute<String> {
    private Arrow(String key, String value) {
        super(key, value);
    }

    private Arrow(String value) {
        super("arrowhead", value);
    }

    public Arrow tail() {
        return key("arrowtail");
    }

    public Arrow open() {
        return value(value.charAt(0) == 'o' ? value : ("o" + value));
    }

    public Arrow left() {
        return arrowDir("l");
    }

    public Arrow right() {
        return arrowDir("r");
    }

    public Arrow and(Arrow arrow) {
        return value(arrow.value + value);
    }

    private Arrow arrowDir(String dir) {
        switch (value.charAt(0)) {
            case 'l':
            case 'r':
                return value(dir + value.substring(1));
            case 'o':
                final char s = value.charAt(1);
                return value("o" + dir + (s == 'r' || s == 'l' ? value.substring(2) : value.substring(1)));
            default:
                return value(dir + value);
        }
    }

    public static final Arrow
            BOX = new Arrow("box"),
            CROW = new Arrow("crow"),
            CURVE = new Arrow("curve"),
            DIAMOND = new Arrow("diamond"),
            DOT = new Arrow("dot"),
            ICURVE = new Arrow("icurve"),
            INV = new Arrow("inv"),
            NONE = new Arrow("none"),
            NORMAL = new Arrow("normal"),
            TEE = new Arrow("tee"),
            VEE = new Arrow("vee");
}

